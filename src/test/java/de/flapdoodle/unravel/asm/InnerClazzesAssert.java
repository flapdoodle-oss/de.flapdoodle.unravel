package de.flapdoodle.unravel.asm;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.AnInnerClass;
import io.vavr.collection.List;

public class InnerClazzesAssert extends FactoryBasedNavigableIterableAssert<InnerClazzesAssert, Iterable<? extends AnInnerClass>, AnInnerClass, InnerClazzAssert> implements CommonAsserts {

	public InnerClazzesAssert(List<AnInnerClass> actual) {
		super(actual, InnerClazzesAssert.class, t -> new InnerClazzAssert(t));
	}

	public static InnerClazzesAssert assertThatInnerClasses(List<AnInnerClass> fields) {
		return new InnerClazzesAssert(fields);
	}
	
	@Override
	public AbstractIterableSizeAssert<InnerClazzesAssert, Iterable<? extends AnInnerClass>, AnInnerClass, InnerClazzAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
