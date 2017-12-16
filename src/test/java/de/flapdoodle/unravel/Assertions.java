package de.flapdoodle.unravel;

import de.flapdoodle.unravel.asm.Clazz;
import de.flapdoodle.unravel.asm.ClazzAssert;

public abstract class Assertions extends org.assertj.core.api.Assertions {

	public static ClazzAssert assertThat(Clazz actual) {
		return ClazzAssert.assertThat(actual);
	}
}
