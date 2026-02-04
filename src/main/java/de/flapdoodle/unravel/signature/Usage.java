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
package de.flapdoodle.unravel.signature;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import de.flapdoodle.unravel.parser.types.AMethodSignature;
import de.flapdoodle.unravel.parser.types.AType;
import de.flapdoodle.unravel.parser.types.ATypeName;
import de.flapdoodle.unravel.parser.types.InvocationType;
import io.vavr.collection.Map;
import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public interface Usage {

	Map<ATypeName, UsedType> types();

	@Auxiliary
	default Usage merge(Usage other) {
		return builder()
				.types(types().merge(other.types(), UsedType::merge))
				.build();
	}

	public static ImmutableUsage.Builder builder() {
		return ImmutableUsage.builder();
	}

	@Immutable
	interface UsedType {
		Set<UsedAnnotation> annotations();
		Set<UsedField> fields();
		Set<UsedMethod> methods();

		@Auxiliary
		default UsedType merge(UsedType other) {
			return builder()
					.addAllAnnotations(annotations())
					.addAllAnnotations(other.annotations())
					.addAllFields(fields())
					.addAllFields(other.fields())
					.addAllMethods(methods())
					.addAllMethods(other.methods())
					.build();
		}

		public static ImmutableUsedType.Builder builder() {
			return ImmutableUsedType.builder();
		}
	}

	@Immutable
	interface UsedAnnotation {
		Map<String, AType> parameters();

		public static ImmutableUsedAnnotation.Builder builder() {
			return ImmutableUsedAnnotation.builder();
		}
	}

	@Immutable
	interface UsedField {
		String name();
		AType type();
		boolean staticCall();

		public static ImmutableUsedField.Builder builder() {
			return ImmutableUsedField.builder();
		}
	}

	@Immutable
	interface UsedMethod {
		String name();
		AMethodSignature signature();
		InvocationType invocationType();

		public static ImmutableUsedMethod.Builder builder() {
			return ImmutableUsedMethod.builder();
		}
	}

}
