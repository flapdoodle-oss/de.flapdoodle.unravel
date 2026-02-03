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

import de.flapdoodle.unravel.parser.types.AnInnerClass;
import io.vavr.collection.List;

public class InnerClazzesAssert extends FactoryBasedNavigableIterableAssert<InnerClazzesAssert, Iterable<? extends AnInnerClass>, AnInnerClass, InnerClazzAssert> implements CommonAsserts {

	public InnerClazzesAssert(List<AnInnerClass> actual) {
		super(actual, InnerClazzesAssert.class, InnerClazzAssert::new);
	}

	public static InnerClazzesAssert assertThatInnerClasses(List<AnInnerClass> fields) {
		return new InnerClazzesAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<InnerClazzesAssert, Iterable<? extends AnInnerClass>, AnInnerClass, InnerClazzAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}

	@Override
	public InnerClazzAssert element(int index) {
		return super.element(index);
	}

	public InnerClazzesAssert anyElement(Consumer<InnerClazzAssert> consumer) {
		return anySatisfy(it -> consumer.accept(new InnerClazzAssert(it))).describedAs(propertyDescription("element"));
	}

}
