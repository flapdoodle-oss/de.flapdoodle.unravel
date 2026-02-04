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
package de.flapdoodle.unravel.parser;

import org.objectweb.asm.Type;

import de.flapdoodle.unravel.parser.types.AMethodSignature;
import de.flapdoodle.unravel.parser.types.AType;
import de.flapdoodle.unravel.parser.types.ATypeName;
import io.vavr.collection.List;

public abstract class Visitors {

	public static ATypeName typeNameOf(String name) {
		return ATypeName.of(name.replace('/', '.'));
	}

	public static AType typeOf(String rawName) {
		return typeOf(Type.getType(rawName));
	}

	public static AType typeOf(Type type) {
		int arrayDimension = type.getSort() == Type.ARRAY ? type.getDimensions() : 0;
		String className = arrayDimension == 0 ? type.getClassName() : type.getElementType().getClassName();
		return AType.of(className, arrayDimension);
	}

	public static AMethodSignature methodSignOf(String desc) {
		Type type = Type.getMethodType(desc);
		return methodSignOf(type);
	}

	public static AMethodSignature methodSignOf(Type type) {
		List<AType> parameters = List.of(type.getArgumentTypes()).map(Visitors::typeOf);
		AType returnType = typeOf(type.getReturnType());
		return AMethodSignature.of(returnType, parameters);
	}
}
