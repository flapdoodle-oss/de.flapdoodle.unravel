package de.flapdoodle.unravel.assertions;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.AMethod;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;

public class AMethodAssert extends AbstractAssert<AMethodAssert, AMethod> implements CommonAsserts {

	public AMethodAssert(AMethod actual) {
		super(actual, AMethodAssert.class);
	}
	
	public AMethodAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).describedAs(propertyDescription("accessFlags")).containsOnly(values);
		return this;
	}
	
	public AMethodAssert name(String name) {
		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
		return this;
	}

	public AMethodAssert returnType(String name) {
		Assertions.assertThat(actual.returnType().value()).describedAs(propertyDescription("returnType")).isEqualTo(name);
		return this;
	}

	public AMethodAssert parameterTypes(String ...names) {
		if (names.length==0) {
			Assertions.assertThat(actual.parameters()).describedAs(propertyDescription("parameterTypes")).isEmpty();
		} else {
			Assertions.assertThat(actual.parameters().map(ATypeName::value)).describedAs(propertyDescription("parameterTypes")).contains(names);
		}
		return this;
	}

	public AMethodAssert exceptions(String ...names) {
		if (names.length==0) {
			Assertions.assertThat(actual.exceptions()).describedAs(propertyDescription("exceptions")).isEmpty();
		} else {
			Assertions.assertThat(actual.exceptions().map(ATypeName::value)).describedAs(propertyDescription("exceptions")).contains(names);
		}
		return this;
	}
	
	public AMethodAssert annotations(Consumer<AnAnnotationsAssert> consumer) {
		consumer.accept(AnAnnotationsAssert.assertThatAnnotations(actual.annotations()).describedAs("annotations"));
		return this;
	}

	
//	public AMethodAssert rawType(String type) {
//		Assertions.assertThat(actual.type().raw()).describedAs(propertyDescription("type")).isEqualTo(type);
//		return this;
//	}
//	
//	public AMethodAssert clazz(String type) {
//		Assertions.assertThat(actual.type().clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
//		return this;
//	}
//	
//	public AMethodAssert arrayDimension(int arrayDimension) {
//		Assertions.assertThat(actual.type().arrayDimension()).describedAs(propertyDescription("arrayDimension")).isEqualTo(arrayDimension);
//		return this;
//	}
//	
	public AMethodAssert signature(String signature) {
		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isPresent().contains(signature);
		return this;
	}

	public AMethodAssert hasNoSignature() {
		Assertions.assertThat(actual.genericSignature()).describedAs(propertyDescription("genericSignature")).isEmpty();
		return this;
	}
//
//	public AMethodAssert value(Object value) {
//		Assertions.assertThat(actual.value()).describedAs("value").isPresent().contains(value);
//		return this;
//	}
//	
//	public AMethodAssert hasNoValue() {
//		Assertions.assertThat(actual.value()).describedAs("value").isEmpty();
//		return this;
//	}
}
