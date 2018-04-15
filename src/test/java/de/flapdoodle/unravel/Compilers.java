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
			return () -> byteCodeInputStream(clazz);
		}
		
		private static InputStream byteCodeInputStream(Class<?> clazz) {
			try {
				String sourceResourceName = sourceResourceNameOf(clazz);
				
				Compilation result = javac()
						.withClasspathFrom(Compilers.class.getClassLoader())
						.compile(JavaFileObjects.forResource(sourceResourceName));
					
				assertThat(result.errors()).isEmpty();
				assertThat(result.status()).isEqualByComparingTo(Status.SUCCESS);
				
				return byteCodeInputStreamOf(result, clazz, sourceResourceName);
			} catch (IOException iox) {
				throw new RuntimeException("error compiling "+clazz, iox);
			}
			
		}

		private static InputStream byteCodeInputStreamOf(Compilation result, Class<?> clazz, String sourceResourceName)
				throws IOException {
			String byteCodeResourceName = byteCodeResourceNameOf(clazz);
			
			ImmutableList<JavaFileObject> generatedFiles = result.generatedFiles();
			assertThat(generatedFiles).isNotEmpty();
			
			Optional<JavaFileObject> matching = generatedFiles.stream()
				.filter(javaFile -> javaFile.getName().endsWith(byteCodeResourceName))
				.findFirst();
			
			assertThat(matching)
				.describedAs("match from %s", generatedFiles)
				.isNotEmpty();
			
			return matching.get().openInputStream();
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
			return clazz.getName().replace('.', '/')+".java";
		}
		
		private static String byteCodeResourceNameOf(Class<?> clazz) {
			return clazz.getName().replace('.', '/')+".class";
		}
	}
}
