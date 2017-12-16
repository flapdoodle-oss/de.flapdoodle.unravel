package de.flapdoodle.unravel.asm;

import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import io.vavr.collection.List;

public class InnerClazzesAssert extends FactoryBasedNavigableIterableAssert<InnerClazzesAssert, Iterable<? extends InnerClazz>, InnerClazz, InnerClazzAssert> {

	public InnerClazzesAssert(List<InnerClazz> actual) {
		super(actual, InnerClazzesAssert.class, t -> new InnerClazzAssert(t));
	}

	public static InnerClazzesAssert assertThatInnerClasses(List<InnerClazz> fields) {
		return new InnerClazzesAssert(fields);
	}

}
