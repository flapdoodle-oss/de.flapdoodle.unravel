package de.flapdoodle.unravel.asm;

import java.util.Optional;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;

import io.vavr.collection.Set;

@Immutable
public abstract class Field {
	public abstract String name();
	public abstract TypeSignature type();
	public abstract Optional<String> signature();
	public abstract Optional<Object> value();
	
	protected abstract int access();
	
	@Auxiliary
	public Set<AccessFlags> accessFlags() {
		return AccessFlags.flags(Scope.Field, access());
	}

	public static ImmutableField.Builder builder() {
		return ImmutableField.builder();
	}
}
