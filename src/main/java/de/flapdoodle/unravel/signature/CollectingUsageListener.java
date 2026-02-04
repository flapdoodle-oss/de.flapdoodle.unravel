/*
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

import de.flapdoodle.unravel.signature.Usage.UsedAnnotation;
import de.flapdoodle.unravel.signature.Usage.UsedField;
import de.flapdoodle.unravel.signature.Usage.UsedMethod;
import de.flapdoodle.unravel.signature.Usage.UsedType;
import de.flapdoodle.unravel.parser.types.AMethodSignature;
import de.flapdoodle.unravel.parser.types.AType;
import de.flapdoodle.unravel.parser.types.ATypeName;
import de.flapdoodle.unravel.parser.types.InvocationType;
import io.vavr.collection.Map;
import io.vavr.control.Option;

public class CollectingUsageListener implements UsageListener {

	Usage current = Usage.builder().build();

	@Override
	public void type(ATypeName type) {
		current = current.merge(usageOf(type));
	}

	@Override
	public void field(ATypeName clazz, String name, AType fieldType, boolean staticCall) {
		current = current.merge(usageOfField(clazz, name, fieldType, staticCall)).merge(usageOf(fieldType.clazz()));
	}

	@Override
	public void method(ATypeName clazz, String name, AMethodSignature signature, InvocationType invocationType) {
		current = current.merge(usageOfMethod(clazz, name, signature, invocationType)).merge(usageOfMethodSignature(signature));
	}

	@Override
	public void annotation(ATypeName clazz, Map<String, AType> parameters) {
		current = current.merge(usageOfAnnotation(clazz, parameters));
	}

	public Usage aggregate() {
		return current;
	}

	private static Usage usageOf(ATypeName type) {
		return Usage.builder()
				.putTypes(type, UsedType.builder().build())
				.build();
	}

	private static Usage usageOfMethodSignature(AMethodSignature signature) {
		Option<Usage> parameterUsage = signature.parameters().map(param -> usageOf(param.clazz())).reduceOption(Usage::merge);
		// TODO
		return usageOf(signature.returnType().clazz());
	}

	private static Usage usageOfField(ATypeName clazz, String name, AType fieldType, boolean staticCall) {
		return Usage.builder()
				.putTypes(clazz, UsedType.builder()
						.addFields(UsedField.builder()
								.name(name)
								.type(fieldType)
								.staticCall(staticCall)
								.build())
						.build())
				.build();
	}
	private static Usage usageOfMethod(ATypeName clazz, String name, AMethodSignature signature, InvocationType invocationType) {
		return Usage.builder()
				.putTypes(clazz, UsedType.builder()
						.addMethods(UsedMethod.builder()
								.name(name)
								.signature(signature)
								.invocationType(invocationType)
								.build())
						.build())
				.build();
	}
	private static Usage usageOfAnnotation(ATypeName clazz, Map<String, AType> parameters) {
		return Usage.builder()
				.putTypes(clazz, UsedType.builder()
						.addAnnotations(UsedAnnotation.builder()
								.parameters(parameters)
								.build())
						.build())
				.build();
	}

}
