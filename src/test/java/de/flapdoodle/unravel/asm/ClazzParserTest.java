package de.flapdoodle.unravel.asm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.samples.asm.basics.AbstractPublicClass;
import de.flapdoodle.unravel.samples.asm.basics.PublicClass;
import io.vavr.collection.HashSet;

public class ClazzParserTest {

	@Test
	public void publicClass() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(PublicClass.class));
		assertEquals(rawName(PublicClass.class), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC), result.accessFlags());
	}
	
	@Test
	public void protectedClass() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(PublicClass.class, "ProtectedClass"));
		assertEquals(rawName(PublicClass.class, "ProtectedClass"), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_SUPER), result.accessFlags());
	}
	
	@Test
	public void abstractProtectedClass() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(PublicClass.class, "AbstractProtectedClass"));
		assertEquals(rawName(PublicClass.class, "AbstractProtectedClass"), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_SUPER, AccessFlags.ACC_ABSTRACT), result.accessFlags());
	}
	
	@Test
	public void abstractPublicClass() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(AbstractPublicClass.class));
		assertEquals(rawName(AbstractPublicClass.class), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT), result.accessFlags());
	}
	
	private static String rawName(Class<?> type) {
		return type.getCanonicalName().replace('.', '/');
	}
	private static String rawName(Class<?> base, String className) {
		return base.getPackage().getName().replace('.', '/')+"/"+className;
	}
}
