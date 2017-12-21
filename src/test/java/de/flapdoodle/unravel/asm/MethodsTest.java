package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.methods.MethodsPlayground;
import de.flapdoodle.unravel.types.AccessFlags;

public class MethodsTest extends AbstractClazzParserTest {

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
