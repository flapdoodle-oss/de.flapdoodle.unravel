package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

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
import java.util.function.BiFunction;

import org.junit.Test;

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
import de.flapdoodle.unravel.types.InvocationType;

public class MethodsTest extends AbstractClazzParserTest {

	@Test
	public void lambdaCalls() {
		assertThat(parse(byteCodeOf(MethodLambdas.class)))
		.isJava8()
		.methods(methods -> {
			methods.size().isEqualTo(9);
			methods.element(0).name("<init>");
			methods.element(1).name("lambdas")
				.accessFlags(AccessFlags.ACC_PUBLIC)
				.returnType(Classnames.typeOf(String.class))
				.parameterTypes(Classnames.typeOf(List.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(9);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(Double.class))
							.name("valueOf")
							.returnType(Classnames.typeOf(Double.class))
							.parameterTypes(Classnames.typeOf(double.class))
							.invocationType(InvocationType.INVOKESTATIC);
					});
					calls.lambdaCalls(lambdaCalls -> {
						lambdaCalls.size().isEqualTo(6);
						lambdaCalls.element(0)
							.clazz(Classnames.nameOf(BiFunction.class))
							.name("apply")
							.factoryClazz(Classnames.typeNameOf(LambdaMetafactory.class))
							.factorySignature(AMethodSignature.builder()
									.returnType(Classnames.typeOf(CallSite.class))
									.addParameters(Classnames.typeOf(MethodHandles.Lookup.class))
									.addParameters(Classnames.typeOf(String.class))
									.addParameters(Classnames.typeOf(MethodType.class))
									.addParameters(Classnames.typeOf(MethodType.class))
									.addParameters(Classnames.typeOf(MethodHandle.class))
									.addParameters(Classnames.typeOf(MethodType.class))
									.build())
							.returnType(Classnames.nameOf(Object.class))
							.parameterTypes(Classnames.typeOf(Object.class), Classnames.typeOf(Object.class))
							.methodAsLambdaReturnType(Classnames.typeOf(String.class))
							.methodAsLambdaParameterTypes(Classnames.typeOf(Double.class), Classnames.typeOf(Integer.class))
							.delegate(delegate -> {
								delegate.clazz(Classnames.nameOf(MethodLambdas.class))
									.name("biMapNoop")
									.returnType(Classnames.typeOf(String.class))
									.parameterTypes(Classnames.typeOf(double.class), Classnames.typeOf(int.class))
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
				.returnType(Classnames.typeOf(boolean.class))
				.parameterTypes(Classnames.typeOf(String.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(1);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(String.class))
							.name("isEmpty")
							.returnType(Classnames.typeOf(boolean.class));
					});
					calls.typeReferenceCalls(TypeReferenceCallsAssert::isEmpty);
				});
			methods.element(5).name("mapNoop")
				.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(Classnames.typeOf(String.class))
				.parameterTypes(Classnames.typeOf(int.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(3);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(StringBuilder.class))
							.name("<init>")
							.returnType(Classnames.typeOf(void.class));
					});
					calls.typeReferenceCalls(typeReferenceCalls -> {
						typeReferenceCalls.size().isEqualTo(1);
						typeReferenceCalls.element(0).clazz(Classnames.nameOf(StringBuilder.class));
					});
				});
			;
			methods.element(6).name("biMapNoop")
				.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(Classnames.typeOf(String.class))
				.parameterTypes(Classnames.typeOf(double.class), Classnames.typeOf(int.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(4);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(StringBuilder.class))
							.name("<init>")
							.returnType(Classnames.typeOf(void.class));
					});
					calls.typeReferenceCalls(typeReferenceCalls -> {
						typeReferenceCalls.size().isEqualTo(1);
						typeReferenceCalls.element(0).clazz(Classnames.nameOf(StringBuilder.class));
					});
				});
			;
			methods.element(7).name("lambda$0")
				.accessFlags(AccessFlags.ACC_SYNTHETIC, AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(Classnames.typeOf(String.class))
				.parameterTypes(Classnames.typeOf(String.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(MethodCallsAssert::isEmpty);
					calls.typeReferenceCalls(TypeReferenceCallsAssert::isEmpty);
				});
			methods.element(8).name("lambda$1")
				.accessFlags(AccessFlags.ACC_SYNTHETIC, AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(Classnames.typeOf(boolean.class))
				.parameterTypes(Classnames.typeOf(String.class))
				.calls(calls -> {
					calls.fieldCalls(FieldCallsAssert::isEmpty);
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(1);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(String.class))
							.name("length")
							.returnType(Classnames.typeOf(int.class));
					});
					calls.typeReferenceCalls(TypeReferenceCallsAssert::isEmpty);
				});
		});
	}
	
	@Test
	public void methodCalls() {
		assertThat(parse(byteCodeOf(MethodCode.class)))
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
				.returnType(Classnames.typeOf(void.class))
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
				.returnType(Classnames.typeOf(String.class))
				.parameterTypes(Classnames.typeOf(List.class))
				.annotations(AnAnnotationsAssert::isEmpty)
				.calls(calls -> {
					calls.fieldCalls(fieldCalls -> {
						fieldCalls.size().isEqualTo(3);
						fieldCalls.element(0)
							.clazz(Classnames.nameOf(Void.class))
							.name("TYPE")
							.type(Classnames.typeOf(Class.class));
						fieldCalls.element(1)
							.clazz(Classnames.nameOf(MethodCode.class)).name("y").type(Classnames.typeOf(String.class));
						fieldCalls.element(2)
							.clazz(Classnames.nameOf(MethodCode.class)).name("z").type(Classnames.typeOf(String.class));
					});
					calls.methodCalls(methodCalls -> {
						methodCalls.size().isEqualTo(3);
						methodCalls.element(0)
							.clazz(Classnames.nameOf(List.class))
							.name("get")
							.parameterTypes(Classnames.typeOf(int.class));
						methodCalls.element(1)
							.clazz(Classnames.nameOf(MethodCode.class))
							.name("len")
							.parameterTypes(Classnames.typeOf(Class.class));
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
		assertThat(parse(byteCodeOf(MethodSignatures.class)))
			.isJava8()
			.methods(methods -> {
				methods.size().isEqualTo(19);
				methods.element(0).name("privateStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PRIVATE);
				methods.element(1).name("protectedStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PROTECTED);
				methods.element(2).name("packageProtectedStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC);
				methods.element(3).name("publicStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC);
				
				methods.element(4).name("<init>").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PUBLIC);
				methods.element(5).name("<init>").returnType("void").parameterTypes(Classnames.typeOf(String.class)).exceptions().accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(6).name("privateNonStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PRIVATE);
				methods.element(7).name("protectedNonStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PROTECTED);
				methods.element(8).name("packageProtectedNonStatic").returnType("void").parameterTypes().exceptions().accessFlags();
				methods.element(9).name("publicNonStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PUBLIC);

				methods.element(10).name("stringInOut").returnType(Classnames.typeOf(String.class)).parameterTypes(Classnames.typeOf(String.class)).exceptions().accessFlags(AccessFlags.ACC_PUBLIC);
				methods.element(11).name("stringInOutThrowsRuntime")
					.returnType(Classnames.typeOf(String.class))
					.parameterTypes(Classnames.typeOf(String.class))
					.exceptions(Classnames.nameOf(RuntimeException.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				methods.element(12).name("stringInOutThrowsChecked")
					.returnType(Classnames.typeOf(String.class))
					.parameterTypes(Classnames.typeOf(String.class))
					.exceptions(Classnames.nameOf(ParseException.class),Classnames.nameOf(IOException.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(13).name("arrayInOut")
					.returnType(Classnames.typeOf(String.class, 1))
					.parameterTypes(Classnames.typeOf(String.class, 1), Classnames.typeOf(int.class, 1), Classnames.typeOf(Date.class))
					.exceptions()
					.accessFlags(AccessFlags.ACC_PUBLIC);

				methods.element(14).name("generics")
					.returnType(Classnames.typeOf(Map.class))
					.parameterTypes(Classnames.typeOf(Object.class), Classnames.typeOf(List.class))
					.exceptions(Classnames.nameOf(IOException.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(15).name("annotations")
					.returnType(Classnames.typeOf(String.class))
					.parameterTypes(Classnames.typeOf(String.class), Classnames.typeOf(String.class))
					.exceptions()
					.annotations(annotations -> {
						annotations.size().isEqualTo(3);
						annotations.element(0).clazz(Classnames.nameOf(MethodSignatures.Sample.class));
						annotations.element(1).clazz(Classnames.nameOf(MethodSignatures.Sample.class));
						annotations.element(2).clazz(Classnames.nameOf(MethodSignatures.Sample.class));
					})
					.accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(16).name("accept")
					.returnType(Classnames.typeOf(void.class))
					.parameterTypes(Classnames.typeOf(String.class))
					.exceptions()
					.accessFlags(AccessFlags.ACC_PUBLIC);
			
				methods.element(17).name("abstractMethod")
					.returnType(Classnames.typeOf(String.class))
					.parameterTypes()
					.exceptions()
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT);
				
				methods.element(18).name("accept")
					.returnType(Classnames.typeOf(void.class))
					.parameterTypes(Classnames.typeOf(Object.class))
					.exceptions()
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SYNTHETIC, AccessFlags.ACC_BRIDGE);
			});
	}
	
	@Test
	public void sample() {
		assertThat(parse(byteCodeOf(MethodsPlayground.class)))
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
					.returnType(Classnames.typeOf(String.class))
					.parameterTypes();
				methods.element(2)
					.name("keys")
					.accessFlags(AccessFlags.ACC_PUBLIC)
					.returnType(Classnames.typeOf(List.class))
					.parameterTypes(Classnames.typeOf(Map.class));
			});
	}
}
