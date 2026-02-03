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

import de.flapdoodle.unravel.parser.types.AnEnumValue;

public class AnEnumValueAssert extends AbstractAssert<AnEnumValueAssert, AnEnumValue> implements CommonAsserts {

	public AnEnumValueAssert(AnEnumValue actual) {
		super(actual, AnEnumValueAssert.class);
	}
	
	public AnEnumValueAssert clazz(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public AnEnumValueAssert value(String value) {
		Assertions.assertThat(actual.value()).describedAs("value").isEqualTo(value);
		return this;
	}
}
