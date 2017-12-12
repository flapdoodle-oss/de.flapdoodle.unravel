package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import java.io.InputStream;
import java.util.function.Supplier;

import org.junit.Test;

import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.basics.AnnotationPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassAbstractPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassFinalPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassPublic;
import de.flapdoodle.unravel.samples.asm.basics.EnumPublic;
import de.flapdoodle.unravel.samples.asm.basics.Fields;
import de.flapdoodle.unravel.samples.asm.basics.Inner;
import de.flapdoodle.unravel.samples.asm.basics.InterfacePublic;

public class ClazzParserTest {

	public static class FieldsTest {
		
		@Test
		public void fieldTypes() {
			assertThat(parse(byteCodeOf(Fields.class)))
				.isJava8()
				.classNameIs(Classnames.signatureOf(Fields.class))
				.signature("<K:Ljava/lang/Object;V:Ljava/lang/Object;>Ljava/lang/Object;")
				.fields(fields -> {
					assertThat(fields).size().isEqualTo(4);
					assertThat(fields).element(0)
						.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC, AccessFlags.ACC_FINAL)
						.name("privateStaticFinalString")
						.clazz("java.lang.String")
						.arrayDimension(0)
						.hasNoSignature()
						.value("Foo");
					assertThat(fields).element(1)
						.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_FINAL)
						.name("privateFinalString")
						.clazz("java.lang.String")
						.arrayDimension(0)
						.hasNoSignature()
						.hasNoValue();
					assertThat(fields).element(2)
						.accessFlags(AccessFlags.ACC_PROTECTED)
						.name("privateListOfString")
						.clazz("java.util.List")
						.arrayDimension(0)
						.signature("Ljava/util/List<Ljava/lang/String;>;")
						.hasNoValue();
					assertThat(fields).element(3)
						.accessFlags(AccessFlags.ACC_PUBLIC)
						.name("publicMap")
						.clazz("java.util.Map")
						.arrayDimension(0)
						.signature("Ljava/util/Map<TK;TV;>;")
						.hasNoValue();
				});
			
		}
	}

	public static class ClassesTest {
		@Test
		public void classPublic() {
			assertThat(parse(byteCodeOf(ClassPublic.class)))
				.isJava8()
				.classNameIs(Classnames.signatureOf(ClassPublic.class))
				.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER)
				.superClass(Object.class);
		}
	
		@Test
		public void classFinalPublic() {
			assertThat(parse(byteCodeOf(ClassFinalPublic.class)))
				.isJava8()
				.classNameIs(Classnames.signatureOf(ClassFinalPublic.class))
				.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL) 
				.superClass(Object.class);
		}
	
		@Test
		public void classProtected() {
			assertThat(parse(byteCodeOf(ClassPublic.class, "ClassProtected")))
				.isJava8()
				.classNameIs(Classnames.signatureOf(ClassPublic.class, "ClassProtected"))
				.accessFlags(AccessFlags.ACC_SUPER)
				.superClass(Object.class);
		}
	
		@Test
		public void classAbstractProtected() {
			assertThat(parse(byteCodeOf(ClassPublic.class, "ClassAbstractProtected")))
				.isJava8()
				.classNameIs(Classnames.signatureOf(ClassPublic.class, "ClassAbstractProtected"))
				.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void classAbstractPublic() {
			assertThat(parse(byteCodeOf(ClassAbstractPublic.class)))
				.isJava8()
				.classNameIs(Classnames.signatureOf(ClassAbstractPublic.class))
				.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void interfacePublic() {
			assertThat(parse(byteCodeOf(InterfacePublic.class)))
				.isJava8()
				.classNameIs(Classnames.signatureOf(InterfacePublic.class))
				.accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void interfaceProtected() {
			assertThat(parse(byteCodeOf(InterfacePublic.class, "InterfaceProtected")))
				.isJava8()
				.classNameIs(Classnames.signatureOf(InterfacePublic.class, "InterfaceProtected"))
				.accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void annotationPublic() {
			assertThat(parse(byteCodeOf(AnnotationPublic.class)))
				.isJava8()
				.classNameIs(Classnames.signatureOf(AnnotationPublic.class))
				.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void annotationProtected() {
			assertThat(parse(byteCodeOf(AnnotationPublic.class, "AnnotationProtected")))
				.isJava8()
				.classNameIs(Classnames.signatureOf(AnnotationPublic.class, "AnnotationProtected"))
				.accessFlags(AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void enumPublic() {
			assertThat(parse(byteCodeOf(EnumPublic.class)))
				.isJava8()
				.classNameIs(Classnames.signatureOf(EnumPublic.class))
				.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
				.superClass(Enum.class);
		}
	
		@Test
		public void enumProtected() {
			assertThat(parse(byteCodeOf(EnumPublic.class, "EnumProtected")))
				.isJava8()
				.classNameIs(Classnames.signatureOf(EnumPublic.class, "EnumProtected"))
				.accessFlags(AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
				.superClass(Enum.class);
		}
	
		@Test
		public void inner() {
			assertThat(parse(byteCodeOf(Inner.ClassNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.ClassStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_SUPER).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.InterfaceNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.InterfaceStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.EnumNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL).superClass(Enum.class);
			assertThat(parse(byteCodeOf(Inner.EnumStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL).superClass(Enum.class);
			assertThat(parse(byteCodeOf(Inner.AnnotationNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.AnnotationStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION).superClass(Object.class);
		}
	}
	
	private static Clazz parse(Supplier<InputStream> byteCodeOf) {
		return new ClazzParser().parse(byteCodeOf);
	}
}
