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

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.parser.types.AField;
import io.vavr.collection.List;

public class AFieldsAssert extends FactoryBasedNavigableIterableAssert<AFieldsAssert, Iterable<? extends AField>, AField, AFieldAssert> implements CommonAsserts {

	public AFieldsAssert(List<AField> actual) {
		super(actual, AFieldsAssert.class, t -> new AFieldAssert(t));
	}

	public static AFieldsAssert assertThatFields(List<AField> fields) {
		return new AFieldsAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<AFieldsAssert, Iterable<? extends AField>, AField, AFieldAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
