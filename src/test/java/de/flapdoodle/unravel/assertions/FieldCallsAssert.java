package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.Calls.FieldCall;
import io.vavr.collection.Set;

public class FieldCallsAssert extends FactoryBasedNavigableIterableAssert<FieldCallsAssert, Iterable<? extends FieldCall>, FieldCall, FieldCallAssert> implements CommonAsserts {

	public FieldCallsAssert(Set<FieldCall> actual) {
		super(actual, FieldCallsAssert.class, t -> new FieldCallAssert(t));
	}

	public static FieldCallsAssert assertThatFieldCalls(Set<FieldCall> fields) {
		return new FieldCallsAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<FieldCallsAssert, Iterable<? extends FieldCall>, FieldCall, FieldCallAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
