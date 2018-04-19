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
package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;
import static de.flapdoodle.unravel.classes.Classnames.typeOf;

import java.io.IOException;
import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.Compilers;
import de.flapdoodle.unravel.JavaSource;
import de.flapdoodle.unravel.assertions.AnAnnotationsAssert;
import de.flapdoodle.unravel.assertions.FieldCallsAssert;
import de.flapdoodle.unravel.assertions.MethodCallsAssert;
import de.flapdoodle.unravel.assertions.TypeReferenceCallsAssert;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.methods.MethodCode;
import de.flapdoodle.unravel.samples.asm.methods.MethodLambdas;
import de.flapdoodle.unravel.samples.asm.methods.MethodSignatures;
import de.flapdoodle.unravel.samples.asm.methods.MethodsPlayground;
import de.flapdoodle.unravel.types.AMethodSignature;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.ImmutableAMethodSignature;
import de.flapdoodle.unravel.types.InvocationType;

public class MethodsTest {

	@Test
	public void lambdaCalls() {
		ImmutableAMethodSignature lambda8factorySignature = AMethodSignature.builder()
				.returnType(typeOf(CallSite.class))
				.addParameters(typeOf(MethodHandles.Lookup.class))
				.addParameters(typeOf(String.class))
				.addParameters(typeOf(MethodType.class))
				.addParameters(typeOf(MethodType.class))
				.addParameters(typeOf(MethodHandle.class))
				.addParameters(typeOf(MethodType.class))
				.build();

		assertThat(Classes.parse(Classes.byteCodeOf(MethodLambdas.class)))
		.isJava8()
		.methods(methods -> {
			methods.size().isEqualTo(9);
			methods.element(0).name("<init>");
			methods.element(1).name("lambdas")
				.accessFlags(AccessFlags.ACC_PUBLIC)
				.returnType(typeOf(String.class))
				.parameterTypes(typeOf(List.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(9);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(Double.class))
							.name("valueOf")
							.returnType(typeOf(Double.class))
							.parameterTypes(typeOf(double.class))
							.invocationType(InvocationType.INVOKESTATIC);
						methodCalls.element(1)
							.clazz(Classnames.nameOf(Integer.class))
							.name("valueOf")
							.returnType(typeOf(Integer.class))
							.parameterTypes(typeOf(int.class))
							.invocationType(InvocationType.INVOKESTATIC);
						methodCalls.element(2)
							.clazz(Classnames.nameOf(MethodLambdas.class))
							.name("biFunc")
							.returnType(typeOf(Object.class))
							.parameterTypes(typeOf(BiFunction.class), typeOf(Object.class), typeOf(Object.class))
							.invocationType(InvocationType.INVOKESTATIC);
						methodCalls.element(3)
							.clazz(Classnames.nameOf(MethodLambdas.class))
							.name("func")
							.returnType(typeOf(Object.class))
							.parameterTypes(typeOf(Function.class), typeOf(Object.class))
							.invocationType(InvocationType.INVOKESTATIC);
						methodCalls.element(4)
							.clazz(Classnames.nameOf(List.class))
							.name("stream")
							.returnType(typeOf(Stream.class))
							.parameterTypes()
							.invocationType(InvocationType.INVOKEINTERFACE);
						methodCalls.element(5)
							.clazz(Classnames.nameOf(Stream.class))
							.name("map")
							.returnType(typeOf(Stream.class))
							.parameterTypes(typeOf(Function.class))
							.invocationType(InvocationType.INVOKEINTERFACE);
						methodCalls.element(6)
							.clazz(Classnames.nameOf(Stream.class))
							.name("filter")
							.returnType(typeOf(Stream.class))
							.parameterTypes(typeOf(Predicate.class))
							.invocationType(InvocationType.INVOKEINTERFACE);
						methodCalls.element(7)
							.clazz(Classnames.nameOf(Stream.class))
							.name("findAny")
							.returnType(typeOf(Optional.class))
							.parameterTypes()
							.invocationType(InvocationType.INVOKEINTERFACE);
						methodCalls.element(8)
							.clazz(Classnames.nameOf(Optional.class))
							.name("orElse")
							.returnType(typeOf(Object.class))
							.parameterTypes(typeOf(Object.class))
							.invocationType(InvocationType.INVOKEVIRTUAL);
					});
					calls.lambdaCalls(lambdaCalls -> {
						lambdaCalls.size().isEqualTo(6);
						lambdaCalls.element(0)
							.clazz(Classnames.nameOf(BiFunction.class))
							.name("apply")
							.factoryClazz(Classnames.typeNameOf(LambdaMetafactory.class))
							.factorySignature(lambda8factorySignature)
							.returnType(Classnames.nameOf(Object.class))
							.parameterTypes(typeOf(Object.class), typeOf(Object.class))
							.methodAsLambdaReturnType(typeOf(String.class))
							.methodAsLambdaParameterTypes(typeOf(Double.class), typeOf(Integer.class))
							.delegate(delegate -> {
								delegate.clazz(Classnames.nameOf(MethodLambdas.class))
									.name("biMapNoop")
									.returnType(typeOf(String.class))
									.parameterTypes(typeOf(double.class), typeOf(int.class))
									.invocationType(InvocationType.INVOKEDYNAMIC);
							});
						lambdaCalls.element(1)
							.clazz(Classnames.nameOf(Function.class))
							.name("apply")
							.factoryClazz(Classnames.typeNameOf(LambdaMetafactory.class))
							.factorySignature(lambda8factorySignature)
							.returnType(Classnames.nameOf(Object.class))
							.parameterTypes(typeOf(Object.class))
							.methodAsLambdaReturnType(typeOf(String.class))
							.methodAsLambdaParameterTypes(typeOf(Integer.class))
							.delegate(delegate -> {
								delegate.clazz(Classnames.nameOf(MethodLambdas.class))
									.name("mapNoop")
									.returnType(typeOf(String.class))
									.parameterTypes(typeOf(int.class))
									.invocationType(InvocationType.INVOKEDYNAMIC);
							});
						lambdaCalls.element(2)
							.clazz(Classnames.nameOf(Function.class))
							.name("apply")
							.factoryClazz(Classnames.typeNameOf(LambdaMetafactory.class))
							.factorySignature(lambda8factorySignature)
							.returnType(Classnames.nameOf(Object.class))
							.parameterTypes(typeOf(Object.class))
							.methodAsLambdaReturnType(typeOf(String.class))
							.methodAsLambdaParameterTypes(typeOf(String.class))
							.delegate(delegate -> {
								delegate.clazz(Classnames.nameOf(MethodLambdas.class))
									.name("lambda$lambdas$0")
									.returnType(typeOf(String.class))
									.parameterTypes(typeOf(String.class))
									.invocationType(InvocationType.INVOKEDYNAMIC);
							});
						lambdaCalls.element(3)
							.clazz(Classnames.nameOf(Predicate.class))
							.name("test")
							.factoryClazz(Classnames.typeNameOf(LambdaMetafactory.class))
							.factorySignature(lambda8factorySignature)
							.returnType(Classnames.nameOf(boolean.class))
							.parameterTypes(typeOf(Object.class))
							.methodAsLambdaReturnType(typeOf(boolean.class))
							.methodAsLambdaParameterTypes(typeOf(String.class))
							.delegate(delegate -> {
								delegate.clazz(Classnames.nameOf(MethodLambdas.class))
									.name("lambda$lambdas$1")
									.returnType(typeOf(boolean.class))
									.parameterTypes(typeOf(String.class))
									.invocationType(InvocationType.INVOKEDYNAMIC);
							});
						lambdaCalls.element(4)
							.clazz(Classnames.nameOf(Predicate.class))
							.name("test")
							.factoryClazz(Classnames.typeNameOf(LambdaMetafactory.class))
							.factorySignature(lambda8factorySignature)
							.returnType(Classnames.nameOf(boolean.class))
							.parameterTypes(typeOf(Object.class))
							.methodAsLambdaReturnType(typeOf(boolean.class))
							.methodAsLambdaParameterTypes(typeOf(String.class))
							.delegate(delegate -> {
								delegate.clazz(Classnames.nameOf(String.class))
									.name("isEmpty")
									.returnType(typeOf(boolean.class))
									.parameterTypes()
									.invocationType(InvocationType.INVOKEDYNAMIC);
							});
						lambdaCalls.element(5)
							.clazz(Classnames.nameOf(Predicate.class))
							.name("test")
							.factoryClazz(Classnames.typeNameOf(LambdaMetafactory.class))
							.factorySignature(lambda8factorySignature)
							.returnType(Classnames.nameOf(boolean.class))
							.parameterTypes(typeOf(Object.class))
							.methodAsLambdaReturnType(typeOf(boolean.class))
							.methodAsLambdaParameterTypes(typeOf(String.class))
							.delegate(delegate -> {
								delegate.clazz(Classnames.nameOf(MethodLambdas.class))
									.name("isEmpty")
									.returnType(typeOf(boolean.class))
									.parameterTypes(typeOf(String.class))
									.invocationType(InvocationType.INVOKEDYNAMIC);
							});
					});
					calls.typeReferenceCalls(typeCalls -> {
						typeCalls.size().isEqualTo(1);
						typeCalls.element(0).clazz(Classnames.nameOf(String.class));
					});
				});
			methods.element(2).name("func")
			;
			methods.element(3).name("biFunc")
			;
			methods.element(4).name("isEmpty")
				.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(typeOf(boolean.class))
				.parameterTypes(typeOf(String.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(1);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(String.class))
							.name("isEmpty")
							.returnType(typeOf(boolean.class));
					});
					calls.typeReferenceCalls(TypeReferenceCallsAssert::isEmpty);
				});
			methods.element(5).name("mapNoop")
				.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(typeOf(String.class))
				.parameterTypes(typeOf(int.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(4);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(StringBuilder.class))
							.name("<init>")
							.returnType(typeOf(void.class));
					});
					calls.typeReferenceCalls(typeReferenceCalls -> {
						typeReferenceCalls.size().isEqualTo(1);
						typeReferenceCalls.element(0).clazz(Classnames.nameOf(StringBuilder.class));
					});
				});
			;
			methods.element(6).name("biMapNoop")
				.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(typeOf(String.class))
				.parameterTypes(typeOf(double.class), typeOf(int.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(5);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(StringBuilder.class))
							.name("<init>")
							.returnType(typeOf(void.class));
					});
					calls.typeReferenceCalls(typeReferenceCalls -> {
						typeReferenceCalls.size().isEqualTo(1);
						typeReferenceCalls.element(0).clazz(Classnames.nameOf(StringBuilder.class));
					});
				});
			;
			methods.element(7).name("lambda$lambdas$1")
				.accessFlags(AccessFlags.ACC_SYNTHETIC, AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(typeOf(boolean.class))
				.parameterTypes(typeOf(String.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(1);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(String.class))
							.name("length")
							.returnType(typeOf(int.class));
					});
					calls.typeReferenceCalls(TypeReferenceCallsAssert::isEmpty);
				});
			methods.element(8).name("lambda$lambdas$0")
				.accessFlags(AccessFlags.ACC_SYNTHETIC, AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(typeOf(String.class))
				.parameterTypes(typeOf(String.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(MethodCallsAssert::isEmpty);
					calls.typeReferenceCalls(TypeReferenceCallsAssert::isEmpty);
				});
		});
	}
	
	@Test
	public void methodCalls() {
		assertThat(Classes.parse(byteCodeOf(MethodCode.class)))
		.isJava8()
		.fields(fields -> {
			fields.size().isEqualTo(4);
			fields.element(0).name("CONST");
			fields.element(1).name("xx");
			fields.element(2).name("y");
			fields.element(3).name("z");
		})
		.methods(methods -> {
			methods.size().isEqualTo(3);
			methods.element(0)
				.name("<init>")
				.returnType(typeOf(void.class))
				.parameterTypes()
				.annotations(AnAnnotationsAssert::isEmpty)
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(1);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(Object.class))
							.name("<init>")
							.parameterTypes();
					});
					calls.typeReferenceCalls(TypeReferenceCallsAssert::isEmpty);					
				});
			methods.element(1)
				.name("simple")
				.returnType(typeOf(String.class))
				.parameterTypes(typeOf(List.class))
				.annotations(AnAnnotationsAssert::isEmpty)
				.calls(calls -> {
					calls.fieldCalls(fieldCalls -> {
						fieldCalls.size().isEqualTo(3);
						fieldCalls.element(0)
							.clazz(Classnames.nameOf(Void.class))
							.name("TYPE")
							.type(typeOf(Class.class));
						fieldCalls.element(1)
							.clazz(Classnames.nameOf(MethodCode.class)).name("y").type(typeOf(String.class));
						fieldCalls.element(2)
							.clazz(Classnames.nameOf(MethodCode.class)).name("z").type(typeOf(String.class));
					});
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(3);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(List.class))
							.name("get")
							.parameterTypes(typeOf(int.class));
						methodCalls.element(1)
							.clazz(Classnames.nameOf(MethodCode.class))
							.name("len")
							.parameterTypes(typeOf(Class.class));
						methodCalls.element(2)
							.clazz(Classnames.nameOf(String.class))
							.name("length")
							.parameterTypes();
					});
					calls.typeReferenceCalls(typeCalls -> {
						typeCalls.size().isEqualTo(8);
						typeCalls.element(0).clazz(Classnames.nameOf(IllegalArgumentException.class));
						typeCalls.element(1).clazz(Classnames.nameOf(IllegalStateException.class));
						typeCalls.element(2).clazz(Classnames.nameOf(String.class));
						typeCalls.element(3).clazz(Classnames.nameOf(MethodCode.class));
						typeCalls.element(4).clazz(Classnames.nameOf(List.class));
						typeCalls.element(5).clazz(Classnames.nameOf(Class.class));
						typeCalls.element(6).clazz(Classnames.nameOf(RuntimeException.class));
						typeCalls.element(7).clazz(Classnames.nameOf(Double.class));
					});
				})
				;
		});
	}
	
	@Test
	public void signatures() {
		assertThat(Classes.parse(byteCodeOf(MethodSignatures.class)))
			.isJava8()
			.methods(methods -> {
				methods.size().isEqualTo(20);
				methods.element(0).name("privateStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PRIVATE);
				methods.element(1).name("protectedStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PROTECTED);
				methods.element(2).name("packageProtectedStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC);
				methods.element(3).name("publicStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC);
				
				methods.element(4).name("<init>").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PUBLIC);
				methods.element(5).name("<init>").returnType("void").parameterTypes(typeOf(String.class)).exceptions().accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(6).name("privateNonStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PRIVATE);
				methods.element(7).name("protectedNonStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PROTECTED);
				methods.element(8).name("packageProtectedNonStatic").returnType("void").parameterTypes().exceptions().accessFlags();
				methods.element(9).name("publicNonStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PUBLIC);

				methods.element(10).name("stringInOut").returnType(typeOf(String.class)).parameterTypes(typeOf(String.class)).exceptions().accessFlags(AccessFlags.ACC_PUBLIC);
				methods.element(11).name("stringInOutThrowsRuntime")
					.returnType(typeOf(String.class))
					.parameterTypes(typeOf(String.class))
					.exceptions(Classnames.nameOf(RuntimeException.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				methods.element(12).name("stringInOutThrowsChecked")
					.returnType(typeOf(String.class))
					.parameterTypes(typeOf(String.class))
					.exceptions(Classnames.nameOf(ParseException.class),Classnames.nameOf(IOException.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(13).name("arrayInOut")
					.returnType(typeOf(String.class, 1))
					.parameterTypes(typeOf(String.class, 1), typeOf(int.class, 1), typeOf(Date.class))
					.exceptions()
					.accessFlags(AccessFlags.ACC_PUBLIC);

				methods.element(14).name("generics")
					.returnType(typeOf(Map.class))
					.parameterTypes(typeOf(Object.class), typeOf(List.class))
					.exceptions(Classnames.nameOf(IOException.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(15).name("annotations")
					.returnType(typeOf(String.class))
					.parameterTypes(typeOf(String.class), typeOf(String.class))
					.exceptions()
					.annotations(annotations -> {
						annotations.size().isEqualTo(3);
						annotations.element(0).clazz(Classnames.nameOf(MethodSignatures.Sample.class));
						annotations.element(1).clazz(Classnames.nameOf(MethodSignatures.Sample.class));
						annotations.element(2).clazz(Classnames.nameOf(MethodSignatures.Sample.class));
					})
					.accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(16).name("accept")
					.returnType(typeOf(void.class))
					.parameterTypes(typeOf(String.class))
					.exceptions()
					.accessFlags(AccessFlags.ACC_PUBLIC);
			
				methods.element(17).name("abstractMethod")
					.returnType(typeOf(String.class))
					.parameterTypes()
					.exceptions()
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT);
				
				methods.element(18).name("accept")
					.returnType(typeOf(void.class))
					.parameterTypes(typeOf(Object.class))
					.exceptions()
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SYNTHETIC, AccessFlags.ACC_BRIDGE);
				methods.element(19).name("<clinit>")
					.returnType(typeOf(void.class))
					.parameterTypes()
					.exceptions()
					.accessFlags(AccessFlags.ACC_STATIC);
			});
	}
	
	@Test
	public void sample() {
		assertThat(Classes.parse(byteCodeOf(MethodsPlayground.class)))
			.isJava8()
			.methods(methods -> {
				methods.size().isEqualTo(3);
				methods.element(0)
					.name("<init>")
					.returnType("void")
					.parameterTypes();
				methods.element(1)
					.name("hello")
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC)
					.returnType(typeOf(String.class))
					.parameterTypes();
				methods.element(2)
					.name("keys")
					.accessFlags(AccessFlags.ACC_PUBLIC)
					.returnType(typeOf(List.class))
					.parameterTypes(typeOf(Map.class));
			});
	}
}
