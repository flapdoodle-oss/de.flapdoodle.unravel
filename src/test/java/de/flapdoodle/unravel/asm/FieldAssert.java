package de.flapdoodle.unravel.asm;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class FieldAssert extends AbstractAssert<FieldAssert, Field> {

	public FieldAssert(Field actual) {
		super(actual, FieldAssert.class);
	}
	
	public FieldAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).containsOnly(values);
		return this;
	}
	

}
