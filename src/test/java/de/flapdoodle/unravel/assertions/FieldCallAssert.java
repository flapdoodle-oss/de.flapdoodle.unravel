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

import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.Calls.FieldCall;

public class FieldCallAssert extends AbstractAssert<FieldCallAssert, FieldCall> implements CommonAsserts {

	public FieldCallAssert(FieldCall actual) {
		super(actual, FieldCallAssert.class);
	}
	
	public FieldCallAssert name(String name) {
		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
		return this;
	}

	public FieldCallAssert clazz(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public FieldCallAssert type(AType type) {
		Assertions.assertThat(actual.type()).describedAs(propertyDescription("type")).isEqualTo(type);
		return this;
	}
}
