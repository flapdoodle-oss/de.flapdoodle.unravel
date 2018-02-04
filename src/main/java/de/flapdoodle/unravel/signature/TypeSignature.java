package de.flapdoodle.unravel.signature;

import java.util.Optional;

import org.immutables.builder.Builder.Parameter;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.JavaVersion;
import io.vavr.collection.List;
import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public interface TypeSignature {
	@Parameter
	ATypeName typeName();
	JavaVersion javaVersion();
	Set<AccessFlags> accessFlags();
	Optional<ATypeName> superClazz();
	List<ATypeName> interfaces();
	
	List<TypeSignature> innerClasses();

	List<Field> fields();
	List<Method> methods();
	
	@Immutable
	interface Field {
		String name();
		Set<AccessFlags> accessFlags();
		AType type();
		
		static ImmutableField.Builder builder() {
			return ImmutableField.builder();
		}
	}
	
	@Immutable
	interface Method {
		String name();
		Set<AccessFlags> accessFlags();
		AType returnType();
		List<AType> parameters();
		
		static ImmutableMethod.Builder builder() {
			return ImmutableMethod.builder();
		}
	}

	// uses
	// -- fields, methods, annotations, types
	Uses uses();
	
	@Immutable
	interface Uses {
		Set<ATypeName> types();
		
		static ImmutableUses.Builder builder() {
			return ImmutableUses.builder();
		}
	}

	public static ImmutableTypeSignature.Builder builder(ATypeName name) {
		return ImmutableTypeSignature.builder(name);
	}
}
