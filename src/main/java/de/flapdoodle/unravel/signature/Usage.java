package de.flapdoodle.unravel.signature;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import de.flapdoodle.unravel.types.AMethodSignature;
import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.InvocationType;
import io.vavr.collection.Map;
import io.vavr.collection.Set;

@Immutable
@VavrEncodingEnabled
public interface Usage {

	Map<ATypeName, UsedType> types();
	
	@Auxiliary
	default Usage merge(Usage other) {
		return builder()
				.types(types().merge(other.types(), UsedType::merge))
				.build();
	}
	
	public static ImmutableUsage.Builder builder() {
		return ImmutableUsage.builder();
	}
		
	@Immutable
	interface UsedType {
		Set<UsedAnnotation> annotations();
		Set<UsedField> fields();
		Set<UsedMethod> methods();
		
		@Auxiliary
		default UsedType merge(UsedType other) {
			return builder()
					.addAllAnnotations(annotations())
					.addAllAnnotations(other.annotations())
					.addAllFields(fields())
					.addAllFields(other.fields())
					.addAllMethods(methods())
					.addAllMethods(other.methods())
					.build();
		}
		
		public static ImmutableUsedType.Builder builder() {
			return ImmutableUsedType.builder();
		}
	}
	
	@Immutable
	interface UsedAnnotation {
		Map<String, AType> parameters();
		
		public static ImmutableUsedAnnotation.Builder builder() {
			return ImmutableUsedAnnotation.builder();
		}
	}
	
	@Immutable
	interface UsedField {
		String name();
		AType type();
		boolean staticCall();
		
		public static ImmutableUsedField.Builder builder() {
			return ImmutableUsedField.builder();
		}
	}
	
	@Immutable
	interface UsedMethod {
		String name();
		AMethodSignature signature();
		InvocationType invocationType();
		
		public static ImmutableUsedMethod.Builder builder() {
			return ImmutableUsedMethod.builder();
		}
	}
	
}
