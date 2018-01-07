package de.flapdoodle.unravel.types;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.List;

@Immutable
@VavrEncodingEnabled
public interface AMethodSignature {
	@Parameter
	AType returnType();
	@Parameter
	List<AType> parameters();

	public static ImmutableAMethodSignature.Builder builder() {
		return ImmutableAMethodSignature.builder();
	}
	
	public static AMethodSignature of(AType returnType, List<AType> parameters) {
		return ImmutableAMethodSignature.of(returnType, parameters);
	}
}
