package de.flapdoodle.unravel.asm;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
public abstract class FieldType {
	@Parameter
	protected abstract String raw();
	
	public static FieldType raw(String rawName) {
		return ImmutableFieldType.of(rawName);
	}
}
