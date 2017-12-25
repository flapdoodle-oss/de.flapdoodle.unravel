package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import org.junit.Test;

import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.basics.AnnotationPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassAbstractPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassFinalPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassPublic;
import de.flapdoodle.unravel.samples.asm.basics.EnumPublic;
import de.flapdoodle.unravel.samples.asm.basics.Inner;
import de.flapdoodle.unravel.samples.asm.basics.InnerOuter;
import de.flapdoodle.unravel.samples.asm.basics.InterfacePublic;
import de.flapdoodle.unravel.types.AccessFlags;

public class ClassesTest extends AbstractClazzParserTest {
	@Test
	public void classPublic() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(ClassPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassPublic.class))
			.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER)
			.superClass(Object.class);
	}

	@Test
	public void classFinalPublic() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(ClassFinalPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassFinalPublic.class))
			.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL) 
			.superClass(Object.class);
	}

	@Test
	public void classProtected() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(ClassPublic.class, "ClassProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassPublic.class, "ClassProtected"))
			.accessFlags(AccessFlags.ACC_SUPER)
			.superClass(Object.class);
	}

	@Test
	public void classAbstractProtected() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(ClassPublic.class, "ClassAbstractProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassPublic.class, "ClassAbstractProtected"))
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void classAbstractPublic() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(ClassAbstractPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassAbstractPublic.class))
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void interfacePublic() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(InterfacePublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InterfacePublic.class))
			.accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void interfaceProtected() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(InterfacePublic.class, "InterfaceProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InterfacePublic.class, "InterfaceProtected"))
			.accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void annotationPublic() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(AnnotationPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(AnnotationPublic.class))
			.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void annotationProtected() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(AnnotationPublic.class, "AnnotationProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(AnnotationPublic.class, "AnnotationProtected"))
			.accessFlags(AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void enumPublic() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(EnumPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(EnumPublic.class))
			.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
			.superClass(Enum.class);
	}

	@Test
	public void enumProtected() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(EnumPublic.class, "EnumProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(EnumPublic.class, "EnumProtected"))
			.accessFlags(AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
			.superClass(Enum.class);
	}

	@Test
	public void inner() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(Inner.class)))
			.isJava8()
			.innerClasses(classes -> {
				classes.size().isEqualTo(8);
				classes.element(0)
					.typeName(Classnames.nameOf(Inner.AnnotationNonStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC /* <-- unexpected */, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION);
				classes.element(1)
					.typeName(Classnames.nameOf(Inner.AnnotationStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION);
				classes.element(2)
					.typeName(Classnames.nameOf(Inner.ClassNonStatic.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
				classes.element(3)
					.typeName(Classnames.nameOf(Inner.ClassStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC);
				classes.element(4)
					.typeName(Classnames.nameOf(Inner.EnumNonStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC /* <-- unexpected */, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_FINAL);
				classes.element(5)
					.typeName(Classnames.nameOf(Inner.EnumStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_FINAL);
				classes.element(6)
					.typeName(Classnames.nameOf(Inner.InterfaceNonStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC /* <-- unexpected */, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT);
				classes.element(7)
					.typeName(Classnames.nameOf(Inner.InterfaceStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT);
			});
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(Inner.ClassNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER).superClass(Object.class);
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(Inner.ClassStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_SUPER).superClass(Object.class);
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(Inner.InterfaceNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE).superClass(Object.class);
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(Inner.InterfaceStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE).superClass(Object.class);
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(Inner.EnumNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL).superClass(Enum.class);
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(Inner.EnumStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL).superClass(Enum.class);
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(Inner.AnnotationNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION).superClass(Object.class);
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(Inner.AnnotationStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION).superClass(Object.class);
	}
	
	@Test
	public void innerOuter() {
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(InnerOuter.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InnerOuter.class))
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC)
			.superClass(Object.class)
			.innerClasses(classes -> {
				classes.size().isEqualTo(2); 
				classes.element(0)
					.typeName(Classnames.nameOf(InnerOuter.class)+"$1")
					.noInnerName()
					.noOuterName()
					.accessFlags();
				classes.element(1)
					.typeName(Classnames.nameOf(InnerOuter.Inner.class))
					.innerName(Inner.class.getSimpleName())
					.outerName(Classnames.nameOf(InnerOuter.class))
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC);
			});
		
		assertThat(AbstractClazzParserTest.parse(byteCodeOf(InnerOuter.class,"Outer")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InnerOuter.class,"Outer"))
			.accessFlags(AccessFlags.ACC_SUPER)
			.superClass(Object.class);
	}
}