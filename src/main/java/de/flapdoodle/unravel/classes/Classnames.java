package de.flapdoodle.unravel.classes;

import com.google.common.collect.ImmutableSet;

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

	public static String nameOf(Class<?> type) {
		return type.getName();
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
