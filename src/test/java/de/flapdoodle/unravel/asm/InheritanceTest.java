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

import java.io.Serializable;

import org.junit.Test;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.samples.asm.basics.Inheritance;
import de.flapdoodle.unravel.types.JavaVersion;

public class InheritanceTest {
	@Test
	public void innerOuter() {
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(Inheritance.B.class))).isAtLeast(JavaVersion.V1_8)
			.superClass(Inheritance.A.class)
			.interfaces(Classnames.nameOf(Inheritance.I.class),Classnames.nameOf(Serializable.class));
	}
}
