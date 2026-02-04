/*
 * Copyright (C) 2017
 *   Michael Mosmann <michael@mosmann.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
				.sourceFile(classNameAsSourceFile(baseClass.getPackage().getName() + "." + realClassName))
				.classFile(classAsFile(baseClass.getPackage().getName() + "." + realClassName) + ".class")
				.build();
	}

	public static JavaSource ofOuterClass(Class<?> baseClass, String outerClassName) {
		return builder()
				.clazz(baseClass)
				.realClassName(outerClassName)
				.sourceFile(sourceResourceNameOf(baseClass))
				.classFile(classAsFile(baseClass.getPackage().getName() + "." + outerClassName) + ".class")
				.build();
	}

	private static String classFileNameOf(Class<?> clazz) {
		return classAsFile(clazz.getName()) + ".class";
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
		return classAsFile(className) + ".java";
	}
}
