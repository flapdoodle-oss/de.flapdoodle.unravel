package de.flapdoodle.unravel.asm;

import java.util.Optional;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.List;
import io.vavr.collection.Set;


@Immutable
@VavrEncodingEnabled
public abstract class Clazz {
	protected abstract int version();
	protected abstract int access();
	public abstract TypeName typeName();
	public abstract Optional<String> genericSignature();
	public abstract Optional<TypeName> superClazz();
	public abstract List<TypeName> interfaces();
	
	public abstract List<Field> fields();
	
	@Auxiliary
	public JavaVersion javaVersion() {
		return JavaVersion.of(version());
	}
	
	@Auxiliary
	public Set<AccessFlags> accessFlags() {
		return AccessFlags.flags(Scope.Clazz, access());
	}
	
	public static ImmutableClazz.Builder builder() {
		return ImmutableClazz.builder();
	}
}
