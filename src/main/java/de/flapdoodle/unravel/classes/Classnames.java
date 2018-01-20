package de.flapdoodle.unravel.classes;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;

import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.ATypeName;

public abstract class Classnames {

	public static String signatureOf(Class<?> type) {
		return type.getName().replace('.', '/');
	}

	public static String signatureOf(Class<?> base, String className) {
		return base.getPackage().getName().replace('.', '/') + "/" + className;
	}

	public static String nameOf(Class<?> base, String className) {
		return base.getPackage().getName() + "." + className;
	}

	public static String anonNameOf(Class<?> base, String ... className) {
		return base.getName() + "$" + Joiner.on("$").join(className);
	}

	public static String nameOf(Class<?> type) {
		return type.getName();
	}
	
	public static AType typeOf(Class<?> type) {
		return typeOf(type,0);
	}
	
	public static AType typeOf(Class<?> type, int arrayDimension) {
		return AType.of(nameOf(type), arrayDimension);
	}

	public static ATypeName typeNameOf(Class<?> type) {
		return ATypeName.of(nameOf(type));
	}
	
	public static ATypeName typeNameOf(Class<?> base, String className) {
		return ATypeName.of(nameOf(base, className));
	}

	public static ATypeName anonTypeNameOf(Class<?> base, String ... className) {
		return ATypeName.of(anonNameOf(base, className));
	}

	private static ImmutableSet<Class<?>> INTERNAL_TYPES=ImmutableSet.<Class<?>>builder()
			.add(String.class)
			.add(void.class)
			.add(boolean.class)
			.add(byte.class)
			.add(short.class)
			.add(int.class)
			.add(long.class)
			.add(float.class)
			.add(double.class)
			.add(Void.class)
			.add(Boolean.class)
			.add(Byte.class)
			.add(Short.class)
			.add(Integer.class)
			.add(Long.class)
			.add(Float.class)
			.add(Double.class)
			.build();
	
	public static boolean isBuildInType(Class<? extends Object> clazz) {
		return INTERNAL_TYPES.contains(clazz);
	}


}
