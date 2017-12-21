package de.flapdoodle.unravel;

import de.flapdoodle.unravel.asm.ClazzAssert;
import de.flapdoodle.unravel.types.AClass;

public abstract class Assertions extends org.assertj.core.api.Assertions {

	public static ClazzAssert assertThat(AClass actual) {
		return ClazzAssert.assertThat(actual);
	}
}
