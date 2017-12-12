package de.flapdoodle.unravel.asm;

import org.immutables.value.Value.Auxiliary;
import org.immutables.value.Value.Immutable;
import org.objectweb.asm.Type;

import de.flapdoodle.unravel.asm.ImmutableFieldType.Builder;

@Immutable
public abstract class FieldType {
	protected abstract String raw();
	
	public abstract TypeName clazz();
	public abstract int arrayDimension();
	
	@Auxiliary
	public boolean isArray() {
		return arrayDimension()>0;
	}
	
	public static FieldType raw(String rawName) {
		Type type = Type.getType(rawName);
		int arrayDimension = type.getSort()==Type.ARRAY ? type.getDimensions() : 0;
		String className = arrayDimension == 0 ? type.getClassName() : type.getElementType().getClassName();
		
		return builder()
				.raw(rawName)
				.clazz(TypeName.of(className))
				.arrayDimension(arrayDimension)
				.build();
	}

	public static Builder builder() {
		return ImmutableFieldType.builder();
	}
}
