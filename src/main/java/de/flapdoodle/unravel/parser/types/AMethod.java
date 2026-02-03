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

import java.util.Optional;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.List;
import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public abstract class AMethod {
	protected abstract int access();
	public abstract String name();
	public abstract AType returnType();
	public abstract List<AType> parameters();

	public abstract Optional<String> genericSignature();
	public abstract List<ATypeName> exceptions();
	public abstract List<AnAnnotation> annotations();

	public abstract Calls calls();

	@Auxiliary
	public Set<AccessFlags> accessFlags() {
		return AccessFlags.flags(Scope.Method, access());
	}

	public static ImmutableAMethod.Builder builder() {
		return ImmutableAMethod.builder();
	}
}
