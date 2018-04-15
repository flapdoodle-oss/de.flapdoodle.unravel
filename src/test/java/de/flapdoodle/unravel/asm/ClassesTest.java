/**
 * Copyright (C) 2017
 *   Michael Mosmann <michael@mosmann.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.unravel.asm;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

import org.junit.Test;

import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.basics.AnnotationPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassAbstractPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassFinalPublic;
import de.flapdoodle.unravel.samples.asm.basics.ClassPublic;
import de.flapdoodle.unravel.samples.asm.basics.EnumPublic;
import de.flapdoodle.unravel.samples.asm.basics.Inner;
import de.flapdoodle.unravel.samples.asm.basics.InnerOuter;
import de.flapdoodle.unravel.samples.asm.basics.InnerOuter.Inner.InnerInner;
import de.flapdoodle.unravel.samples.asm.basics.InterfacePublic;
import de.flapdoodle.unravel.types.AccessFlags;

public class ClassesTest {
	@Test
	public void classPublic() {
		assertThat(Classes.parse(byteCodeOf(ClassPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassPublic.class))
			.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER)
			.superClass(Object.class);
	}

	@Test
	public void classFinalPublic() {
		assertThat(Classes.parse(byteCodeOf(ClassFinalPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassFinalPublic.class))
			.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL) 
			.superClass(Object.class);
	}

	@Test
	public void classProtected() {
		assertThat(Classes.parse(byteCodeOf(ClassPublic.class, "ClassProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassPublic.class, "ClassProtected"))
			.accessFlags(AccessFlags.ACC_SUPER)
			.superClass(Object.class);
	}

	@Test
	public void classAbstractProtected() {
		assertThat(Classes.parse(byteCodeOf(ClassPublic.class, "ClassAbstractProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassPublic.class, "ClassAbstractProtected"))
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void classAbstractPublic() {
		assertThat(Classes.parse(byteCodeOf(ClassAbstractPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(ClassAbstractPublic.class))
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void interfacePublic() {
		assertThat(Classes.parse(byteCodeOf(InterfacePublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InterfacePublic.class))
			.accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void interfaceProtected() {
		assertThat(Classes.parse(byteCodeOf(InterfacePublic.class, "InterfaceProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InterfacePublic.class, "InterfaceProtected"))
			.accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void annotationPublic() {
		assertThat(Classes.parse(byteCodeOf(AnnotationPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(AnnotationPublic.class))
			.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void annotationProtected() {
		assertThat(Classes.parse(byteCodeOf(AnnotationPublic.class, "AnnotationProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(AnnotationPublic.class, "AnnotationProtected"))
			.accessFlags(AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
			.superClass(Object.class);
	}

	@Test
	public void enumPublic() {
		assertThat(Classes.parse(byteCodeOf(EnumPublic.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(EnumPublic.class))
			.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
			.superClass(Enum.class);
	}

	@Test
	public void enumProtected() {
		assertThat(Classes.parse(byteCodeOf(EnumPublic.class, "EnumProtected")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(EnumPublic.class, "EnumProtected"))
			.accessFlags(AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
			.superClass(Enum.class);
	}

	@Test
	public void inner() {
		assertThat(Classes.parse(byteCodeOf(Inner.class)))
			.isJava8()
			.innerClasses(classes -> {
				classes.size().isEqualTo(8);
				classes.element(0)
					.typeName(Classnames.nameOf(Inner.EnumStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_FINAL);
				classes.element(1)
					.typeName(Classnames.nameOf(Inner.EnumNonStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC /* <-- unexpected */, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_FINAL);
				classes.element(2)
					.typeName(Classnames.nameOf(Inner.AnnotationStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION);
				classes.element(3)
					.typeName(Classnames.nameOf(Inner.AnnotationNonStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC /* <-- unexpected */, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION);
				classes.element(4)
					.typeName(Classnames.nameOf(Inner.InterfaceStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT);
				classes.element(5)
					.typeName(Classnames.nameOf(Inner.InterfaceNonStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC /* <-- unexpected */, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT);
				classes.element(6)
					.typeName(Classnames.nameOf(Inner.ClassStatic.class))
					.accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC);
				classes.element(7)
					.typeName(Classnames.nameOf(Inner.ClassNonStatic.class))
					.accessFlags(AccessFlags.ACC_PUBLIC);
			});
		assertThat(Classes.parse(byteCodeOf(Inner.ClassNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER).superClass(Object.class);
		assertThat(Classes.parse(byteCodeOf(Inner.ClassStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_SUPER).superClass(Object.class);
		assertThat(Classes.parse(byteCodeOf(Inner.InterfaceNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE).superClass(Object.class);
		assertThat(Classes.parse(byteCodeOf(Inner.InterfaceStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE).superClass(Object.class);
		assertThat(Classes.parse(byteCodeOf(Inner.EnumNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL).superClass(Enum.class);
		assertThat(Classes.parse(byteCodeOf(Inner.EnumStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL).superClass(Enum.class);
		assertThat(Classes.parse(byteCodeOf(Inner.AnnotationNonStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION).superClass(Object.class);
		assertThat(Classes.parse(byteCodeOf(Inner.AnnotationStatic.class))).isJava8().accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION).superClass(Object.class);
	}
	
	@Test
	public void innerOuter() {
		assertThat(Classes.parse(byteCodeOf(InnerOuter.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InnerOuter.class))
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC)
			.superClass(Object.class)
			.innerClasses(classes -> {
				classes.size().isEqualTo(4); 
				classes.element(0)
					.typeName(Classnames.nameOf(InnerOuter.Inner.class))
					.innerName(Inner.class.getSimpleName())
					.outerName(Classnames.nameOf(InnerOuter.class))
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC);
				classes.element(1)
					.typeName(Classnames.nameOf(InnerOuter.class)+"$3")
					.noInnerName()
					.noOuterName()
					.accessFlags();
				classes.element(2)
					.typeName(Classnames.nameOf(InnerOuter.class)+"$2")
					.noInnerName()
					.noOuterName()
					.accessFlags();
				classes.element(3)
					.typeName(Classnames.nameOf(InnerOuter.class)+"$1")
					.noInnerName()
					.noOuterName()
					.accessFlags(AccessFlags.ACC_STATIC);
			});
		
		assertThat(Classes.parse(byteCodeOf(Classes.anonClass(InnerOuter.class,"1"))))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InnerOuter.class)+"$1")
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
			.superClass(InnerOuter.Inner.class)
			.innerClasses(classes -> {
				classes.size().isEqualTo(4); 
				classes.element(0)
					.typeName(Classnames.nameOf(InnerOuter.class)+"$1")
					.noInnerName()
					.noOuterName()
					.accessFlags(AccessFlags.ACC_STATIC);
				classes.element(1)
					.typeName(Classnames.nameOf(InnerOuter.class)+"$1$1AnonInner")
					.innerName("AnonInner")
					.noOuterName()
					.accessFlags();
				classes.element(2)
					.typeName(Classnames.nameOf(InnerOuter.class)+"$1$1")
					.noInnerName()
					.noOuterName()
					.accessFlags();
				classes.element(3)
					.typeName(Classnames.nameOf(InnerOuter.Inner.class))
					.innerName("Inner")
					.outerName(Classnames.nameOf(InnerOuter.class))
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC);
			});
		
		assertThat(Classes.parse(byteCodeOf(Classes.anonClass(InnerOuter.class,"2"))))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InnerOuter.class)+"$2")
			.accessFlags(AccessFlags.ACC_SUPER)
			.superClass(InnerOuter.Inner.class)
			.innerClasses(classes -> {
				classes.size().isEqualTo(2); 
				classes.element(0)
					.typeName(Classnames.nameOf(InnerOuter.class)+"$2")
					.noInnerName()
					.noOuterName()
					.accessFlags();
				classes.element(1)
					.typeName(Classnames.nameOf(InnerOuter.Inner.class))
					.innerName("Inner")
					.outerName(Classnames.nameOf(InnerOuter.class))
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC);
			});
			
		assertThat(Classes.parse(byteCodeOf(Classes.anonClass(InnerOuter.class,"3"))))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InnerOuter.class)+"$3")
			.accessFlags(AccessFlags.ACC_SUPER)
			.superClass(InnerOuter.Inner.class)
			.innerClasses(classes -> {
				classes.size().isEqualTo(2); 
				classes.element(0)
					.typeName(Classnames.nameOf(InnerOuter.class)+"$3")
					.noInnerName()
					.noOuterName()
					.accessFlags();
				classes.element(1)
					.typeName(Classnames.nameOf(InnerOuter.Inner.class))
					.innerName("Inner")
					.outerName(Classnames.nameOf(InnerOuter.class))
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC);
			});
			
		assertThat(Classes.parse(byteCodeOf(InnerOuter.Inner.class)))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InnerOuter.Inner.class))
			.accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC)
			.superClass(Object.class)
			.innerClasses(classes -> {
				classes.size().isEqualTo(2); 
				classes.element(0)
					.typeName(Classnames.nameOf(InnerOuter.Inner.class))
					.innerName("Inner")
					.outerName(Classnames.nameOf(InnerOuter.class))
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC);
				classes.element(1)
					.typeName(Classnames.nameOf(InnerOuter.Inner.InnerInner.class))
					.innerName(InnerInner.class.getSimpleName())
					.outerName(Classnames.nameOf(InnerOuter.Inner.class))
					.accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC);
			});
			
		assertThat(Classes.parse(byteCodeOf(InnerOuter.class,"Outer")))
			.isJava8()
			.typeNameIs(Classnames.nameOf(InnerOuter.class,"Outer"))
			.accessFlags(AccessFlags.ACC_SUPER)
			.superClass(Object.class)
			.innerClasses(classes -> {
				classes.isEmpty();
			});
	}
}