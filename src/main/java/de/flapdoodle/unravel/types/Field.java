package de.flapdoodle.unravel.types;

import java.util.Optional;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.Set;

@Immutable 
@VavrEncodingEnabled
public abstract class Field {
	public abstract String name();
	public abstract FieldType type();
	public abstract Optional<String> genericSignature();
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
