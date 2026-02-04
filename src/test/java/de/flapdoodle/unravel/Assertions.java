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
package de.flapdoodle.unravel;

import de.flapdoodle.unravel.assertions.ClazzAssert;
import de.flapdoodle.unravel.assertions.TypeSignatureAssert;
import de.flapdoodle.unravel.signature.TypeSignature;
import de.flapdoodle.unravel.parser.types.AClass;

public abstract class Assertions extends org.assertj.core.api.Assertions {

	public static ClazzAssert assertThat(AClass actual) {
		return ClazzAssert.assertThat(actual);
	}

	public static TypeSignatureAssert assertThat(TypeSignature signature) {
		return TypeSignatureAssert.assertThat(signature);
	}
}
