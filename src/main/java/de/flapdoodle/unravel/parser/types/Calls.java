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
package de.flapdoodle.unravel.parser.types;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.LinkedHashSet;

@Immutable
@VavrEncodingEnabled
public abstract class Calls {

	public abstract LinkedHashSet<FieldCall> fieldCalls();
	public abstract LinkedHashSet<MethodCall> methodCalls();
	public abstract LinkedHashSet<LambdaCall> lambdaCalls();
	public abstract LinkedHashSet<TypeReferenceCall> typeReferenceCalls();

	@Immutable
	public static interface FieldCall {
		@Parameter
		ATypeName clazz();
		@Parameter
		String name();
		@Parameter
		AType type();
		@Parameter
		boolean staticCall();

		public static FieldCall of(ATypeName clazz, String name, AType type, boolean staticCall) {
			return ImmutableFieldCall.of(clazz, name, type, staticCall);
		}
	}

	@Immutable
	public static interface MethodCall {
		ATypeName clazz();
		String name();
		AMethodSignature signature();
		InvocationType invocationType();

		public static ImmutableMethodCall.Builder builder() {
			return ImmutableMethodCall.builder();
		}
	}

	@Immutable
	public static interface LambdaCall {
		ATypeName clazz();
		String name();
		AMethodSignature signature();
		AMethodSignature methodAsLambdaSignature();

		ATypeName factoryClazz();
		AMethodSignature factorySignature();

		MethodCall delegate();

		public static ImmutableLambdaCall.Builder builder() {
			return ImmutableLambdaCall.builder();
		}
	}

	@Immutable
	public static interface TypeReferenceCall {
		@Parameter
		ATypeName clazz();

		public static TypeReferenceCall of(ATypeName clazz) {
			return ImmutableTypeReferenceCall.of(clazz);
		}
	}

	public static ImmutableCalls.Builder builder() {
		return ImmutableCalls.builder();
	}
}
