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

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.parser.types.AnAnnotation;

public class AnAnnotationsAssert extends FactoryBasedNavigableIterableAssert<AnAnnotationsAssert, Iterable<? extends AnAnnotation>, AnAnnotation, AnAnnotationAssert> implements CommonAsserts {

	public AnAnnotationsAssert(Iterable<? extends AnAnnotation> actual) {
		super(actual, AnAnnotationsAssert.class, AnAnnotationAssert::new);
	}

	public static AnAnnotationsAssert assertThatAnnotations(Iterable<? extends AnAnnotation> annotations) {
		return new AnAnnotationsAssert(annotations);
	}

	@Override
	@Deprecated
	public AbstractIterableSizeAssert<AnAnnotationsAssert, Iterable<? extends AnAnnotation>, AnAnnotation, AnAnnotationAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}

	public AnAnnotationsAssert anyAnnotation(Consumer<AnAnnotationAssert> consumer) {
		return anySatisfy(it -> consumer.accept(new AnAnnotationAssert(it))).describedAs(propertyDescription("element"));
	}

	public AnAnnotationsAssert elementAt(int index, Consumer<AnAnnotationAssert> consumer) {
		consumer.accept(element(index).describedAs(propertyDescription("elemment["+index+"]")));
		return this;
	}
}
