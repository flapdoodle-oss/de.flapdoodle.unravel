package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.Calls.MethodCall;
import io.vavr.collection.Set;

public class MethodCallsAssert extends FactoryBasedNavigableIterableAssert<MethodCallsAssert, Iterable<? extends MethodCall>, MethodCall, MethodCallAssert> implements CommonAsserts {

	public MethodCallsAssert(Set<MethodCall> actual) {
		super(actual, MethodCallsAssert.class, t -> new MethodCallAssert(t));
	}

	public static MethodCallsAssert assertThatMethodCalls(Set<MethodCall> fields) {
		return new MethodCallsAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<MethodCallsAssert, Iterable<? extends MethodCall>, MethodCall, MethodCallAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
