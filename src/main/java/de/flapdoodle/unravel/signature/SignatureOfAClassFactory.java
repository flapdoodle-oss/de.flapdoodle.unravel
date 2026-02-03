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

import java.util.function.Function;

import de.flapdoodle.unravel.parser.types.AClass;
import de.flapdoodle.unravel.parser.types.ATypeName;
import io.vavr.control.Option;

public interface SignatureOfAClassFactory {
	TypeSignature signatureOf(AClass aClass, Function<ATypeName, Option<AClass>> classOfTypeName);
}
