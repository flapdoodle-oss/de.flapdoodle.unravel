package de.flapdoodle.unravel.types;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public abstract class Calls {
	
	public abstract Set<FieldCall> fieldCalls();
	
	@Immutable
	public static interface FieldCall {
		@Parameter
		ATypeName clazz();
		@Parameter
		String name();
		@Parameter
		ATypeName type();

		public static FieldCall of(ATypeName clazz, String name, ATypeName type) {
			return ImmutableFieldCall.of(clazz, name, type);
		}
	}

	public static ImmutableCalls.Builder builder() {
		return ImmutableCalls.builder();
	}
}
