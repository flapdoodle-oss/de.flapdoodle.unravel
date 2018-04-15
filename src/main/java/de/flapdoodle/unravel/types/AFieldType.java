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
package de.flapdoodle.unravel.types;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.objectweb.asm.Type;

@Immutable
public abstract class AFieldType {
	public abstract String raw();
	
	public abstract ATypeName clazz();
	public abstract int arrayDimension();
	
	@Auxiliary
	public boolean isArray() {
		return arrayDimension()>0;
	}
	
	public static AFieldType raw(String rawName) {
		Type type = Type.getType(rawName);
		int arrayDimension = type.getSort()==Type.ARRAY ? type.getDimensions() : 0;
		String className = arrayDimension == 0 ? type.getClassName() : type.getElementType().getClassName();
		
		return builder()
				.raw(rawName)
				.clazz(ATypeName.of(className))
				.arrayDimension(arrayDimension)
				.build();
	}

	public static ImmutableAFieldType.Builder builder() {
		return ImmutableAFieldType.builder();
	}
}
