package de.flapdoodle.unravel;

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

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.Resources;

import io.vavr.collection.List;

public class Classes {

	
	public static Supplier<InputStream> byteCodeOf(java.lang.Class<?> clazz) {
		return () -> byteCodeInputStream(clazz);
	}
	
	public static Supplier<InputStream> byteCodeOf(java.lang.Class<?> base, String className) {
		return () -> byteCodeInputStream(base, className);
	}
	
	private static InputStream byteCodeInputStream(java.lang.Class<?> base, String className) {
		return byteCodeInputStream(base.getResource(className+".class"));
	}

	private static InputStream byteCodeInputStream(java.lang.Class<?> clazz) {
		return byteCodeInputStream(clazz.getResource(clazz.getSimpleName()+".class"));
	}
	
	private static InputStream byteCodeInputStream(URL resource) {
		try {
			return Resources.asByteSource(Preconditions.checkNotNull(resource,"could not get resource of %s",resource)).openStream();
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
