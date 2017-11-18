package de.flapdoodle.unravel.asm;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
public abstract class ClazzName {
	@Parameter
	protected abstract String raw();
	
	public static ClazzName raw(String rawName) {
		return ImmutableClazzName.of(rawName);
	}
}
