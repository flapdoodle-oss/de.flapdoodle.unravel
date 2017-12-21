package de.flapdoodle.unravel.asm;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.AnInnerClass;
import de.flapdoodle.unravel.types.ATypeName;

public class InnerClazzAssert extends AbstractAssert<InnerClazzAssert, AnInnerClass> {

	public InnerClazzAssert(AnInnerClass actual) {
		super(actual, InnerClazzAssert.class);
	}
	
	private String propertyDescription(String property) {
		return descriptionText().isEmpty() ? property : property+" of "+descriptionText();
	}
	
	public InnerClazzAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).containsOnly(values);
		return this;
	}
	
	public InnerClazzAssert typeName(String name) {
		Assertions.assertThat(actual.typeName().value()).describedAs(propertyDescription("typeName")).isEqualTo(name);
		return this;
	}
	
	public InnerClazzAssert noInnerName() {
		Assertions.assertThat(actual.innerName()).describedAs(propertyDescription("innerName")).isEmpty();
		return this;
	}
	
	public InnerClazzAssert innerName(String name) {
		Assertions.assertThat(actual.innerName()).describedAs(propertyDescription("innerName")).contains(ATypeName.of(name));
		return this;
	}
	
	public InnerClazzAssert noOuterName() {
		Assertions.assertThat(actual.outerName()).describedAs(propertyDescription("outerName")).isEmpty();
		return this;
	}
	
	public InnerClazzAssert outerName(String name) {
		Assertions.assertThat(actual.outerName()).describedAs(propertyDescription("outerName")).contains(ATypeName.of(name));
		return this;
	}
}
