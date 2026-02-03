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

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
public interface AType {
	@Parameter
	ATypeName clazz();
	@Parameter
	int arrayDimension();

	@Auxiliary
	default boolean isArray() {
		return arrayDimension() > 0;
	}

	public static AType of(String name, int arrayDimension) {
		return ImmutableAType.of(ATypeName.of(name), arrayDimension);
	}

	public static AType of(ATypeName typeName, int arrayDimension) {
		return ImmutableAType.of(typeName, arrayDimension);
	}

	public static AType of(ATypeName typeName) {
		return of(typeName, 0);
	}
}
