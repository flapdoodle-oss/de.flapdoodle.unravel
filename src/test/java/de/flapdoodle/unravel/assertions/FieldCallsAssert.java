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

import de.flapdoodle.unravel.parser.types.Calls.FieldCall;
import io.vavr.collection.Set;

public class FieldCallsAssert extends FactoryBasedNavigableIterableAssert<FieldCallsAssert, Iterable<? extends FieldCall>, FieldCall, FieldCallAssert> implements CommonAsserts {

	public FieldCallsAssert(Set<FieldCall> actual) {
		super(actual, FieldCallsAssert.class, t -> new FieldCallAssert(t));
	}

	public static FieldCallsAssert assertThatFieldCalls(Set<FieldCall> fields) {
		return new FieldCallsAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<FieldCallsAssert, Iterable<? extends FieldCall>, FieldCall, FieldCallAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
