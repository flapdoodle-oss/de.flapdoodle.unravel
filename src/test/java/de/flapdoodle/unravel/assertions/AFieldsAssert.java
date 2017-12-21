package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.AField;
import io.vavr.collection.List;

public class AFieldsAssert extends FactoryBasedNavigableIterableAssert<AFieldsAssert, Iterable<? extends AField>, AField, AFieldAssert> implements CommonAsserts {

	public AFieldsAssert(List<AField> actual) {
		super(actual, AFieldsAssert.class, t -> new AFieldAssert(t));
	}

	public static AFieldsAssert assertThatFields(List<AField> fields) {
		return new AFieldsAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<AFieldsAssert, Iterable<? extends AField>, AField, AFieldAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
