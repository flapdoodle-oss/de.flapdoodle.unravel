package de.flapdoodle.unravel.types;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
public interface ATypeName {
	@Parameter
	String value();
	
	public static ATypeName of(String name) {
		return ImmutableATypeName.of(name);
	}
}
