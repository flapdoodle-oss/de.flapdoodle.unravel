package de.flapdoodle.unravel.types;

import java.util.Optional;

import org.immutables.builder.Builder.Parameter;
import org.immutables.value.Value.Immutable;

@Immutable
public abstract class AnOuterClass {
	@Parameter
	public abstract ATypeName typeName();
	public abstract Optional<String> methodName();
	public abstract Optional<AMethodSignature> methodSignature();
	
	public static ImmutableAnOuterClass.Builder builder(ATypeName typeName) {
		return ImmutableAnOuterClass.builder(typeName);
	}
}
