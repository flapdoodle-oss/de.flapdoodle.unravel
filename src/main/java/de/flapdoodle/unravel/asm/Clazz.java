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
	public abstract ClazzName clazzName();
	public abstract Optional<ClazzName> superClazz();
	public abstract List<ClazzName> interfaces();
	
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
