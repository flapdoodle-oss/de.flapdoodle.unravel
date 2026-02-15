/*
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

import java.io.Serializable;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.basics.Inheritance;
import de.flapdoodle.unravel.parser.types.JavaVersion;
import de.flapdoodle.unravel.samples.asm.inherit.ClassImplementsAnnotation;
import de.flapdoodle.unravel.samples.asm.inherit.InterfaceExtendsAnnotation;
import de.flapdoodle.unravel.samples.asm.inherit.SomeAnnotation;
import org.junit.jupiter.api.Test;

import static de.flapdoodle.unravel.Assertions.assertThat;
import static de.flapdoodle.unravel.Classes.byteCodeOf;
import static de.flapdoodle.unravel.Classes.parse;
import static de.flapdoodle.unravel.classes.Classnames.nameOf;

public class InheritanceTest {
	@Test
	public void innerOuter() {
		assertThat(parse(byteCodeOf(JavaVersion.V1_8, Inheritance.B.class))).isAtLeast(JavaVersion.V1_8)
			.superClass(Inheritance.A.class)
			.interfaces(nameOf(Inheritance.I.class), nameOf(Serializable.class));
	}

	@Test
	void interfaceExtendsAnnotation() {
		assertThat(parse(byteCodeOf(JavaVersion.V1_8, InterfaceExtendsAnnotation.class))).isAtLeast(JavaVersion.V1_8)
			.superClass(Object.class)
			.interfaces(nameOf(SomeAnnotation.class));
	}

	@Test
	void classExtendsAnnotation() {
		assertThat(parse(byteCodeOf(JavaVersion.V1_8, ClassImplementsAnnotation.class))).isAtLeast(JavaVersion.V1_8)
			.superClass(Object.class)
			.interfaces(nameOf(SomeAnnotation.class));
	}
}
