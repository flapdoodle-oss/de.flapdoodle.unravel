/**
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

import static com.google.testing.compile.Compiler.javac;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.function.Supplier;

import javax.tools.JavaFileObject;

import com.google.common.collect.ImmutableList;
import com.google.testing.compile.Compilation;
import com.google.testing.compile.Compilation.Status;
import com.google.testing.compile.JavaFileObjects;

import io.vavr.collection.List;
import io.vavr.collection.Stream;

public class Compilers {

	public static class JavaC {
		public static Supplier<InputStream> byteCodeOf(JavaSource javaSource, JavaSource... otherSources) {
			return () -> byteCodeInputStream(javaSource);
		}

		private static InputStream byteCodeInputStream(JavaSource javaSource, JavaSource... otherSources) {
			try {
				Compilation result = javac()
						//						.withClasspathFrom(Compilers.class.getClassLoader())
						.compile(forResources(javaSource, otherSources));

				assertThat(result.errors()).describedAs("compiler errors").isEmpty();
				assertThat(result.status()).isEqualByComparingTo(Status.SUCCESS);

				return byteCodeInputStreamOf(result, javaSource.classFile());
			}
			catch (IOException iox) {
				throw new RuntimeException("error compiling " + javaSource, iox);
			}

		}

		private static InputStream byteCodeInputStreamOf(Compilation result, String classFile)
				throws IOException {
			String byteCodeResourceName = classFile;

			ImmutableList<JavaFileObject> generatedFiles = result.generatedFiles();
			assertThat(generatedFiles).isNotEmpty();

			Optional<JavaFileObject> matching = generatedFiles.stream()
					.filter(javaFile -> javaFile.getName().endsWith(byteCodeResourceName))
					.findFirst();

			assertThat(matching)
					.describedAs("match for '%s' from %s", byteCodeResourceName, generatedFiles)
					.isNotEmpty();

			return matching.get().openInputStream();
		}

		private static String sourceResourceNameOf(Class<?> clazz, Optional<String> realClassName) {
			if (realClassName.isPresent()) {
				return (clazz.getPackage().getName() + "." + realClassName.get()).replace('.', '/') + ".java";
			}
			if (clazz.isMemberClass()) {
				return sourceResourceNameOf(clazz.getEnclosingClass(), Optional.empty());
			}
			if (clazz.isAnonymousClass()) {
				return sourceResourceNameOf(clazz.getEnclosingClass(), Optional.empty());
			}
			if (clazz.isLocalClass()) {
				return sourceResourceNameOf(clazz.getEnclosingClass(), Optional.empty());
			}
			return clazz.getName().replace('.', '/') + ".java";
		}

		private static String byteCodeResourceNameOf(Class<?> clazz, Optional<String> className) {
			if (className.isPresent()) {
				return (clazz.getPackage().getName() + "." + className.get()).replace('.', '/') + ".class";
			}
			return clazz.getName().replace('.', '/') + ".class";
		}

		private static Iterable<? extends JavaFileObject> forResources(JavaSource source, JavaSource... otherSources) {
			return List.of(source).appendAll(List.of(otherSources))
					.map(souce -> JavaFileObjects.forResource(source.sourceFile()));
		}

	}
}
