package de.flapdoodle.unravel.types;

import java.util.Optional;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;

import io.vavr.collection.Set;

@Immutable
public abstract class AnInnerClass {
	protected abstract int access();
	public abstract ATypeName typeName();
	public abstract Optional<ATypeName> innerName();
	public abstract Optional<ATypeName> outerName();
	
	@Auxiliary
	public Set<AccessFlags> accessFlags() {
		return AccessFlags.flags(Scope.Clazz, access());
	}

	public static ImmutableAnInnerClass.Builder builder() {
		return ImmutableAnInnerClass.builder();
	}
}
