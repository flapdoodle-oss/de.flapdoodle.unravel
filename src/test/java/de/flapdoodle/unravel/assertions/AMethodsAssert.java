package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.AMethod;
import io.vavr.collection.List;

public class AMethodsAssert extends FactoryBasedNavigableIterableAssert<AMethodsAssert, Iterable<? extends AMethod>, AMethod, AMethodAssert> implements CommonAsserts {

	public AMethodsAssert(List<AMethod> actual) {
		super(actual, AMethodsAssert.class, t -> new AMethodAssert(t));
	}

	public static AMethodsAssert assertThatMethods(List<AMethod> fields) {
		return new AMethodsAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<AMethodsAssert, Iterable<? extends AMethod>, AMethod, AMethodAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
