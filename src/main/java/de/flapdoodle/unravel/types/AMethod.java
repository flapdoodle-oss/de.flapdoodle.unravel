package de.flapdoodle.unravel.types;

import java.util.Optional;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.List;
import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public abstract class AMethod {
	protected abstract int access();
	public abstract String name();
	public abstract Optional<String> desc();
	public abstract Optional<String> genericSignature();
	public abstract List<ATypeName> exceptions();

	@Auxiliary
	public Set<AccessFlags> accessFlags() {
		return AccessFlags.flags(Scope.Method, access());
	}

	public static ImmutableAMethod.Builder builder() {
		return ImmutableAMethod.builder();
	}
}
