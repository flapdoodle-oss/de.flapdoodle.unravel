package de.flapdoodle.unravel;

import de.flapdoodle.unravel.asm.Clazz;
import de.flapdoodle.unravel.asm.ClazzAssert;
import de.flapdoodle.unravel.asm.Field;
import de.flapdoodle.unravel.asm.FieldsAssert;
import io.vavr.collection.List;

public abstract class Assertions extends org.assertj.core.api.Assertions {

	public static ClazzAssert assertThat(Clazz actual) {
		return ClazzAssert.assertThat(actual);
	}

	public static FieldsAssert assertThat(List<Field> actual) {
		return new FieldsAssert(actual);
	}
}
