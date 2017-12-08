package de.flapdoodle.unravel.asm;

import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import io.vavr.collection.List;

public class FieldsAssert extends FactoryBasedNavigableIterableAssert<FieldsAssert, Iterable<? extends Field>, Field, FieldAssert> {

	public FieldsAssert(List<Field> actual) {
		super(actual, FieldsAssert.class, t -> new FieldAssert(t));
	}

}
