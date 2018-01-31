package de.flapdoodle.unravel.signature;

import java.util.function.Function;
import java.util.function.Predicate;

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
	
	private static TypeSignature signatureOf(AClass src, Function<ATypeName, Option<AClass>> classOfTypeName, Option<Set<AccessFlags>> overrideAccessFlags, Set<ATypeName> visitedTypes) {
		return TypeSignature.builder(src.typeName())
			.javaVersion(src.javaVersion())
			.accessFlags(src.accessFlags())
			.superClazz(src.superClazz())
			.interfaces(src.interfaces())
			.innerClasses(innerClassesOf(src.typeName(), classOfTypeName, src.innerClasses(),visitedTypes.add(src.typeName())))
			.build();
	}

	private static List<TypeSignature> innerClassesOf(ATypeName typeName, Function<ATypeName, Option<AClass>> classOfTypeName, List<AnInnerClass> innerClasses, Set<ATypeName> visitedTypes) {
		return innerClasses.filter(innerClassesWithoutOrWithMatchingParent(typeName, visitedTypes))
				.map(inner -> {
					Option<AClass> optResolved = classOfTypeName.apply(inner.typeName());
					Preconditions.checkArgument(optResolved.isDefined(), "could not resolve %s", inner.typeName());
					return signatureOf(optResolved.get(), classOfTypeName, Option.of(inner.accessFlags()), visitedTypes);
				});
	}

	private static Predicate<? super AnInnerClass> innerClassesWithoutOrWithMatchingParent(ATypeName typeName, Set<ATypeName> visitedTypes) {
		return inner -> !inner.typeName().equals(typeName) && !visitedTypes.contains(inner.typeName()) && (!inner.outerName().isPresent() || inner.outerName().get().equals(typeName));
	}


}
