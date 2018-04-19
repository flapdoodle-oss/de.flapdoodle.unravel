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

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.function.Supplier;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.Resources;

import de.flapdoodle.unravel.asm.ClazzParser;
import de.flapdoodle.unravel.types.AClass;
import io.vavr.collection.List;

public class Classes {

	public static Class<?> anonClass(Class<?> base, String ... anonName) {
		try {
			return Class.forName(base.getName()+"$"+Joiner.on("$").join(anonName));
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException("could not load anonClass "+base+""+anonName,e);
		}
	}
	
	public static AClass parse(Supplier<InputStream> byteCodeOf) {
		return new ClazzParser().parse(byteCodeOf);
	}

	public static Supplier<InputStream> byteCodeOf(java.lang.Class<?> clazz,java.lang.Class<?> ... otherClasses) {
		return Compilers.JavaC.byteCodeOf(JavaSource.of(clazz), JavaSource.of(otherClasses));
	} 
	
	public static Supplier<InputStream> byteCodeOf(java.lang.Class<?> base, String className) {
		return Compilers.JavaC.byteCodeOf(JavaSource.ofUnaccessableClass(base, className));
	}
	
	public static Supplier<InputStream> byteCodeOf(JavaSource javaSource, JavaSource ... otherSources) {
		return Compilers.JavaC.byteCodeOf(javaSource, otherSources);
	}
	
	private static InputStream byteCodeInputStream(java.lang.Class<?> base, String className) {
		return byteCodeInputStream(checkNotNull(resourceNameOf(base, className),"%s.%s",base,className));
	}

	private static InputStream byteCodeInputStream(java.lang.Class<?> clazz) {
		return byteCodeInputStream(checkNotNull(clazz.getResource(resourceNameOf(clazz)),"%s",clazz));
	}

	private static URL resourceNameOf(java.lang.Class<?> base, String className) {
		return base.getResource(className+".class");
	}

	private static String resourceNameOf(java.lang.Class<?> clazz) {
		String name = clazz.getName();
		int idx = name.lastIndexOf('.');
		return idx!=-1 ? name.substring(idx+1)+".class" : name+".class";
	}
	
	private static InputStream byteCodeInputStream(URL resource) {
		try {
			return Resources.asByteSource(checkNotNull(resource,"resource is null")).openStream();
		}
		catch (IOException e) {
			throw new RuntimeException("could get bytecode of "+resource, e);
		}
	}
	
	public static List<Supplier<InputStream>> byteCodeOfClasses(java.lang.Package pkg) {
		return classFilesOfPackage(pkg).stream()
			.map(resourceName -> streamSupplier(resourceName))
			.collect(List.collector());
	}

	
	public static ImmutableSet<String> classFilesOfPackage(java.lang.Package basePackage) {
		Reflections ref = new Reflections(new ConfigurationBuilder()
		     .setUrls(ClasspathHelper.forPackage(basePackage.getName()))
		     .setScanners(new ResourcesScanner(), new SubTypesScanner()/*, 
		                  new TypeAnnotationsScanner().filterResultsBy(optionalFilter)*/)
		     .filterInputsBy(new FilterBuilder().includePackage(basePackage.getName())));
		
		
		return ImmutableSet.copyOf(ref.getResources(name -> name.endsWith(".class")));
	}

	private static Supplier<InputStream> streamSupplier(String resourceName)
	{
		return () -> {
			try {
				return Resources.getResource(resourceName).openStream();
			}
			catch (IOException e) {
				throw new RuntimeException("could not load "+resourceName,e);
			}
		};
	}
}
