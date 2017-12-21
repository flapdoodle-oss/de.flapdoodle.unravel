package de.flapdoodle.unravel.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
