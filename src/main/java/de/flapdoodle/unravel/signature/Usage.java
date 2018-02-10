package de.flapdoodle.unravel.signature;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import de.flapdoodle.checks.Preconditions;
import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.ATypeName;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public interface Usage {

	List<UsedType> types();
	
	@Immutable
	interface UsedType {
		ATypeName type();
		Set<UsedAnnotation> annotations();
		Set<UsedField> fields();
		Set<UsedMethod> methods();
		
		@Auxiliary
		default UsedType merge(UsedType other) {
			Preconditions.checkArgument(type().equals(other.type()), "different types: %s != %s", type(), other.type());
			
			return this;
		}
		
		public static ImmutableUsedType.Builder builder() {
			return ImmutableUsedType.builder();
		}
	}
	
	@Immutable
	interface UsedAnnotation {
		ATypeName type();
		Map<String, AType> parameters();
		
		public static ImmutableUsedAnnotation.Builder builder() {
			return ImmutableUsedAnnotation.builder();
		}
	}
	
	@Immutable
	interface UsedField {
		
		public static ImmutableUsedField.Builder builder() {
			return ImmutableUsedField.builder();
		}
	}
	
	@Immutable
	interface UsedMethod {
		
		public static ImmutableUsedMethod.Builder builder() {
			return ImmutableUsedMethod.builder();
		}
	}
	
	public static ImmutableUsage.Builder builder() {
		return ImmutableUsage.builder();
	}
}
