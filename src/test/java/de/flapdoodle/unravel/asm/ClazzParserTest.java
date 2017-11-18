package de.flapdoodle.unravel.asm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.samples.asm.basics.PublicClass;

public class ClazzParserTest {

	@Test
	public void publicClass() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(PublicClass.class));
		assertEquals(rawName(PublicClass.class), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		System.out.println(result);
	}
	
	private static String rawName(Class<?> type) {
		return type.getCanonicalName().replace('.', '/');
	}
}
