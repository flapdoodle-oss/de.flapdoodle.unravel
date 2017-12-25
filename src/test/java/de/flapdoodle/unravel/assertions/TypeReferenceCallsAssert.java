package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.Calls.TypeReferenceCall;
import io.vavr.collection.Set;

public class TypeReferenceCallsAssert extends FactoryBasedNavigableIterableAssert<TypeReferenceCallsAssert, Iterable<? extends TypeReferenceCall>, TypeReferenceCall, TypeReferenceCallAssert> implements CommonAsserts {

	public TypeReferenceCallsAssert(Set<TypeReferenceCall> actual) {
		super(actual, TypeReferenceCallsAssert.class, t -> new TypeReferenceCallAssert(t));
	}

	public static TypeReferenceCallsAssert assertThatTypeReferenceCalls(Set<TypeReferenceCall> fields) {
		return new TypeReferenceCallsAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<TypeReferenceCallsAssert, Iterable<? extends TypeReferenceCall>, TypeReferenceCall, TypeReferenceCallAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
