package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.AnInnerClass;

public class InnerClazzAssert extends AbstractAssert<InnerClazzAssert, AnInnerClass> implements CommonAsserts {

	public InnerClazzAssert(AnInnerClass actual) {
		super(actual, InnerClazzAssert.class);
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
