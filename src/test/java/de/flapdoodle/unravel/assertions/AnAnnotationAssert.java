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
package de.flapdoodle.unravel.assertions;

import java.util.function.Consumer;
import java.util.stream.Stream;

import org.assertj.core.api.AbstractAssert;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.parser.types.ATypeName;
import de.flapdoodle.unravel.parser.types.AnAnnotation;
import de.flapdoodle.unravel.parser.types.AnEnumValue;

public class AnAnnotationAssert extends AbstractAssert<AnAnnotationAssert, AnAnnotation> implements CommonAsserts {

	public AnAnnotationAssert(AnAnnotation actual) {
		super(actual, AnAnnotationAssert.class);
	}
	
//	public AnAnnotationAssert accessFlags(AccessFlags ... values) {
//		Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).containsOnly(values);
//		return this;
//	}
//	
//	public AnAnnotationAssert name(String name) {
//		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
//		return this;
//	}
//
//	public AnAnnotationAssert rawType(String type) {
//		Assertions.assertThat(actual.type().raw()).describedAs(propertyDescription("type")).isEqualTo(type);
//		return this;
//	}
//	
	public AnAnnotationAssert isClass(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public AnAnnotationAssert valueContainsExactly(String key, Object ... expected) {
		java.util.List<Object> values = actual.valueAttributes().get(key);
		Assertions.assertThat(values).describedAs(indexedPropertyDescription("valueAttributes", key)).containsExactly(expected);
		return this;
	}

	public AnAnnotationAssert annotation(String key, Consumer<AnAnnotationsAssert> consumer) {
		java.util.List<AnAnnotation> values = actual.annotationAttributes().get(key);
		consumer.accept(AnAnnotationsAssert.assertThatAnnotations(values).describedAs(indexedPropertyDescription("annotationAttributes",key)));
		return this;
	}
	
	public AnAnnotationAssert enumAttribute(String key, Consumer<AnEnumValuesAssert> consumer) {
		java.util.List<AnEnumValue> values = actual.enumAttributes().get(key);
		consumer.accept(AnEnumValuesAssert.assertThatFields(values).describedAs(indexedPropertyDescription("enumAttributes", key)));
		return this;
	}
	
	public AnAnnotationAssert classAttributes(String key, String ... match) {
		java.util.List<ATypeName> values = actual.clazzAttributes().get(key);
		Assertions.assertThat(values).describedAs(propertyDescription("classAttributes")).containsAll(
                Stream.of(match).map(ATypeName::of).toList());
		return this;
	}
}
