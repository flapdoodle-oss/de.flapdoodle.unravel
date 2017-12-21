package de.flapdoodle.unravel.asm;

import java.util.ArrayList;
import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;

import de.flapdoodle.unravel.Assertions;
import de.flapdoodle.unravel.types.AnAnnotation;
import io.vavr.collection.List;

public class AnAnnotationAssert extends AbstractAssert<AnAnnotationAssert, AnAnnotation> {

	public AnAnnotationAssert(AnAnnotation actual) {
		super(actual, AnAnnotationAssert.class);
	}
	
	private String propertyDescription(String property) {
		return descriptionText().isEmpty() ? property : property+" of "+descriptionText();
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
	
	public AnAnnotationAssert usedAttributes(String ... values) {
		Assertions.assertThat(actual.usedAttributes()).describedAs(propertyDescription("usedAttributes")).contains(values);
		return this;
	}

	public AnAnnotationAssert attributeMapContains(String key, Object ... expected) {
		java.util.List<Object> values = actual.attributeMap().get(key)
				.map(t -> t.toJavaList())
				.getOrElse(new ArrayList<>());
		Assertions.assertThat(values).describedAs(propertyDescription("attributeMap."+key)).contains(expected);
		return this;
	}

	public AnAnnotationAssert annotationAttributes(String key, Consumer<AnAnnotationsAssert> annotationsAssertConsumer) {
		List<AnAnnotation> values = actual.annotationAttributes().get(key)
				.map(t -> t.toList())
				.getOrElse(io.vavr.collection.List.empty());
		annotationsAssertConsumer.accept(AnAnnotationsAssert.assertThatAnnotations(values).describedAs(propertyDescription("attributeMap."+key)));
		return this;
	}
	
//	public AnAnnotationAssert arrayDimension(int arrayDimension) {
//		Assertions.assertThat(actual.type().arrayDimension()).describedAs(propertyDescription("arrayDimension")).isEqualTo(arrayDimension);
//		return this;
//	}
//	
//	public AnAnnotationAssert signature(String signature) {
//		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isPresent().contains(signature);
//		return this;
//	}
//
//	public AnAnnotationAssert hasNoSignature() {
//		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isEmpty();
//		return this;
//	}
//
//	public AnAnnotationAssert value(Object value) {
//		Assertions.assertThat(actual.value()).describedAs("value").isPresent().contains(value);
//		return this;
//	}
//	
//	public AnAnnotationAssert hasNoValue() {
//		Assertions.assertThat(actual.value()).describedAs("value").isEmpty();
//		return this;
//	}
}
