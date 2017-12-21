package de.flapdoodle.unravel.asm;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.AnEnumValue;

public class AnEnumValueAssert extends AbstractAssert<AnEnumValueAssert, AnEnumValue> implements CommonAsserts {

	public AnEnumValueAssert(AnEnumValue actual) {
		super(actual, AnEnumValueAssert.class);
	}
	
	public AnEnumValueAssert clazz(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public AnEnumValueAssert value(String value) {
		Assertions.assertThat(actual.value()).describedAs("value").isEqualTo(value);
		return this;
	}
}
