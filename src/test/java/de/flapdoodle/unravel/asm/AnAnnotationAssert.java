package de.flapdoodle.unravel.asm;

import java.util.ArrayList;
import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AnAnnotation;
import de.flapdoodle.unravel.types.AnEnumValue;
import io.vavr.collection.List;

public class AnAnnotationAssert extends AbstractAssert<AnAnnotationAssert, AnAnnotation> implements CommonAsserts {

	public AnAnnotationAssert(AnAnnotation actual) {
		super(actual, AnAnnotationAssert.class);
	}
	
//	public AnAnnotationAssert accessFlags(AccessFlags ... values) {
//		Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).containsOnly(values);
//		return this;
//	}
//	
//	public AnAnnotationAssert name(String name) {
//		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
//		return this;
//	}
//
//	public AnAnnotationAssert rawType(String type) {
//		Assertions.assertThat(actual.type().raw()).describedAs(propertyDescription("type")).isEqualTo(type);
//		return this;
//	}
//	
	public AnAnnotationAssert clazz(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public AnAnnotationAssert valueAttributesContains(String key, Object ... expected) {
		java.util.List<Object> values = actual.valueAttributes().get(key)
				.map(t -> t.toJavaList())
				.getOrElse(new ArrayList<>());
		Assertions.assertThat(values).describedAs(propertyDescription("valueAttributes."+key)).contains(expected);
		return this;
	}

	public AnAnnotationAssert annotationAttributes(String key, Consumer<AnAnnotationsAssert> consumer) {
		List<AnAnnotation> values = actual.annotationAttributes().get(key)
				.map(t -> t.toList())
				.getOrElse(io.vavr.collection.List.empty());
		consumer.accept(AnAnnotationsAssert.assertThatAnnotations(values).describedAs(propertyDescription("annotationAttributes")));
		return this;
	}
	
	public AnAnnotationAssert enumAttributes(String key, Consumer<AnEnumValuesAssert> consumer) {
		List<AnEnumValue> values = actual.enumAttributes().get(key)
				.map(t -> t.toList())
				.getOrElse(io.vavr.collection.List.empty());
		consumer.accept(AnEnumValuesAssert.assertThatFields(values).describedAs(propertyDescription("enumAttributes")));
		return this;
	}
	
	public AnAnnotationAssert classAttributes(String key, String ... match) {
		List<ATypeName> values = actual.clazzAttributes().get(key)
				.map(t -> t.toList())
				.getOrElse(io.vavr.collection.List.empty());
		Assertions.assertThat(values).describedAs(propertyDescription("classAttributes")).containsAll(List.of(match).map(ATypeName::of));
		return this;
	}
}
