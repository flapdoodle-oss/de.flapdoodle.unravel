package de.flapdoodle.unravel.types;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
public interface AType {
	@Parameter
	ATypeName clazz();
	@Parameter
	int arrayDimension();
	
	@Auxiliary
	default boolean isArray() {
		return arrayDimension()>0;
	}
	
	public static AType of(String name, int arrayDimension) {
		return ImmutableAType.of(ATypeName.of(name), arrayDimension);
	}

	public static AType of(ATypeName typeName, int arrayDimension) {
		return ImmutableAType.of(typeName, arrayDimension);
	}
	
	public static AType of(ATypeName typeName) {
		return of(typeName, 0);
	}
}
