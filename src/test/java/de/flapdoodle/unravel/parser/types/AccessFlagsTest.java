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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.flapdoodle.unravel.parser.types.AccessFlags;
import de.flapdoodle.unravel.parser.types.Scope;
import io.vavr.collection.Set;

public class AccessFlagsTest {

	@Test
	public void setShouldContainAllFlagsMatchingValueBits() {
		Set<AccessFlags> result = AccessFlags.flags(Scope.Clazz, AccessFlags.ACC_PROTECTED.mask | AccessFlags.ACC_PUBLIC.mask);
		
		assertEquals(2,result.size());
		assertTrue(result.contains(AccessFlags.ACC_PROTECTED));
		assertTrue(result.contains(AccessFlags.ACC_PUBLIC));
	}
}
