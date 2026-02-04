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
package de.flapdoodle.unravel.parser.types;

import org.immutables.builder.Builder.Parameter;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.Multimap;

@Immutable
@VavrEncodingEnabled
public abstract class AnAnnotation {
	@Parameter
	public abstract ATypeName clazz();
	@Parameter
	public abstract boolean visible();

	public abstract Multimap<String, Object> valueAttributes();
	public abstract Multimap<String, AnAnnotation> annotationAttributes();
	public abstract Multimap<String, ATypeName> clazzAttributes();
	public abstract Multimap<String, AnEnumValue> enumAttributes();

	public static ImmutableAnAnnotation.Builder builder(ATypeName typeName, boolean visible) {
		return ImmutableAnAnnotation.builder(typeName, visible);
	}
}
