package de.flapdoodle.unravel.types;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import io.vavr.collection.List;
import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public abstract class Calls {
	
	public abstract Set<FieldCall> fieldCalls();
	public abstract Set<MethodCall> methodCalls();
	public abstract Set<TypeReferenceCall> typeReferenceCalls();
	
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

	@Immutable
	public static interface MethodCall {
		ATypeName clazz();
		String name();
		ATypeName returnType();
		List<ATypeName> parameters();
		boolean interfaceMethod();

		public static ImmutableMethodCall.Builder builder() {
			return ImmutableMethodCall.builder();
		}
	}
	
	@Immutable
	public static interface TypeReferenceCall {
		@Parameter
		ATypeName clazz();
		
		public static TypeReferenceCall of(ATypeName clazz) {
			return ImmutableTypeReferenceCall.of(clazz);
		}
	}

	public static ImmutableCalls.Builder builder() {
		return ImmutableCalls.builder();
	}
}
