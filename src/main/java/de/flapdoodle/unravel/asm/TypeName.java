package de.flapdoodle.unravel.asm;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
public interface TypeName {
	@Parameter
	String value();
	
	public static TypeName of(String name) {
		return ImmutableTypeName.of(name);
	}
}
