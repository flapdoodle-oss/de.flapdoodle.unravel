package de.flapdoodle.unravel.asm;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.AnEnumValue;
import io.vavr.collection.List;

public class AnEnumValuesAssert extends FactoryBasedNavigableIterableAssert<AnEnumValuesAssert, Iterable<? extends AnEnumValue>, AnEnumValue, AnEnumValueAssert> implements CommonAsserts {

	public AnEnumValuesAssert(List<AnEnumValue> actual) {
		super(actual, AnEnumValuesAssert.class, t -> new AnEnumValueAssert(t));
	}

	public static AnEnumValuesAssert assertThatFields(List<AnEnumValue> enums) {
		return new AnEnumValuesAssert(enums);
	}
	
	@Override
	public AbstractIterableSizeAssert<AnEnumValuesAssert, Iterable<? extends AnEnumValue>, AnEnumValue, AnEnumValueAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
