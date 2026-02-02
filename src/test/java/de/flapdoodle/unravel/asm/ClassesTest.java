/**
 * Copyright (C) 2017 Michael Mosmann <michael@mosmann.de>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package de.flapdoodle.unravel.asm;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.JavaSource;
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
import de.flapdoodle.unravel.types.JavaVersion;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;

public class ClassesTest {
    @Test
    public void classPublic() {
        assertThat(Classes.parse(Classes.byteCodeOf(ClassPublic.class))).isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(ClassPublic.class))
                .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER)
                .superClass(Object.class);
    }

    @Test
    public void classFinalPublic() {
        assertThat(Classes.parse(Classes.byteCodeOf(ClassFinalPublic.class))).isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(ClassFinalPublic.class))
                .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
                .superClass(Object.class);
    }

    @Test
    public void classProtected() {
        assertThat(Classes.parse(Classes.byteCodeOf(ClassPublic.class, "ClassProtected")))
                .isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(ClassPublic.class, "ClassProtected"))
                .accessFlags(AccessFlags.ACC_SUPER)
                .superClass(Object.class);
    }

    @Test
    public void classAbstractProtected() {
        assertThat(Classes.parse(Classes.byteCodeOf(ClassPublic.class, "ClassAbstractProtected")))
                .isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(ClassPublic.class, "ClassAbstractProtected"))
                .accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_ABSTRACT)
                .superClass(Object.class);
    }

    @Test
    public void classAbstractPublic() {
        assertThat(Classes.parse(Classes.byteCodeOf(ClassAbstractPublic.class))).isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(ClassAbstractPublic.class))
                .accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
                .superClass(Object.class);
    }

    @Test
    public void interfacePublic() {
        assertThat(Classes.parse(Classes.byteCodeOf(InterfacePublic.class))).isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(InterfacePublic.class))
                .accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT)
                .superClass(Object.class);
    }

    @Test
    public void interfaceProtected() {
        assertThat(Classes.parse(Classes.byteCodeOf(InterfacePublic.class, "InterfaceProtected")))
                .isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(InterfacePublic.class, "InterfaceProtected"))
                .accessFlags(AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
                .superClass(Object.class);
    }

    @Test
    public void annotationPublic() {
        assertThat(Classes.parse(Classes.byteCodeOf(AnnotationPublic.class))).isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(AnnotationPublic.class))
                .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE,
                        AccessFlags.ACC_ABSTRACT)
                .superClass(Object.class);
    }

    @Test
    public void annotationProtected() {
        assertThat(Classes.parse(Classes.byteCodeOf(AnnotationPublic.class, "AnnotationProtected")))
                .isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(AnnotationPublic.class, "AnnotationProtected"))
                .accessFlags(AccessFlags.ACC_ANNOTATION, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT)
                .superClass(Object.class);
    }

    @Test
    public void enumPublic() {
        assertThat(Classes.parse(Classes.byteCodeOf(EnumPublic.class))).isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(EnumPublic.class))
                .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
                .superClass(Enum.class);
    }

    @Test
    public void enumProtected() {
        assertThat(Classes.parse(byteCodeOf(EnumPublic.class, "EnumProtected")))
                .isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(EnumPublic.class, "EnumProtected"))
                .accessFlags(AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
                .superClass(Enum.class);
    }

    @Test
    public void inner() {
        assertThat(Classes.parse(Classes.byteCodeOf(Inner.class))).isAtLeast(JavaVersion.V1_8)
                .innerClasses(classes -> {
                    classes.size().isEqualTo(8);
                    classes.element(0)
                            .typeName(Classnames.nameOf(Inner.EnumStatic.class))
                            .accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM,
                                    AccessFlags.ACC_FINAL);
                    classes.element(1)
                            .typeName(Classnames.nameOf(Inner.EnumNonStatic.class))
                            .accessFlags(AccessFlags.ACC_STATIC /* <-- unexpected */, AccessFlags.ACC_PUBLIC,
                                    AccessFlags.ACC_ENUM, AccessFlags.ACC_FINAL);
                    classes.element(2)
                            .typeName(Classnames.nameOf(Inner.AnnotationStatic.class))
                            .accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT,
                                    AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION);
                    classes.element(3)
                            .typeName(Classnames.nameOf(Inner.AnnotationNonStatic.class))
                            .accessFlags(AccessFlags.ACC_STATIC /* <-- unexpected */, AccessFlags.ACC_PUBLIC,
                                    AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION);
                    classes.element(4)
                            .typeName(Classnames.nameOf(Inner.InterfaceStatic.class))
                            .accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC, AccessFlags.ACC_INTERFACE,
                                    AccessFlags.ACC_ABSTRACT);
                    classes.element(5)
                            .typeName(Classnames.nameOf(Inner.InterfaceNonStatic.class))
                            .accessFlags(AccessFlags.ACC_STATIC /* <-- unexpected */, AccessFlags.ACC_PUBLIC,
                                    AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ABSTRACT);
                    classes.element(6)
                            .typeName(Classnames.nameOf(Inner.ClassStatic.class))
                            .accessFlags(AccessFlags.ACC_STATIC, AccessFlags.ACC_PUBLIC);
                    classes.element(7)
                            .typeName(Classnames.nameOf(Inner.ClassNonStatic.class))
                            .accessFlags(AccessFlags.ACC_PUBLIC);
                });
        assertThat(Classes.parse(Classes.byteCodeOf(Inner.ClassNonStatic.class))).isAtLeast(JavaVersion.V1_8)
                .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_SUPER).superClass(Object.class);
        assertThat(Classes.parse(Classes.byteCodeOf(Inner.ClassStatic.class))).isAtLeast(JavaVersion.V1_8)
                .accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_SUPER)
                .superClass(Object.class);
        assertThat(Classes.parse(Classes.byteCodeOf(Inner.InterfaceNonStatic.class)))
                .isAtLeast(JavaVersion.V1_8)
                .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE)
                .superClass(Object.class);
        assertThat(Classes.parse(Classes.byteCodeOf(Inner.InterfaceStatic.class)))
                .isAtLeast(JavaVersion.V1_8)
                .accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT,
                        AccessFlags.ACC_INTERFACE).superClass(Object.class);
        assertThat(Classes.parse(Classes.byteCodeOf(Inner.EnumNonStatic.class))).isAtLeast(JavaVersion.V1_8)
                .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ENUM, AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL)
                .superClass(Enum.class);
        assertThat(Classes.parse(Classes.byteCodeOf(Inner.EnumStatic.class))).isAtLeast(JavaVersion.V1_8)
                .accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ENUM,
                        AccessFlags.ACC_SUPER, AccessFlags.ACC_FINAL).superClass(Enum.class);
        assertThat(Classes.parse(Classes.byteCodeOf(Inner.AnnotationNonStatic.class)))
                .isAtLeast(JavaVersion.V1_8)
                .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_ABSTRACT, AccessFlags.ACC_INTERFACE,
                        AccessFlags.ACC_ANNOTATION).superClass(Object.class);
        assertThat(Classes.parse(Classes.byteCodeOf(Inner.AnnotationStatic.class)))
                .isAtLeast(JavaVersion.V1_8)
                .accessFlags(AccessFlags.ACC_PUBLIC, /*AccessFlags.ACC_STATIC,*/ AccessFlags.ACC_ABSTRACT,
                        AccessFlags.ACC_INTERFACE, AccessFlags.ACC_ANNOTATION).superClass(Object.class);
    }

    @Test
    @Ignore("javac dependend.. not stable?")
    public void innerOuter() {
        assertThat(Classes.parse(Classes.byteCodeOf(InnerOuter.class))).isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(InnerOuter.class))
                .accessFlags(AccessFlags.ACC_SUPER, AccessFlags.ACC_PUBLIC)
                .superClass(Object.class)
                .innerClasses(classes -> {
                    classes.size().isEqualTo(4);
                    classes.anyElement(it -> it
                            .typeName(Classnames.nameOf(InnerOuter.Inner.class))
                            .innerName(Inner.class.getSimpleName())
                            .outerName(Classnames.nameOf(InnerOuter.class))
                            .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC));
                    classes.anyElement(it -> it
                            .typeName(Classnames.nameOf(InnerOuter.Inner.class))
                            .innerName(Inner.class.getSimpleName())
                            .outerName(Classnames.nameOf(InnerOuter.class))
                            .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC));
                    classes.anyElement(it -> it
                            .typeName(Classnames.nameOf(InnerOuter.class) + "$3")
                            .noInnerName()
                            .noOuterName()
                            .accessFlags());
                    classes.anyElement(it -> it
                            .typeName(Classnames.nameOf(InnerOuter.class) + "$2")
                            .noInnerName()
                            .noOuterName()
                            .accessFlags());
                    classes.anyElement(it -> it
                            .typeName(Classnames.nameOf(InnerOuter.class) + "$1")
                            .noInnerName()
                            .noOuterName()
                            .accessFlags());
                });

        assertThat(Classes.parse(Classes.byteCodeOf(JavaVersion.V1_8, Classes.anonClass(InnerOuter.class, "1"))))
                .isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(InnerOuter.class) + "$1")
                .accessFlags(AccessFlags.ACC_SUPER)
                .superClass(InnerOuter.Inner.class)
                .innerClasses(classes -> {
                    classes.size().isEqualTo(4);
                    classes.anyElement(it -> it
                            .typeName(Classnames.nameOf(InnerOuter.class) + "$1")
                            .noInnerName()
                            .noOuterName()
                            .accessFlags(AccessFlags.ACC_STATIC));
                    classes.anyElement(it -> it
                            .typeName(Classnames.nameOf(InnerOuter.class) + "$1$1AnonInner")
                            .innerName("AnonInner")
                            .noOuterName()
                            .accessFlags());
                    classes.anyElement(it -> it
                            .typeName(Classnames.nameOf(InnerOuter.class) + "$1$1")
                            .noInnerName()
                            .noOuterName()
                            .accessFlags());
                    classes.anyElement(it -> it
                            .typeName(Classnames.nameOf(InnerOuter.Inner.class))
                            .innerName("Inner")
                            .outerName(Classnames.nameOf(InnerOuter.class))
                            .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC));
                });

        assertThat(Classes.parse(Classes.byteCodeOf(Classes.anonClass(InnerOuter.class, "2"))))
                .isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(InnerOuter.class) + "$2")
                .accessFlags(AccessFlags.ACC_SUPER)
                .superClass(InnerOuter.Inner.class)
                .innerClasses(classes -> {
                    classes.size().isEqualTo(2);
                    classes.element(0)
                            .typeName(Classnames.nameOf(InnerOuter.class) + "$2")
                            .noInnerName()
                            .noOuterName()
                            .accessFlags();
                    classes.element(1)
                            .typeName(Classnames.nameOf(InnerOuter.Inner.class))
                            .innerName("Inner")
                            .outerName(Classnames.nameOf(InnerOuter.class))
                            .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC);
                });

        assertThat(Classes.parse(Classes.byteCodeOf(Classes.anonClass(InnerOuter.class, "3"))))
                .isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(InnerOuter.class) + "$3")
                .accessFlags(AccessFlags.ACC_SUPER)
                .superClass(InnerOuter.Inner.class)
                .innerClasses(classes -> {
                    classes.size().isEqualTo(2);
                    classes.element(0)
                            .typeName(Classnames.nameOf(InnerOuter.class) + "$3")
                            .noInnerName()
                            .noOuterName()
                            .accessFlags();
                    classes.element(1)
                            .typeName(Classnames.nameOf(InnerOuter.Inner.class))
                            .innerName("Inner")
                            .outerName(Classnames.nameOf(InnerOuter.class))
                            .accessFlags(AccessFlags.ACC_PUBLIC, AccessFlags.ACC_STATIC);
                });

        assertThat(Classes.parse(Classes.byteCodeOf(InnerOuter.Inner.class))).isAtLeast(JavaVersion.V1_8)
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

        assertThat(Classes.parse(Classes.byteCodeOf(JavaSource.ofOuterClass(InnerOuter.class, "Outer"))))
                .isAtLeast(JavaVersion.V1_8)
                .typeNameIs(Classnames.nameOf(InnerOuter.class, "Outer"))
                .accessFlags(AccessFlags.ACC_SUPER)
                .superClass(Object.class)
                .innerClasses(classes -> {
                    classes.isEmpty();
                });
    }
}