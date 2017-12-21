package de.flapdoodle.unravel.asm;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import de.flapdoodle.unravel.types.AnAnnotation;
import io.vavr.collection.List;

public class AnAnnotationsAssert extends FactoryBasedNavigableIterableAssert<AnAnnotationsAssert, Iterable<? extends AnAnnotation>, AnAnnotation, AnAnnotationAssert> implements CommonAsserts {

	public AnAnnotationsAssert(List<AnAnnotation> actual) {
		super(actual, AnAnnotationsAssert.class, t -> new AnAnnotationAssert(t));
	}

	public static AnAnnotationsAssert assertThatAnnotations(List<AnAnnotation> annotations) {
		return new AnAnnotationsAssert(annotations);
	}
	
	@Override
	public AbstractIterableSizeAssert<AnAnnotationsAssert, Iterable<? extends AnAnnotation>, AnAnnotation, AnAnnotationAssert> size() {
		return super.size().describedAs(propertyDescription("size"));
	}
}
