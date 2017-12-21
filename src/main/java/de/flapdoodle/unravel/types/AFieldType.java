package de.flapdoodle.unravel.types;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.objectweb.asm.Type;

@Immutable
public abstract class AFieldType {
	public abstract String raw();
	
	public abstract ATypeName clazz();
	public abstract int arrayDimension();
	
	@Auxiliary
	public boolean isArray() {
		return arrayDimension()>0;
	}
	
	public static AFieldType raw(String rawName) {
		Type type = Type.getType(rawName);
		int arrayDimension = type.getSort()==Type.ARRAY ? type.getDimensions() : 0;
		String className = arrayDimension == 0 ? type.getClassName() : type.getElementType().getClassName();
		
		return builder()
				.raw(rawName)
				.clazz(ATypeName.of(className))
				.arrayDimension(arrayDimension)
				.build();
	}

	public static ImmutableAFieldType.Builder builder() {
		return ImmutableAFieldType.builder();
	}
}
