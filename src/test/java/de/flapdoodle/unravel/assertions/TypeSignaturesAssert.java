package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.signature.TypeSignature;
import io.vavr.collection.List;

public class TypeSignaturesAssert extends FactoryBasedNavigableIterableAssert<TypeSignaturesAssert, Iterable<? extends TypeSignature>, TypeSignature, TypeSignatureAssert> implements CommonAsserts {

	public TypeSignaturesAssert(List<TypeSignature> actual) {
		super(actual, TypeSignaturesAssert.class, t -> TypeSignatureAssert.assertThat(t));
	}

	public static TypeSignaturesAssert assertThatTypeSignatures(List<TypeSignature> fields) {
		return new TypeSignaturesAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<TypeSignaturesAssert, Iterable<? extends TypeSignature>, TypeSignature, TypeSignatureAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
