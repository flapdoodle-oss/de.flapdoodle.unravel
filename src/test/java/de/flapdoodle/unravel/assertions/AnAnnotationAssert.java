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
package de.flapdoodle.unravel.assertions;

import java.util.ArrayList;
import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.parser.types.ATypeName;
import de.flapdoodle.unravel.parser.types.AnAnnotation;
import de.flapdoodle.unravel.parser.types.AnEnumValue;
import io.vavr.collection.List;

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
	public AnAnnotationAssert clazz(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public AnAnnotationAssert valueAttributesContains(String key, Object ... expected) {
		java.util.List<Object> values = actual.valueAttributes().get(key)
				.map(t -> t.toJavaList())
				.getOrElse(new ArrayList<>());
		Assertions.assertThat(values).describedAs(propertyDescription("valueAttributes."+key)).containsExactly(expected);
		return this;
	}

	public AnAnnotationAssert annotationAttributes(String key, Consumer<AnAnnotationsAssert> consumer) {
		List<AnAnnotation> values = actual.annotationAttributes().get(key)
				.map(t -> t.toList())
				.getOrElse(io.vavr.collection.List.empty());
		consumer.accept(AnAnnotationsAssert.assertThatAnnotations(values).describedAs(propertyDescription("annotationAttributes")));
		return this;
	}
	
	public AnAnnotationAssert enumAttributes(String key, Consumer<AnEnumValuesAssert> consumer) {
		List<AnEnumValue> values = actual.enumAttributes().get(key)
				.map(t -> t.toList())
				.getOrElse(io.vavr.collection.List.empty());
		consumer.accept(AnEnumValuesAssert.assertThatFields(values).describedAs(propertyDescription("enumAttributes")));
		return this;
	}
	
	public AnAnnotationAssert classAttributes(String key, String ... match) {
		List<ATypeName> values = actual.clazzAttributes().get(key)
				.map(t -> t.toList())
				.getOrElse(io.vavr.collection.List.empty());
		Assertions.assertThat(values).describedAs(propertyDescription("classAttributes")).containsAll(List.of(match).map(ATypeName::of));
		return this;
	}
}
