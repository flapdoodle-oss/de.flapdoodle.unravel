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

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.Classes;
import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.parser.types.JavaVersion;
import de.flapdoodle.unravel.samples.asm.basics.Annotations;
import org.assertj.core.api.AbstractIterableAssert;
import org.junit.Test;

public class AnnotationsTest {

	@Test
	public void retentions() {
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(Annotations.RetentionSample.class)))
			.isAtLeast(JavaVersion.V1_8)
			.annotations(annotations -> {
				annotations.size().isEqualTo(2);
				annotations.element(0)
					.isClass(Classnames.nameOf(Annotations.RetentionRuntime.class));
				annotations.element(1)
					.isClass(Classnames.nameOf(Annotations.RetentionClass.class));
			});
	}

	@Test
	public void wrapped() {
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(JavaVersion.V1_8, Annotations.WrapperSample.class)))
			.isAtLeast(JavaVersion.V1_8)
			.annotations(annotations -> annotations
				.hasSize(1)
				.elementAt(0, wrapper -> wrapper
					.isClass(Classnames.nameOf(Annotations.Wrapper.class))
					.annotation("value", values -> values
						.hasSize(3)
						.elementAt(0, first -> first
							.isClass(Classnames.nameOf(Annotations.Wrapped.class))
							.annotation("value", AbstractIterableAssert::isEmpty))
						.elementAt(1, second -> second
							.isClass(Classnames.nameOf(Annotations.Wrapped.class))
							.annotation("value", secondList -> secondList
								.hasSize(1)
								.elementAt(0, it -> it
									.isClass(Classnames.nameOf(
										Annotations.WrappedWrapped.class))
									.valueContainsExactly("value", "a"))))
						.elementAt(2, third -> third
							.isClass(Classnames.nameOf(Annotations.Wrapped.class))
							.annotation("value", thirdList -> thirdList
								.hasSize(2)
								.elementAt(0, it -> it
									.isClass(Classnames.nameOf(Annotations.WrappedWrapped.class))
									.valueContainsExactly("value", "b"))
								.elementAt(1, it -> it
									.isClass(Classnames.nameOf(Annotations.WrappedWrapped.class))
									.valueContainsExactly("value", "c")))))));
	}

	@Test
	public void parameters() {
		Assertions.assertThat(Classes.parse(Classes.byteCodeOf(Annotations.ParameterSample.class)))
			.isAtLeast(JavaVersion.V1_8)
			.annotations(annotations -> {
				annotations.size().isEqualTo(1);
				annotations.element(0)
					.isClass(Classnames.nameOf(Annotations.Parameters.class))
					.classAttributes("clazz", Classnames.nameOf(Annotations.WrapperSample.class))
					.classAttributes("clazzArray", Classnames.nameOf(Annotations.Wrapper.class), Classnames.nameOf(Annotations.Wrapped.class))
					.enumAttribute("sample", sub -> {
						sub.size().isEqualTo(1);
						sub.element(0).clazz(Classnames.nameOf(Annotations.SampleEnum.class))
							.value("B");
					})
					.enumAttribute("sampleArray", sub -> {
						sub.size().isEqualTo(2);
						sub.element(0).clazz(Classnames.nameOf(Annotations.SampleEnum.class)).value("A");
						sub.element(1).clazz(Classnames.nameOf(Annotations.SampleEnum.class)).value("C");
					})
					.annotation("wrapped", sub -> {
						sub.size().isEqualTo(1);
						sub.element(0).isClass(Classnames.nameOf(Annotations.WrappedWrapped.class))
							.valueContainsExactly("value", "X");
					})
					.annotation("wrappedArray", sub -> {
						sub.size().isEqualTo(2);
						sub.element(0).isClass(Classnames.nameOf(Annotations.WrappedWrapped.class))
							.valueContainsExactly("value", "Y");
						sub.element(1).isClass(Classnames.nameOf(Annotations.WrappedWrapped.class))
							.valueContainsExactly("value", "Z");
					});
			});

	}
}