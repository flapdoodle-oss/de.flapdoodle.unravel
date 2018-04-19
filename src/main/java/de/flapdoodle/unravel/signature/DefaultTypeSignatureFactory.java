/**
 * Copyright (C) 2017
 *   Michael Mosmann <michael@mosmann.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.unravel.signature;

import java.util.function.Function;
import java.util.function.Predicate;

import de.flapdoodle.checks.Preconditions;
import de.flapdoodle.unravel.signature.TypeSignature.Field;
import de.flapdoodle.unravel.signature.TypeSignature.Method;
import de.flapdoodle.unravel.signature.TypeSignature.Uses;
import de.flapdoodle.unravel.types.AClass;
import de.flapdoodle.unravel.types.AField;
import de.flapdoodle.unravel.types.AMethod;
import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.AnAnnotation;
import de.flapdoodle.unravel.types.AnInnerClass;
import de.flapdoodle.unravel.types.Calls;
import de.flapdoodle.unravel.types.Calls.MethodCall;
import io.vavr.collection.HashMap;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Set;
import io.vavr.control.Option;

public class DefaultTypeSignatureFactory implements SignatureOfAClassFactory {

	@Override
	public TypeSignature signatureOf(AClass src, Function<ATypeName, Option<AClass>> classOfTypeName) {
		return signatureOf(src, classOfTypeName, Option.none(), HashSet.empty());
	}

	private static TypeSignature signatureOf(AClass src, Function<ATypeName, Option<AClass>> classOfTypeName, Option<Set<AccessFlags>> overrideAccessFlags,
			Set<ATypeName> visitedTypes) {
		src.annotations();

		// TODO uses

		return TypeSignature.builder(src.typeName())
				.javaVersion(src.javaVersion())
				.accessFlags(src.accessFlags())
				.superClazz(src.superClazz())
				.interfaces(src.interfaces())
				.innerClasses(innerClassesOf(src.typeName(), classOfTypeName, src.innerClasses(), visitedTypes.add(src.typeName())))
				.fields(asField(src.fields()))
				.methods(asMethod(src.methods()))
				.uses(usesOf(src))
				.usage(usagesOf(src))
				.build();
	}

	private static Usage usagesOf(AClass src) {
		CollectingUsageListener usageListener = new CollectingUsageListener();
		usagesOf(src, usageListener);
		return usageListener.aggregate();
	}

	private static void usagesOf(AClass src, UsageListener usageListener) {
		src.superClazz().ifPresent(usageListener::type);
		src.interfaces().forEach(usageListener::type);
		src.annotations().forEach(annotations -> usagesOf(annotations, usageListener));
		src.fields().forEach(field -> {
			field.annotations().forEach(annotation -> usagesOf(annotation, usageListener));
			usageListener.type(field.type().clazz());
		});
		src.methods().forEach(method -> {
			method.annotations().forEach(annotation -> usagesOf(annotation, usageListener));
			method.exceptions().forEach(usageListener::type);
			method.parameters().forEach(parameter -> usageListener.type(parameter.clazz()));
			usageListener.type(method.returnType().clazz());
			usagesOf(method.calls(), usageListener);
		});
	}

	private static void usagesOf(Calls calls, UsageListener usageListener) {
		calls.fieldCalls().forEach(fieldCall -> {
			usageListener.field(fieldCall.clazz(), fieldCall.name(), fieldCall.type(), fieldCall.staticCall());
		});

		calls.methodCalls().forEach(methodCall -> {
			usageOf(methodCall, usageListener);
		});

		calls.lambdaCalls().forEach(lambda -> {
			// TODO
			usageOf(lambda.delegate(), usageListener);
		});
	}

	private static void usageOf(MethodCall methodCall, UsageListener usageListener) {
		usageListener.method(methodCall.clazz(), methodCall.name(), methodCall.signature(), methodCall.invocationType());
	}

	private static void usagesOf(AnAnnotation annotation, UsageListener usageListener) {
		usageListener.annotation(annotation.clazz(), parametersOf(annotation));
	}

	private static Map<String, AType> parametersOf(AnAnnotation annotation) {
		// TODO - lots of things to do
		return HashMap.empty();
	}

	private static Uses usesOf(AClass src) {
		ImmutableUses.Builder builder = Uses.builder();
		fillWith(builder, src);
		return builder.build();
	}

	private static void fillWith(ImmutableUses.Builder builder, AClass src) {
		src.methods().forEach(m -> {
			Calls calls = m.calls();

			calls.typeReferenceCalls().forEach(tr -> {
				builder.addTypes(tr.clazz());
			});
			calls.fieldCalls();
		});
	}

	private static List<Method> asMethod(List<AMethod> methods) {
		return methods.map(m -> Method.builder()
				.name(m.name())
				.accessFlags(m.accessFlags())
				.returnType(m.returnType())
				.parameters(m.parameters())
				.build());
	}

	private static List<Field> asField(List<AField> fields) {
		return fields.map(f -> Field.builder()
				.name(f.name())
				.type(f.type())
				.accessFlags(f.accessFlags())
				.build());
	}

	// anon classes -> src.outerClazz is set
	// non anon classes -> no outerClazz
	private static List<TypeSignature> innerClassesOf(ATypeName typeName, Function<ATypeName, Option<AClass>> classOfTypeName, List<AnInnerClass> innerClasses,
			Set<ATypeName> visitedTypes) {
		return innerClasses.filter(innerClassesWithoutOrWithMatchingParent(typeName, visitedTypes))
				.map(inner -> {
					Option<AClass> optResolved = classOfTypeName.apply(inner.typeName());
					Preconditions.checkArgument(optResolved.isDefined(), "could not resolve %s", inner.typeName());
					return signatureOf(optResolved.get(), classOfTypeName, Option.of(inner.accessFlags()), visitedTypes);
				});
	}

	private static Predicate<? super AnInnerClass> innerClassesWithoutOrWithMatchingParent(ATypeName typeName, Set<ATypeName> visitedTypes) {
		return inner -> !inner.typeName().equals(typeName) && !visitedTypes.contains(inner.typeName())
				&& (!inner.outerName().isPresent() || inner.outerName().get().equals(typeName));
	}

}
