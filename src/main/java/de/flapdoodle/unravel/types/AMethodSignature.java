package de.flapdoodle.unravel.types;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import io.vavr.collection.List;

@Immutable
public interface AMethodSignature {
	@Parameter
	AType returnType();
	@Parameter
	List<AType> parameters();

	public static AMethodSignature of(AType returnType, List<AType> parameters) {
		return ImmutableAMethodSignature.of(returnType, parameters);
	}
}
