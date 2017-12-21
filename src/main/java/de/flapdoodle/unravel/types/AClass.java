package de.flapdoodle.unravel.types;

import java.util.Optional;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.List;
import io.vavr.collection.Set;


@Immutable
@VavrEncodingEnabled
public abstract class AClass {
	protected abstract int version();
	protected abstract int access();
	public abstract ATypeName typeName();
	public abstract Optional<String> genericSignature();
	public abstract Optional<ATypeName> superClazz();
	public abstract List<ATypeName> interfaces();
	public abstract List<AnInnerClass> innerClasses();
	public abstract List<AnAnnotation> annotations();
	
	public abstract List<AField> fields();
	
	@Auxiliary
	public JavaVersion javaVersion() {
		return JavaVersion.of(version());
	}
	
	@Auxiliary
	public Set<AccessFlags> accessFlags() {
		return AccessFlags.flags(Scope.Clazz, access());
	}
	
	public static ImmutableAClass.Builder builder() {
		return ImmutableAClass.builder();
	}
}
