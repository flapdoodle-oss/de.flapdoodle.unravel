package de.flapdoodle.unravel.asm;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
public abstract class TypeSignature {
	@Parameter
	protected abstract String raw();
	
	public static TypeSignature raw(String rawName) {
		return ImmutableTypeSignature.of(rawName);
	}

}
