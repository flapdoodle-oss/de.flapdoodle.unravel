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
		check(ClassPublic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER));
	}

	@Test
	public void classFinalPublic() {
		check(ClassFinalPublic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL));
	}

	@Test
	public void classProtected() {
		check(ClassPublic.class, "ClassProtected", java8(), accessFlags(AccessFlags.ACC_SUPER));
	}

	@Test
	public void classAbstractProtected() {
		check(ClassPublic.class, "ClassAbstractProtected", java8(), accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_ABSTRACT));
	}

	@Test
	public void classAbstractPublic() {
		check(ClassAbstractPublic.class, java8(), accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT));
	}

	@Test
	public void interfacePublic() {
		check(InterfacePublic.class, java8(), accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT));
	}

	@Test
	public void interfaceProtected() {
		check(InterfacePublic.class, "InterfaceProtected", java8(), accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT));
	}

	@Test
	public void annotationPublic() {
		check(AnnotationPublic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT));
	}

	@Test
	public void annotationProtected() {
		check(AnnotationPublic.class, "AnnotationProtected", java8(), accessFlags(AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT));
	}

	@Test
	public void enumPublic() {
		check(EnumPublic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL));
	}

	@Test
	public void enumProtected() {
		check(EnumPublic.class, "EnumProtected", java8(), accessFlags(AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL));
	}

	@Test
	public void inner() {
		check(Inner.ClassNonStatic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER));
		check(Inner.ClassStatic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_SUPER));
		check(Inner.InterfaceNonStatic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE));
		check(Inner.InterfaceStatic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE));
		check(Inner.EnumNonStatic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL));
		check(Inner.EnumStatic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL));
		check(Inner.AnnotationNonStatic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION));
		check(Inner.AnnotationStatic.class, java8(), accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION));
	}
	
	@SafeVarargs
	private static Clazz check(Class<?> clazz, Consumer<Clazz> ...checks) {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(clazz));
		assertEquals(rawName(clazz), result.clazzName().raw());
		for (Consumer<Clazz> check : checks) {
			check.accept(result);
		}
		return result;
	}
	
	@SafeVarargs
	private static Clazz check(Class<?> base, String clazzName, Consumer<Clazz> ...checks) {
		Clazz result = new ClazzParser().parse(Classes.byteCodeOf(base, clazzName));
		assertEquals(rawName(base, clazzName), result.clazzName().raw());
		for (Consumer<Clazz> check : checks) {
			check.accept(result);
		}
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
