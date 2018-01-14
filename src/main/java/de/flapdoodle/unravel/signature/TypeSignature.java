package de.flapdoodle.unravel.signature;

import java.util.Optional;

import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.JavaVersion;
import io.vavr.collection.List;
import io.vavr.collection.Set;

public interface TypeSignature {
	JavaVersion javaVersion();
	Set<AccessFlags> accessFlags();
	ATypeName typeName();
	Optional<ATypeName> superClazz();
	List<ATypeName> interfaces();
	
	// inner classes
	
	// provides
	// -- fields, methods
	
	// uses
	// -- fields, methods, annotations, types

}
