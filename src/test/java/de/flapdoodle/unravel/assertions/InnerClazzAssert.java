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

import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.AnInnerClass;

public class InnerClazzAssert extends AbstractAssert<InnerClazzAssert, AnInnerClass> implements CommonAsserts {

	public InnerClazzAssert(AnInnerClass actual) {
		super(actual, InnerClazzAssert.class);
	}
	
	public InnerClazzAssert accessFlags(AccessFlags ... values) {
		if (values.length==0) {
			Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).isEmpty();;
		} else {
			Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).containsOnly(values);
		}
		return this;
	}
	
	public InnerClazzAssert typeName(String name) {
		Assertions.assertThat(actual.typeName().value()).describedAs(propertyDescription("typeName")).isEqualTo(name);
		return this;
	}
	
	public InnerClazzAssert noInnerName() {
		Assertions.assertThat(actual.innerName()).describedAs(propertyDescription("innerName")).isEmpty();
		return this;
	}
	
	public InnerClazzAssert innerName(String name) {
		Assertions.assertThat(actual.innerName()).describedAs(propertyDescription("innerName")).contains(ATypeName.of(name));
		return this;
	}
	
	public InnerClazzAssert noOuterName() {
		Assertions.assertThat(actual.outerName()).describedAs(propertyDescription("outerName")).isEmpty();
		return this;
	}
	
	public InnerClazzAssert outerName(String name) {
		Assertions.assertThat(actual.outerName()).describedAs(propertyDescription("outerName")).contains(ATypeName.of(name));
		return this;
	}
}
