package de.flapdoodle.unravel.types;

import org.immutables.builder.Builder.Parameter;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.Multimap;

@Immutable
@VavrEncodingEnabled
public abstract class AnAnnotation {
	@Parameter
	public abstract ATypeName clazz();
	@Parameter
	public abstract boolean visible();
	
	public abstract Multimap<String, Object> valueAttributes();
	public abstract Multimap<String, AnAnnotation> annotationAttributes();
	public abstract Multimap<String, ATypeName> clazzAttributes();
	public abstract Multimap<String, AnEnumValue> enumAttributes();
		
	public static ImmutableAnAnnotation.Builder builder(ATypeName typeName, boolean visible) {
		return ImmutableAnAnnotation.builder(typeName, visible);
	}
}
