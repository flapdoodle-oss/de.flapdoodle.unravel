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
package de.flapdoodle.unravel.signature;

import de.flapdoodle.unravel.parser.types.AMethodSignature;
import de.flapdoodle.unravel.parser.types.AType;
import de.flapdoodle.unravel.parser.types.ATypeName;
import de.flapdoodle.unravel.parser.types.InvocationType;
import io.vavr.collection.Map;

public interface UsageListener {
	void type(ATypeName type);
	void field(ATypeName clazz, String name, AType fieldType, boolean staticCall);
	void method(ATypeName clazz, String name, AMethodSignature signature, InvocationType invocationType);
	void annotation(ATypeName clazz, Map<String, AType> parameters);
}
