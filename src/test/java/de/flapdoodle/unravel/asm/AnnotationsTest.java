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
import de.flapdoodle.unravel.samples.asm.basics.Annotations;

public class AnnotationsTest {
	
	@Test
	public void retentions() {
		assertThat(Classes.parse(byteCodeOf(Annotations.RetentionSample.class)))
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
		assertThat(Classes.parse(byteCodeOf(Annotations.WrapperSample.class)))
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
									.valueAttributesContains("value", "a");
							});
						sub.element(1)
							.clazz(Classnames.nameOf(Annotations.Wrapped.class))
							.annotationAttributes("value", subSub -> { 
								subSub.size().isEqualTo(2);
								subSub.element(0)
									.clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
									.valueAttributesContains("value", "b");
								subSub.element(1)
									.clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
									.valueAttributesContains("value", "c");
							});
						sub.element(2)
							.clazz(Classnames.nameOf(Annotations.Wrapped.class))
							.annotationAttributes("value", subSub -> subSub.isEmpty());
					});
			});
	}
	
	@Test
	public void parameters() {
		assertThat(Classes.parse(byteCodeOf(Annotations.ParameterSample.class)))
			.isJava8()
			.annotations(annotations -> {
				annotations.size().isEqualTo(1);
				annotations.element(0)
					.clazz(Classnames.nameOf(Annotations.Parameters.class))
					.classAttributes("clazz", Classnames.nameOf(Annotations.WrapperSample.class))
					.classAttributes("clazzArray", Classnames.nameOf(Annotations.Wrapper.class), Classnames.nameOf(Annotations.Wrapped.class))
					.enumAttributes("sample", sub -> {
						sub.size().isEqualTo(1);
						sub.element(0).clazz(Classnames.nameOf(Annotations.SampleEnum.class))
							.value("B");
					})
					.enumAttributes("sampleArray", sub -> {
						sub.size().isEqualTo(2);
						sub.element(0).clazz(Classnames.nameOf(Annotations.SampleEnum.class)).value("A");
						sub.element(1).clazz(Classnames.nameOf(Annotations.SampleEnum.class)).value("C");
					})
					.annotationAttributes("wrapped", sub -> {
						sub.size().isEqualTo(1);
						sub.element(0).clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
							.valueAttributesContains("value", "X");
					})
					.annotationAttributes("wrappedArray", sub -> {
						sub.size().isEqualTo(2);
						sub.element(0).clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
							.valueAttributesContains("value", "Y");
						sub.element(1).clazz(Classnames.nameOf(Annotations.WrappedWrapped.class))
							.valueAttributesContains("value", "Z");
					});
			});
		
	}
}