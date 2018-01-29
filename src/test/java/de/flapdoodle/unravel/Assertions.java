package de.flapdoodle.unravel;

import de.flapdoodle.unravel.assertions.ClazzAssert;
import de.flapdoodle.unravel.assertions.TypeSignatureAssert;
import de.flapdoodle.unravel.signature.TypeSignature;
import de.flapdoodle.unravel.types.AClass;

public abstract class Assertions extends org.assertj.core.api.Assertions {

	public static ClazzAssert assertThat(AClass actual) {
		return ClazzAssert.assertThat(actual);
	}

	public static TypeSignatureAssert assertThat(TypeSignature signature) {
		return TypeSignatureAssert.assertThat(signature);
	}
}
