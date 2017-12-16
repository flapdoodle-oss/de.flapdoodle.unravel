package de.flapdoodle.unravel.asm;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class FieldAssert extends AbstractAssert<FieldAssert, Field> {

	public FieldAssert(Field actual) {
		super(actual, FieldAssert.class);
	}
	
	private String propertyDescription(String property) {
		return descriptionText().isEmpty() ? property : property+" of "+descriptionText();
	}
	
	public FieldAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).containsOnly(values);
		return this;
	}
	
	public FieldAssert name(String name) {
		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
		return this;
	}

	public FieldAssert rawType(String type) {
		Assertions.assertThat(actual.type().raw()).describedAs(propertyDescription("type")).isEqualTo(type);
		return this;
	}
	
	public FieldAssert clazz(String type) {
		Assertions.assertThat(actual.type().clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public FieldAssert arrayDimension(int arrayDimension) {
		Assertions.assertThat(actual.type().arrayDimension()).describedAs(propertyDescription("arrayDimension")).isEqualTo(arrayDimension);
		return this;
	}
	
	public FieldAssert signature(String signature) {
		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isPresent().contains(signature);
		return this;
	}

	public FieldAssert hasNoSignature() {
		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isEmpty();
		return this;
	}

	public FieldAssert value(Object value) {
		Assertions.assertThat(actual.value()).describedAs("value").isPresent().contains(value);
		return this;
	}
	
	public FieldAssert hasNoValue() {
		Assertions.assertThat(actual.value()).describedAs("value").isEmpty();
		return this;
	}
}
