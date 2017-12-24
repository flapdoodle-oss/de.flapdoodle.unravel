package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.Calls.FieldCall;

public class FieldCallAssert extends AbstractAssert<FieldCallAssert, FieldCall> implements CommonAsserts {

	public FieldCallAssert(FieldCall actual) {
		super(actual, FieldCallAssert.class);
	}
	
	public FieldCallAssert name(String name) {
		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
		return this;
	}

	public FieldCallAssert clazz(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public FieldCallAssert type(String type) {
		Assertions.assertThat(actual.type().value()).describedAs(propertyDescription("type")).isEqualTo(type);
		return this;
	}
}
