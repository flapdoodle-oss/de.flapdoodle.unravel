package de.flapdoodle.unravel.classes;

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
}
