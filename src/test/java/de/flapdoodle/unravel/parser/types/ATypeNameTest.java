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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.flapdoodle.unravel.parser.types.ATypeName;

public class ATypeNameTest {

	@Test
	public void anonTypeNames() {
		assertTrue(ATypeName.of("foo.bar.Baz$1").isAnon());
		assertTrue(ATypeName.of("foo.bar.Baz$1$2").isAnon());
		assertTrue(ATypeName.of("foo.bar.Baz$1$2$12313").isAnon());
		assertFalse(ATypeName.of("foo.bar.Baz").isAnon());
		assertFalse(ATypeName.of("foo.bar.Baz$Inner").isAnon());
	}
}
