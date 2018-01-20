package de.flapdoodle.unravel.types;

import java.util.regex.Pattern;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
public interface ATypeName {
	final Pattern ANON_TYPE_NAME=Pattern.compile("\\$[0-9]+$");
	
	@Parameter
	String value();
	
	@Auxiliary
	default boolean isAnon() {
		return ANON_TYPE_NAME.matcher(value()).find();
	}
	
	public static ATypeName of(String name) {
		return ImmutableATypeName.of(name);
	}

}
