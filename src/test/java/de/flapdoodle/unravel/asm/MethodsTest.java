package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.methods.MethodSignatures;
import de.flapdoodle.unravel.samples.asm.methods.MethodsPlayground;
import de.flapdoodle.unravel.types.AccessFlags;

public class MethodsTest extends AbstractClazzParserTest {

	@Test
	public void signatures() {
		assertThat(parse(byteCodeOf(MethodSignatures.class)))
			.isJava8()
			.methods(methods -> {
				methods.size().isEqualTo(17);
				methods.element(0).name("privateStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PRIVATE);
				methods.element(1).name("protectedStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PROTECTED);
				methods.element(2).name("packageProtectedStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC);
				methods.element(3).name("publicStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC);
				
				methods.element(4).name("<init>").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PUBLIC);
				methods.element(5).name("<init>").returnType("void").parameterTypes(Classnames.nameOf(String.class)).exceptions().accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(6).name("privateNonStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PRIVATE);
				methods.element(7).name("protectedNonStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PROTECTED);
				methods.element(8).name("packageProtectedNonStatic").returnType("void").parameterTypes().exceptions().accessFlags();
				methods.element(9).name("publicNonStatic").returnType("void").parameterTypes().exceptions().accessFlags(AccessFlags.ACC_PUBLIC);

				methods.element(10).name("stringInOut").returnType(Classnames.nameOf(String.class)).parameterTypes(Classnames.nameOf(String.class)).exceptions().accessFlags(AccessFlags.ACC_PUBLIC);
				methods.element(11).name("stringInOutThrowsRuntime")
					.returnType(Classnames.nameOf(String.class))
					.parameterTypes(Classnames.nameOf(String.class))
					.exceptions(Classnames.nameOf(RuntimeException.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				methods.element(12).name("stringInOutThrowsChecked")
					.returnType(Classnames.nameOf(String.class))
					.parameterTypes(Classnames.nameOf(String.class))
					.exceptions(Classnames.nameOf(ParseException.class),Classnames.nameOf(IOException.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(13).name("generics")
					.returnType(Classnames.nameOf(Map.class))
					.parameterTypes(Classnames.nameOf(Object.class))
					.exceptions(Classnames.nameOf(IOException.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(14).name("annotations")
					.returnType(Classnames.nameOf(void.class))
					.parameterTypes()
					.exceptions()
					.annotations(annotations -> {
						annotations.size().isEqualTo(1);
						annotations.element(0).clazz(Classnames.nameOf(MethodSignatures.Sample.class));
					})
					.accessFlags(AccessFlags.ACC_PUBLIC);
				
				methods.element(15).name("accept")
					.returnType(Classnames.nameOf(void.class))
					.parameterTypes(Classnames.nameOf(String.class))
					.exceptions()
					.accessFlags(AccessFlags.ACC_PUBLIC);
			
				methods.element(16).name("accept")
					.returnType(Classnames.nameOf(void.class))
					.parameterTypes(Classnames.nameOf(Object.class))
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
					.returnType(Classnames.nameOf(String.class))
					.parameterTypes();
				methods.element(2)
					.name("keys")
					.accessFlags(AccessFlags.ACC_PUBLIC)
					.returnType(Classnames.nameOf(List.class))
					.parameterTypes(Classnames.nameOf(Map.class));
			});
	}
}
