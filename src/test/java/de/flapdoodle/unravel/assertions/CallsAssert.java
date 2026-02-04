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

import de.flapdoodle.unravel.parser.types.Calls;

public class CallsAssert extends AbstractAssert<CallsAssert, Calls> implements CommonAsserts {

	public CallsAssert(Calls actual) {
		super(actual, CallsAssert.class);
	}
	
//	public CallsAssert accessFlags(AccessFlags ... values) {
//		Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).containsOnly(values);
//		return this;
//	}
//	
//	public CallsAssert name(String name) {
//		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
//		return this;
//	}
//
//	public CallsAssert returnType(String name) {
//		Assertions.assertThat(actual.returnType().value()).describedAs(propertyDescription("returnType")).isEqualTo(name);
//		return this;
//	}
//
//	public CallsAssert parameterTypes(String ...names) {
//		if (names.length==0) {
//			Assertions.assertThat(actual.parameters()).describedAs(propertyDescription("parameterTypes")).isEmpty();
//		} else {
//			Assertions.assertThat(actual.parameters().map(ATypeName::value)).describedAs(propertyDescription("parameterTypes")).contains(names);
//		}
//		return this;
//	}
//
//	public CallsAssert exceptions(String ...names) {
//		if (names.length==0) {
//			Assertions.assertThat(actual.exceptions()).describedAs(propertyDescription("exceptions")).isEmpty();
//		} else {
//			Assertions.assertThat(actual.exceptions().map(ATypeName::value)).describedAs(propertyDescription("exceptions")).contains(names);
//		}
//		return this;
//	}
//	
	public CallsAssert fieldCalls(Consumer<FieldCallsAssert> consumer) {
		consumer.accept(FieldCallsAssert.assertThatFieldCalls(actual.fieldCalls()).describedAs(propertyDescription("fieldCalls")));
		return this;
	}

	public CallsAssert methodCalls(Consumer<MethodCallsAssert> consumer) {
		consumer.accept(MethodCallsAssert.assertThatMethodCalls(actual.methodCalls()).describedAs(propertyDescription("methodCalls")));
		return this;
	}

	public CallsAssert lambdaCalls(Consumer<LambdaCallsAssert> consumer) {
		consumer.accept(LambdaCallsAssert.assertThatLambdaCalls(actual.lambdaCalls()).describedAs(propertyDescription("lambdaCalls")));
		return this;
	}

	public CallsAssert typeReferenceCalls(Consumer<TypeReferenceCallsAssert> consumer) {
		consumer.accept(TypeReferenceCallsAssert.assertThatTypeReferenceCalls(actual.typeReferenceCalls()).describedAs(propertyDescription("typeReferenceCalls")));
		return this;
	}

}
