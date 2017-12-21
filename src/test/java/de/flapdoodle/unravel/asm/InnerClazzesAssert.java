package de.flapdoodle.unravel.asm;

import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.AnInnerClass;
import io.vavr.collection.List;

public class InnerClazzesAssert extends FactoryBasedNavigableIterableAssert<InnerClazzesAssert, Iterable<? extends AnInnerClass>, AnInnerClass, InnerClazzAssert> {

	public InnerClazzesAssert(List<AnInnerClass> actual) {
		super(actual, InnerClazzesAssert.class, t -> new InnerClazzAssert(t));
	}

	public static InnerClazzesAssert assertThatInnerClasses(List<AnInnerClass> fields) {
		return new InnerClazzesAssert(fields);
	}
}
