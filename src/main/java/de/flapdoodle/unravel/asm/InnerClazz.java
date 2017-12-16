package de.flapdoodle.unravel.asm;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;

import io.vavr.collection.Set;

@Immutable
public abstract class InnerClazz {
	protected abstract int access();
	public abstract TypeName typeName();
	public abstract TypeName innerName();
	public abstract TypeName outerName();
	
	@Auxiliary
	public Set<AccessFlags> accessFlags() {
		return AccessFlags.flags(Scope.Clazz, access());
	}

	public static ImmutableInnerClazz.Builder builder() {
		return ImmutableInnerClazz.builder();
	}
}
