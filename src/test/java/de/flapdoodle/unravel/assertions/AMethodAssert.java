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

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.parser.types.AMethod;
import de.flapdoodle.unravel.parser.types.AType;
import de.flapdoodle.unravel.parser.types.ATypeName;
import de.flapdoodle.unravel.parser.types.AccessFlags;

public class AMethodAssert extends AbstractAssert<AMethodAssert, AMethod> implements CommonAsserts {

	public AMethodAssert(AMethod actual) {
		super(actual, AMethodAssert.class);
	}
	
	public AMethodAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).containsOnly(values);
		return this;
	}
	
	public AMethodAssert name(String name) {
		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
		return this;
	}

	public AMethodAssert returnType(String type) {
		Assertions.assertThat(actual.returnType()).describedAs(propertyDescription("returnType")).isEqualTo(AType.of(type, 0));
		return this;
	}
	
	public AMethodAssert returnType(AType type) {
		Assertions.assertThat(actual.returnType()).describedAs(propertyDescription("returnType")).isEqualTo(type);
		return this;
	}

	public AMethodAssert parameterTypes(AType ...types) {
		if (types.length==0) {
			Assertions.assertThat(actual.parameters()).describedAs(propertyDescription("parameterTypes")).isEmpty();
		} else {
			Assertions.assertThat(actual.parameters()).describedAs(propertyDescription("parameterTypes")).containsExactly(types);
		}
		return this;
	}

	public AMethodAssert exceptions(String ...names) {
		if (names.length==0) {
			Assertions.assertThat(actual.exceptions()).describedAs(propertyDescription("exceptions")).isEmpty();
		} else {
			Assertions.assertThat(actual.exceptions().map(ATypeName::value)).describedAs(propertyDescription("exceptions")).contains(names);
		}
		return this;
	}
	
	public AMethodAssert annotations(Consumer<AnAnnotationsAssert> consumer) {
		consumer.accept(AnAnnotationsAssert.assertThatAnnotations(actual.annotations()).describedAs(propertyDescription("annotations")));
		return this;
	}

	public AMethodAssert calls(Consumer<CallsAssert> consumer) {
		consumer.accept(new CallsAssert(actual.calls()).describedAs(propertyDescription("calls")));
		return this;
	}
	
//	public AMethodAssert rawType(String type) {
//		Assertions.assertThat(actual.type().raw()).describedAs(propertyDescription("type")).isEqualTo(type);
//		return this;
//	}
//	
//	public AMethodAssert clazz(String type) {
//		Assertions.assertThat(actual.type().clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
//		return this;
//	}
//	
//	public AMethodAssert arrayDimension(int arrayDimension) {
//		Assertions.assertThat(actual.type().arrayDimension()).describedAs(propertyDescription("arrayDimension")).isEqualTo(arrayDimension);
//		return this;
//	}
//	
	public AMethodAssert signature(String signature) {
		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isPresent().contains(signature);
		return this;
	}

	public AMethodAssert hasNoSignature() {
		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isEmpty();
		return this;
	}
//
//	public AMethodAssert value(Object value) {
//		Assertions.assertThat(actual.value()).describedAs("value").isPresent().contains(value);
//		return this;
//	}
//	
//	public AMethodAssert hasNoValue() {
//		Assertions.assertThat(actual.value()).describedAs("value").isEmpty();
//		return this;
//	}
}
