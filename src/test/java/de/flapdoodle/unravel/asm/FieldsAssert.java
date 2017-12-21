package de.flapdoodle.unravel.asm;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.AField;
import io.vavr.collection.List;

public class FieldsAssert extends FactoryBasedNavigableIterableAssert<FieldsAssert, Iterable<? extends AField>, AField, FieldAssert> implements CommonAsserts {

	public FieldsAssert(List<AField> actual) {
		super(actual, FieldsAssert.class, t -> new FieldAssert(t));
	}

	public static FieldsAssert assertThatFields(List<AField> fields) {
		return new FieldsAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<FieldsAssert, Iterable<? extends AField>, AField, FieldAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
