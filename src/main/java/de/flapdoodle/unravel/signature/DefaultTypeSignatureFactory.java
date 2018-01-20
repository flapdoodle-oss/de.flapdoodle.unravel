package de.flapdoodle.unravel.signature;

import java.util.function.Function;

import de.flapdoodle.checks.Preconditions;
import de.flapdoodle.unravel.types.AClass;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.AnInnerClass;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import io.vavr.control.Option;

public class DefaultTypeSignatureFactory implements SignatureOfAClassFactory {

	@Override
	public TypeSignature signatureOf(AClass src, Function<ATypeName, Option<AClass>> classOfTypeName) {
		return signatureOf(src, classOfTypeName, Option.none(), HashSet.empty());
	}

	private static List<TypeSignature> resolve(List<AnInnerClass> innerClasses, Function<ATypeName, Option<AClass>> classOfTypeName, Set<ATypeName> visitedTypes) {
		return innerClasses.map(inner -> {
			Option<AClass> resolvedClass = classOfTypeName.apply(inner.typeName());
			Preconditions.checkArgument(resolvedClass.isDefined(), "could not resolve class %s", inner.typeName());
			return signatureOf(resolvedClass.get(), classOfTypeName, Option.of(inner.accessFlags()), visitedTypes);
		});
	}

	private static TypeSignature signatureOf(AClass src, Function<ATypeName, Option<AClass>> classOfTypeName, Option<Set<AccessFlags>> overrideAccessFlags, Set<ATypeName> visitedTypes) {
		System.out.println(src.typeName()+" -> "+src.innerClasses());
		
		Set<ATypeName> newFilter = visitedTypes.add(src.typeName());
		
		return TypeSignature.builder(src.typeName())
				.javaVersion(src.javaVersion())
				.accessFlags(overrideAccessFlags.getOrElse(src.accessFlags()))
				.superClazz(src.superClazz())
				.interfaces(src.interfaces())
				.innerClasses(resolve(filtered(src.innerClasses(), newFilter), classOfTypeName, newFilter))
				.build();
	}

	private static List<AnInnerClass> filtered(List<AnInnerClass> innerClasses, Set<ATypeName> skip) {
		return innerClasses
				.filter(in -> !skip.contains(in.typeName()));
	}

}
