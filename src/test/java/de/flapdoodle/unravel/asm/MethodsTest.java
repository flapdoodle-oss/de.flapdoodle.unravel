package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import de.flapdoodle.unravel.assertions.AnAnnotationsAssert;
import de.flapdoodle.unravel.assertions.FieldCallsAssert;
import de.flapdoodle.unravel.assertions.TypeReferenceCallsAssert;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.methods.MethodCode;
import de.flapdoodle.unravel.samples.asm.methods.MethodLambdas;
import de.flapdoodle.unravel.samples.asm.methods.MethodSignatures;
import de.flapdoodle.unravel.samples.asm.methods.MethodsPlayground;
import de.flapdoodle.unravel.types.AccessFlags;

public class MethodsTest extends AbstractClazzParserTest {

	@Test
	public void lambdaCalls() {
		assertThat(parse(byteCodeOf(MethodLambdas.class)))
		.isJava8()
		.methods(methods -> {
			methods.size().isEqualTo(4);
			methods.element(0).name("<init>");
			methods.element(1).name("lambdas")
				.accessFlags(AccessFlags.ACC_PUBLIC);
			methods.element(2).name("isEmpty")
				.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC)
				.returnType(Classnames.typeOf(boolean.class))
				.parameterTypes(Classnames.typeOf(String.class));
			methods.element(3).name("lambda$0")
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
					.parameterTypes(Classnames.typeOf(Object.class))
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
