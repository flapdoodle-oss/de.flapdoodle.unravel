package de.flapdoodle.unravel.asm;

import org.immutables.builder.Builder.Parameter;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.Multimap;
import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public abstract class AnAnnotation {
	@Parameter
	public abstract TypeName clazz();
	@Parameter
	public abstract boolean visible();
	public abstract Set<String> usedAttributes();
	@Deprecated
	public abstract Multimap<String, Object> attributeMap();
	
	public abstract Multimap<String, AnAnnotation> annotationAttributes();
	public abstract Multimap<String, TypeName> clazzAttributes();
	
	public static ImmutableAnAnnotation.Builder builder(TypeName typeName, boolean visible) {
		return ImmutableAnAnnotation.builder(typeName, visible);
	}
}
