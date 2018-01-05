package de.flapdoodle.unravel.asm;

import org.objectweb.asm.Type;

import de.flapdoodle.unravel.types.AMethodSignature;
import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.ATypeName;
import io.vavr.collection.List;

public abstract class Visitors {

	static ATypeName typeNameOf(String name) {
		return ATypeName.of(name.replace('/', '.'));
	}
	
	static AType typeOf(String rawName) {
		return typeOf(Type.getType(rawName));
	}

	public static AType typeOf(Type type) {
		int arrayDimension = type.getSort()==Type.ARRAY ? type.getDimensions() : 0;
		String className = arrayDimension == 0 ? type.getClassName() : type.getElementType().getClassName();
		return AType.of(className, arrayDimension);
	}
	
	public static AMethodSignature methodSignOf(String desc) {
		Type type = Type.getMethodType(desc);
		return methodSignOf(type);
	}

	public static AMethodSignature methodSignOf(Type type) {
		List<AType> parameters = List.of(type.getArgumentTypes()).map(Visitors::typeOf);
		AType returnType = typeOf(type.getReturnType());
		return AMethodSignature.of(returnType, parameters);
	}
}
