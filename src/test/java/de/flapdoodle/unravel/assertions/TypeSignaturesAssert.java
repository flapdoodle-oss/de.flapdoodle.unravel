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

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.signature.TypeSignature;
import io.vavr.collection.List;

public class TypeSignaturesAssert extends FactoryBasedNavigableIterableAssert<TypeSignaturesAssert, Iterable<? extends TypeSignature>, TypeSignature, TypeSignatureAssert> implements CommonAsserts {

	public TypeSignaturesAssert(List<TypeSignature> actual) {
		super(actual, TypeSignaturesAssert.class, t -> TypeSignatureAssert.assertThat(t));
	}

	public static TypeSignaturesAssert assertThatTypeSignatures(List<TypeSignature> fields) {
		return new TypeSignaturesAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<TypeSignaturesAssert, Iterable<? extends TypeSignature>, TypeSignature, TypeSignatureAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}

	public TypeSignaturesAssert anyElement(Consumer<TypeSignatureAssert> consumer) {
		return anySatisfy(it -> consumer.accept(new TypeSignatureAssert(it))).describedAs(propertyDescription("element"));
	}

}
