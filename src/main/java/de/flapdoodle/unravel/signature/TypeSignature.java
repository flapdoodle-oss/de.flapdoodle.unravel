package de.flapdoodle.unravel.signature;

import java.util.Optional;

import org.immutables.builder.Builder.Parameter;
import org.immutables.value.Value.Immutable;

import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.JavaVersion;
import io.vavr.collection.List;
import io.vavr.collection.Set;

@Immutable
public interface TypeSignature {
	@Parameter
	ATypeName typeName();
	JavaVersion javaVersion();
	Set<AccessFlags> accessFlags();
	Optional<ATypeName> superClazz();
	List<ATypeName> interfaces();
	
	List<TypeSignature> innerClasses();
	
	// provides
	// -- fields, methods
	
	// uses
	// -- fields, methods, annotations, types

	public static ImmutableTypeSignature.Builder builder(ATypeName name) {
		return ImmutableTypeSignature.builder(name);
	}
}
