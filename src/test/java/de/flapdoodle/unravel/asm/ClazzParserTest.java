package de.flapdoodle.unravel.asm;

import static org.junit.Assert.assertEquals;

import java.util.function.Consumer;

import org.junit.Test;

import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.samples.asm.basics.AnnotationPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassAbstractPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassFinalPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassPublic;
import de.flapdoodle.unravel.samples.asm.basics.EnumPublic;
import de.flapdoodle.unravel.samples.asm.basics.Inner;
import de.flapdoodle.unravel.samples.asm.basics.InterfacePublic;
import io.vavr.collection.HashSet;

public class ClazzParserTest {

	@Test
	public void classPublic() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(ClassPublic.class));
		assertEquals(rawName(ClassPublic.class), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC), result.accessFlags());
	}

	@Test
	public void classFinalPublic() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(ClassFinalPublic.class));
		assertEquals(rawName(ClassFinalPublic.class), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_FINAL), result.accessFlags());
	}

	@Test
	public void classProtected() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(ClassPublic.class, "ClassProtected"));
		assertEquals(rawName(ClassPublic.class, "ClassProtected"), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_SUPER), result.accessFlags());
	}

	@Test
	public void classAbstractProtected() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(ClassPublic.class, "ClassAbstractProtected"));
		assertEquals(rawName(ClassPublic.class, "ClassAbstractProtected"), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_SUPER, AccessFlags.ACC_ABSTRACT), result.accessFlags());
	}

	@Test
	public void classAbstractPublic() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(ClassAbstractPublic.class));
		assertEquals(rawName(ClassAbstractPublic.class), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT), result.accessFlags());
	}

	@Test
	public void interfacePublic() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(InterfacePublic.class));
		assertEquals(rawName(InterfacePublic.class), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT), result.accessFlags());
	}

	@Test
	public void interfaceProtected() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(InterfacePublic.class, "InterfaceProtected"));
		assertEquals(rawName(InterfacePublic.class, "InterfaceProtected"), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT), result.accessFlags());
	}

	@Test
	public void annotationPublic() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(AnnotationPublic.class));
		assertEquals(rawName(AnnotationPublic.class), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT), result.accessFlags());
	}

	@Test
	public void annotationProtected() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(AnnotationPublic.class, "AnnotationProtected"));
		assertEquals(rawName(AnnotationPublic.class, "AnnotationProtected"), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT), result.accessFlags());
	}

	@Test
	public void enumPublic() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(EnumPublic.class));
		assertEquals(rawName(EnumPublic.class), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL), result.accessFlags());
	}

	@Test
	public void enumProtected() {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(EnumPublic.class, "EnumProtected"));
		assertEquals(rawName(EnumPublic.class, "EnumProtected"), result.clazzName().raw());
		assertEquals(JavaVersion.V1_8, result.javaVersion());
		assertEquals(HashSet.of(AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL), result.accessFlags());
	}

	@Test
	public void inner() {
		check(Inner.ClassNonStatic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER));
	}
	
	@SafeVarargs
	private static Clazz check(Class<?> clazz, Consumer<Clazz> ...checks) {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(clazz));
		assertEquals(rawName(clazz), result.clazzName().raw());
		return result;
	}

	private static Consumer<Clazz> java8() {
		return clazz -> assertEquals("javaVersion", JavaVersion.V1_8, clazz.javaVersion());
	}
	
	private static Consumer<Clazz> accessFlags(AccessFlags ...flags) {
		return clazz -> {
			assertEquals("accessFlags", HashSet.of(flags), clazz.accessFlags());
		};
	}

	private static String rawName(Class<?> type) {
		return type.getName().replace('.', '/');
	}

	private static String rawName(Class<?> base, String className) {
		return base.getPackage().getName().replace('.', '/') + "/" + className;
	}
}
