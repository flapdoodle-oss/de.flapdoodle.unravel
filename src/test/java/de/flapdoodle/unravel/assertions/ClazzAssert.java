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

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.parser.types.AClass;
import de.flapdoodle.unravel.parser.types.ATypeName;
import de.flapdoodle.unravel.parser.types.AccessFlags;
import de.flapdoodle.unravel.parser.types.JavaVersion;

public class ClazzAssert extends AbstractAssert<ClazzAssert, AClass> {

	public ClazzAssert(AClass actual) {
		super(actual, ClazzAssert.class);
	}

	public ClazzAssert is(JavaVersion javaVersion) {
		if (actual.javaVersion()!=javaVersion) {
			failWithMessage("Expected java version to be <%s> but was <%s>", javaVersion, actual.javaVersion());
		}
		return this;
	}

	public ClazzAssert isAtLeast(JavaVersion javaVersion) {
        if (javaVersion.compareTo(actual.javaVersion()) > 0) {
			failWithMessage("Expected java version to be at least <%s> but was <%s>", javaVersion, actual.javaVersion());
		}
		return this;
	}

	public ClazzAssert signature(String signature) {
		Assertions.assertThat(actual.genericSignature()).describedAs("genericSignature").isPresent().contains(signature);
		return this;
	}

	public ClazzAssert hasNoSignature() {
		Assertions.assertThat(actual.genericSignature()).describedAs("genericSignature").isEmpty();
		return this;
	}

	public ClazzAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).containsExactlyInAnyOrder(values);
		return this;
	}

	public ClazzAssert hasAccessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).contains(values);
		return this;
	}

	public ClazzAssert superClass(Class<?> type) {
		Assertions.assertThat(actual.superClazz()).isPresent();
		Assertions.assertThat(actual.superClazz().get().value()).isEqualTo(Classnames.nameOf(type));
		return this;
	}
	
	public ClazzAssert interfaces(String ... name) {
		if (name.length==0) {
			Assertions.assertThat(actual.interfaces()).isEmpty();
		} else {
			Assertions.assertThat(actual.interfaces().map(ATypeName::value)).contains(name);
		}
		return this;
	}
	
	public ClazzAssert typeNameIs(String name) {
		Assertions.assertThat(actual.typeName().value()).isEqualTo(name);
		return this;
	}

	public ClazzAssert fields(Consumer<AFieldsAssert> consumer) {
		consumer.accept(AFieldsAssert.assertThatFields(actual.fields()).describedAs("fields"));
		return this;
	}
	
	public ClazzAssert methods(Consumer<AMethodsAssert> consumer) {
		consumer.accept(AMethodsAssert.assertThatMethods(actual.methods()).describedAs("methods"));
		return this;
	}
	
	public ClazzAssert innerClasses(Consumer<InnerClazzesAssert> consumer) {
		consumer.accept(InnerClazzesAssert.assertThatInnerClasses(actual.innerClasses()).describedAs("innerClasses"));
		return this;
	}
	
	public ClazzAssert annotations(Consumer<AnAnnotationsAssert> consumer) {
		consumer.accept(AnAnnotationsAssert.assertThatAnnotations(actual.annotations()).describedAs("annotations"));
		return this;
	}
	
	public static ClazzAssert assertThat(AClass actual) {
		return new ClazzAssert(actual);
	}
}
