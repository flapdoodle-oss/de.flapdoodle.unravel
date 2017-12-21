package de.flapdoodle.unravel.types;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

@Immutable
@VavrEncodingEnabled
public abstract class AnEnumValue {
	@Parameter
	public abstract ATypeName clazz();
	@Parameter
	public abstract String value();
	
	public static AnEnumValue of(ATypeName name, String value) {
		return ImmutableAnEnumValue.of(name, value);
	}
}
