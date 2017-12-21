package de.flapdoodle.unravel.types;

import org.immutables.builder.Builder.Parameter;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.Multimap;
import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public abstract class AnAnnotation {
	@Parameter
	public abstract ATypeName clazz();
	@Parameter
	public abstract boolean visible();
	public abstract Set<String> usedAttributes();
	@Deprecated
	public abstract Multimap<String, Object> attributeMap();
	
	public abstract Multimap<String, AnAnnotation> annotationAttributes();
	public abstract Multimap<String, ATypeName> clazzAttributes();
	
	public static ImmutableAnAnnotation.Builder builder(ATypeName typeName, boolean visible) {
		return ImmutableAnAnnotation.builder(typeName, visible);
	}
}
