package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.Calls.TypeReferenceCall;

public class TypeReferenceCallAssert extends AbstractAssert<TypeReferenceCallAssert, TypeReferenceCall> implements CommonAsserts {

	public TypeReferenceCallAssert(TypeReferenceCall actual) {
		super(actual, TypeReferenceCallAssert.class);
	}

	public TypeReferenceCallAssert clazz(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}

}
