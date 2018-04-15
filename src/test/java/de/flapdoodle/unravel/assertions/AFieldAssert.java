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

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.AField;
import de.flapdoodle.unravel.types.AccessFlags;

public class AFieldAssert extends AbstractAssert<AFieldAssert, AField> implements CommonAsserts {

	public AFieldAssert(AField actual) {
		super(actual, AFieldAssert.class);
	}
	
	public AFieldAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).containsOnly(values);
		return this;
	}
	
	public AFieldAssert name(String name) {
		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
		return this;
	}
	
	public AFieldAssert clazz(String type) {
		Assertions.assertThat(actual.type().clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public AFieldAssert arrayDimension(int arrayDimension) {
		Assertions.assertThat(actual.type().arrayDimension()).describedAs(propertyDescription("arrayDimension")).isEqualTo(arrayDimension);
		return this;
	}
	
	public AFieldAssert signature(String signature) {
		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isPresent().contains(signature);
		return this;
	}

	public AFieldAssert hasNoSignature() {
		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isEmpty();
		return this;
	}

	public AFieldAssert value(Object value) {
		Assertions.assertThat(actual.value()).describedAs("value").isPresent().contains(value);
		return this;
	}
	
	public AFieldAssert hasNoValue() {
		Assertions.assertThat(actual.value()).describedAs("value").isEmpty();
		return this;
	}
}
