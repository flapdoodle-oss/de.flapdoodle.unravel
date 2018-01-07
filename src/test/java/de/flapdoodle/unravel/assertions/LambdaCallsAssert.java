package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.Calls.LambdaCall;
import io.vavr.collection.Set;

public class LambdaCallsAssert extends FactoryBasedNavigableIterableAssert<LambdaCallsAssert, Iterable<? extends LambdaCall>, LambdaCall, LambdaCallAssert> implements CommonAsserts {

	public LambdaCallsAssert(Set<LambdaCall> actual) {
		super(actual, LambdaCallsAssert.class, t -> new LambdaCallAssert(t));
	}

	public static LambdaCallsAssert assertThatLambdaCalls(Set<LambdaCall> fields) {
		return new LambdaCallsAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<LambdaCallsAssert, Iterable<? extends LambdaCall>, LambdaCall, LambdaCallAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
