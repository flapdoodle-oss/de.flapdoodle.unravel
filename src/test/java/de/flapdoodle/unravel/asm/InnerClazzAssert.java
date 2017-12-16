package de.flapdoodle.unravel.asm;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class InnerClazzAssert extends AbstractAssert<InnerClazzAssert, InnerClazz> {

	public InnerClazzAssert(InnerClazz actual) {
		super(actual, InnerClazzAssert.class);
	}
	
	public InnerClazzAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).describedAs("accessFlags").containsOnly(values);
		return this;
	}
	
	public InnerClazzAssert typeName(String name) {
		Assertions.assertThat(actual.typeName().value()).describedAs("typeName").isEqualTo(name);
		return this;
	}
	
	public InnerClazzAssert innerName(String name) {
		Assertions.assertThat(actual.innerName().value()).describedAs("innerName").isEqualTo(name);
		return this;
	}
	
	public InnerClazzAssert outerName(String name) {
		Assertions.assertThat(actual.outerName().value()).describedAs("outerName").isEqualTo(name);
		return this;
	}
}
