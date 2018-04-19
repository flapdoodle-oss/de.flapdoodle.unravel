package de.flapdoodle.unravel;

import java.util.Optional;

import org.immutables.value.Value.Immutable;

import de.flapdoodle.unravel.ImmutableJavaSource.Builder;
import io.vavr.collection.List;

@Immutable
public abstract class JavaSource {

	protected abstract Class<?> clazz();
	protected abstract Optional<String> realClassName();
	public abstract String sourceFile();
	public abstract String classFile();
	
	private static Builder builder() {
		return ImmutableJavaSource.builder();
	}
	
	public static JavaSource[] of(Class<?>... otherClasses) {
		return List.of(otherClasses).map(JavaSource::of).toJavaArray(JavaSource.class);
	}
	
	public static JavaSource of(Class<?> clazz) {
		return builder()
				.clazz(clazz)
				.sourceFile(sourceResourceNameOf(clazz))
				.classFile(classFileNameOf(clazz))
				.build();
	}
	
	public static JavaSource ofUnaccessableClass(Class<?> baseClass, String realClassName) {
		return builder()
				.clazz(baseClass)
				.realClassName(realClassName)
				.sourceFile(classNameAsSourceFile(baseClass.getPackage().getName()+"."+realClassName))
				.classFile(classAsFile(baseClass.getPackage().getName()+"."+realClassName)+".class")
				.build();
	}
	
	public static JavaSource ofOuterClass(Class<?> baseClass, String outerClassName) {
		return builder()
				.clazz(baseClass)
				.realClassName(outerClassName)
				.sourceFile(sourceResourceNameOf(baseClass))
				.classFile(classAsFile(baseClass.getPackage().getName()+"."+outerClassName)+".class")
				.build();
	}

	private static String classFileNameOf(Class<?> clazz) {
		return classAsFile(clazz.getName())+".class";
	}
	
	private static String sourceResourceNameOf(Class<?> clazz) {
		if (clazz.isMemberClass()) {
			return sourceResourceNameOf(clazz.getEnclosingClass());
		}
		if (clazz.isAnonymousClass()) {
			return sourceResourceNameOf(clazz.getEnclosingClass());
		}
		if (clazz.isLocalClass()) {
			return sourceResourceNameOf(clazz.getEnclosingClass());
		}
		return classNameAsSourceFile(clazz.getName());
	}
	
	private static String classAsFile(String className) {
		return className.replace('.', '/');
	}
	
	private static String classNameAsSourceFile(String className) {
		return classAsFile(className)+".java";
	}
}
