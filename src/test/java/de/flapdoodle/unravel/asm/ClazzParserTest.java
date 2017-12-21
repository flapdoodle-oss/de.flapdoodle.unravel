package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import java.io.InputStream;
import java.util.function.Supplier;

import org.junit.Test;
import org.objectweb.asm.Type;

import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.basics.AnnotationPublic;
import de.flapdoodle.unravel.samples.asm.basics.Annotations;
import de.flapdoodle.unravel.samples.asm.basics.AnnotationsPlayground;
import de.flapdoodle.unravel.samples.asm.basics.ClassAbstractPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassFinalPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassPublic;
import de.flapdoodle.unravel.samples.asm.basics.EnumPublic;
import de.flapdoodle.unravel.samples.asm.basics.Fields;
import de.flapdoodle.unravel.samples.asm.basics.Inner;
import de.flapdoodle.unravel.samples.asm.basics.InnerOuter;
import de.flapdoodle.unravel.samples.asm.basics.InterfacePublic;
import de.flapdoodle.unravel.types.AClass;
import de.flapdoodle.unravel.types.AccessFlags;

public class ClazzParserTest {

	public static class AnnotationsTest {
		
		@Test
		public void retentions() {
			assertThat(parse(byteCodeOf(Annotations.RetentionSample.class)))
				.isJava8()
				.annotations(annotations -> {
					annotations.size().isEqualTo(2);
					annotations.element(0)
						.clazz(Classnames.nameOf(Annotations.RetentionRuntime.class));
					annotations.element(1)
						.clazz(Classnames.nameOf(Annotations.RetentionClass.class));
				});
		}
		
		@Test
		public void wrapped() {
			assertThat(parse(byteCodeOf(Annotations.WrapperSample.class)))
				.isJava8()
				.annotations(annotations -> {
					annotations.size().isEqualTo(1);
					annotations.element(0)
						.clazz(Classnames.nameOf(Annotations.Wrapper.class))
						.annotationAttributes("value", sub -> {
							sub.size().isEqualTo(3);
							sub.element(0)
								.clazz(Classnames.nameOf(Annotations.Wrapped.class))
								.annotationAttributes("value", subSub -> { 
									subSub.size().isEqualTo(1);
									subSub.element(0)
										.clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
										.attributeMapContains("value", "a");
								});
							sub.element(1)
								.clazz(Classnames.nameOf(Annotations.Wrapped.class))
								.annotationAttributes("value", subSub -> { 
									subSub.size().isEqualTo(2);
									subSub.element(0)
										.clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
										.attributeMapContains("value", "b");
									subSub.element(1)
										.clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
										.attributeMapContains("value", "c");
								});
							sub.element(2)
								.clazz(Classnames.nameOf(Annotations.Wrapped.class))
								.annotationAttributes("value", subSub -> subSub.isEmpty());
						});
				});
		}
		
		@Test
		public void parameters() {
			assertThat(parse(byteCodeOf(Annotations.ParameterSample.class)))
				.isJava8()
				.annotations(annotations -> {
					annotations.size().isEqualTo(1);
					annotations.element(0)
						.clazz(Classnames.nameOf(Annotations.Parameters.class))
						.annotationAttributes("wrapped", sub -> {
							sub.size().isEqualTo(1);
							sub.element(0).clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
								.attributeMapContains("value", "X");
						})
						.annotationAttributes("wrappedArray", sub -> {
							sub.size().isEqualTo(2);
							sub.element(0).clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
								.attributeMapContains("value", "Y");
							sub.element(1).clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
								.attributeMapContains("value", "Z");
						});
				});
			
		}
		
		@Test
		public void annotations() {
			assertThat(parse(byteCodeOf(AnnotationsPlayground.Clazz.class)))
				.isJava8()
				.annotations(annotations -> {
					annotations.size().isEqualTo(1);
					annotations.element(0)
						.clazz(Classnames.nameOf(AnnotationsPlayground.Samples.class))
						.usedAttributes("value")
						.annotationAttributes("value", sub -> {
							sub.size().isEqualTo(2);
							sub.element(0)
								.attributeMapContains("value", "a string value")
								.attributeMapContains("clazzVal", Type.getType(AnnotationsPlayground.Foo.class));
						});
				});
		}
	}
	
	public static class FieldsTest {
		
		@Test
		public void fieldTypes() {
			assertThat(parse(byteCodeOf(Fields.class)))
				.isJava8()
				.typeNameIs(Classnames.nameOf(Fields.class))
				.signature("<K:Ljava/lang/Object;V:Ljava/lang/Object;>Ljava/lang/Object;")
				.fields(fields -> {
					fields.size().isEqualTo(4);
					fields.element(0)
						.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_STATIC, AccessFlags.ACC_FINAL)
						.name("privateStaticFinalString")
						.clazz("java.lang.String")
						.arrayDimension(0)
						.hasNoSignature()
						.value("Foo");
					fields.element(1)
						.accessFlags(AccessFlags.ACC_PRIVATE, AccessFlags.ACC_FINAL)
						.name("privateFinalString")
						.clazz("java.lang.String")
						.arrayDimension(0)
						.hasNoSignature()
						.hasNoValue();
					fields.element(2)
						.accessFlags(AccessFlags.ACC_PROTECTED)
						.name("privateListOfString")
						.clazz("java.util.List")
						.arrayDimension(0)
						.signature("Ljava/util/List<Ljava/lang/String;>;")
						.hasNoValue();
					fields.element(3)
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
				.typeNameIs(Classnames.nameOf(ClassPublic.class))
				.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER)
				.superClass(Object.class);
		}
	
		@Test
		public void classFinalPublic() {
			assertThat(parse(byteCodeOf(ClassFinalPublic.class)))
				.isJava8()
				.typeNameIs(Classnames.nameOf(ClassFinalPublic.class))
				.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL) 
				.superClass(Object.class);
		}
	
		@Test
		public void classProtected() {
			assertThat(parse(byteCodeOf(ClassPublic.class, "ClassProtected")))
				.isJava8()
				.typeNameIs(Classnames.nameOf(ClassPublic.class, "ClassProtected"))
				.accessFlags(AccessFlags.ACC_SUPER)
				.superClass(Object.class);
		}
	
		@Test
		public void classAbstractProtected() {
			assertThat(parse(byteCodeOf(ClassPublic.class, "ClassAbstractProtected")))
				.isJava8()
				.typeNameIs(Classnames.nameOf(ClassPublic.class, "ClassAbstractProtected"))
				.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void classAbstractPublic() {
			assertThat(parse(byteCodeOf(ClassAbstractPublic.class)))
				.isJava8()
				.typeNameIs(Classnames.nameOf(ClassAbstractPublic.class))
				.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void interfacePublic() {
			assertThat(parse(byteCodeOf(InterfacePublic.class)))
				.isJava8()
				.typeNameIs(Classnames.nameOf(InterfacePublic.class))
				.accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void interfaceProtected() {
			assertThat(parse(byteCodeOf(InterfacePublic.class, "InterfaceProtected")))
				.isJava8()
				.typeNameIs(Classnames.nameOf(InterfacePublic.class, "InterfaceProtected"))
				.accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void annotationPublic() {
			assertThat(parse(byteCodeOf(AnnotationPublic.class)))
				.isJava8()
				.typeNameIs(Classnames.nameOf(AnnotationPublic.class))
				.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void annotationProtected() {
			assertThat(parse(byteCodeOf(AnnotationPublic.class, "AnnotationProtected")))
				.isJava8()
				.typeNameIs(Classnames.nameOf(AnnotationPublic.class, "AnnotationProtected"))
				.accessFlags(AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
				.superClass(Object.class);
		}
	
		@Test
		public void enumPublic() {
			assertThat(parse(byteCodeOf(EnumPublic.class)))
				.isJava8()
				.typeNameIs(Classnames.nameOf(EnumPublic.class))
				.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
				.superClass(Enum.class);
		}
	
		@Test
		public void enumProtected() {
			assertThat(parse(byteCodeOf(EnumPublic.class, "EnumProtected")))
				.isJava8()
				.typeNameIs(Classnames.nameOf(EnumPublic.class, "EnumProtected"))
				.accessFlags(AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
				.superClass(Enum.class);
		}
	
		@Test
		public void inner() {
			assertThat(parse(byteCodeOf(Inner.class)))
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
			assertThat(parse(byteCodeOf(Inner.ClassNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.ClassStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_SUPER).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.InterfaceNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.InterfaceStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.EnumNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL).superClass(Enum.class);
			assertThat(parse(byteCodeOf(Inner.EnumStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL).superClass(Enum.class);
			assertThat(parse(byteCodeOf(Inner.AnnotationNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION).superClass(Object.class);
			assertThat(parse(byteCodeOf(Inner.AnnotationStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION).superClass(Object.class);
		}
		
		@Test
		public void innerOuter() {
			assertThat(parse(byteCodeOf(InnerOuter.class)))
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
			
			assertThat(parse(byteCodeOf(InnerOuter.class,"Outer")))
				.isJava8()
				.typeNameIs(Classnames.nameOf(InnerOuter.class,"Outer"))
				.accessFlags(AccessFlags.ACC_SUPER)
				.superClass(Object.class);
		}
	}
	
	private static AClass parse(Supplier<InputStream> byteCodeOf) {
		return new ClazzParser().parse(byteCodeOf);
	}
}
