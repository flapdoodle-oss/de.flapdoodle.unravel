package de.flapdoodle.unravel.asm;

import org.assertj.core.api.FactoryBasedNavigableIterableAssert;

import io.vavr.collection.List;

public class AnAnnotationsAssert extends FactoryBasedNavigableIterableAssert<AnAnnotationsAssert, Iterable<? extends AnAnnotation>, AnAnnotation, AnAnnotationAssert> {

	public AnAnnotationsAssert(List<AnAnnotation> actual) {
		super(actual, AnAnnotationsAssert.class, t -> new AnAnnotationAssert(t));
	}

	public static AnAnnotationsAssert assertThatAnnotations(List<AnAnnotation> fields) {
		return new AnAnnotationsAssert(fields);
	}
}
