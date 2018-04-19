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

public class Compilers {
	
	public static class JavaC {
		public static Supplier<InputStream> byteCodeOf(java.lang.Class<?> clazz) {
			return () -> byteCodeInputStream(JavaSource.of(clazz));
		}
		
		public static Supplier<InputStream> byteCodeOf(Class<?> base, String realClassName) {
			return () -> byteCodeInputStream(JavaSource.ofUnaccessableClass(base, realClassName));
		}
		
		public static Supplier<InputStream> byteCodeOf(JavaSource javaSource) {
			return () -> byteCodeInputStream(javaSource);
		}
		
		private static InputStream byteCodeInputStream(JavaSource javaSource) {
			try {
				String sourceResourceName = javaSource.sourceFile();
				
				Compilation result = javac()
						.withClasspathFrom(Compilers.class.getClassLoader())
						.compile(JavaFileObjects.forResource(sourceResourceName));
					
				assertThat(result.errors()).isEmpty();
				assertThat(result.status()).isEqualByComparingTo(Status.SUCCESS);
				
				return byteCodeInputStreamOf(result, javaSource.classFile(), sourceResourceName);
			} catch (IOException iox) {
				throw new RuntimeException("error compiling "+javaSource, iox);
			}
			
		}

		private static InputStream byteCodeInputStreamOf(Compilation result, String classFile, String sourceResourceName)
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
				return (clazz.getPackage().getName()+"."+realClassName.get()).replace('.', '/')+".java";
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
			return clazz.getName().replace('.', '/')+".java";
		}
		
		private static String byteCodeResourceNameOf(Class<?> clazz, Optional<String> className) {
			if (className.isPresent()) {
				return (clazz.getPackage().getName()+"."+className.get()).replace('.', '/')+".class";
			}
			return clazz.getName().replace('.', '/')+".class";
		}


	}
}
