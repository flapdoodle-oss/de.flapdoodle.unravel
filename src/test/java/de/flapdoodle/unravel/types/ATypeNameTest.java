package de.flapdoodle.unravel.types;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
