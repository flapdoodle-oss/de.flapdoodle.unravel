package de.flapdoodle.unravel.asm;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;

import io.vavr.collection.Set;

@Immutable
public abstract class Field {
	// int access, String name, String desc, String signature, Object value
	protected abstract int access();
	
	@Auxiliary
	public Set<AccessFlags> accessFlags() {
		return AccessFlags.flags(Scope.Field, access());
	}

	public static ImmutableField.Builder builder() {
		return ImmutableField.builder();
	}
}
