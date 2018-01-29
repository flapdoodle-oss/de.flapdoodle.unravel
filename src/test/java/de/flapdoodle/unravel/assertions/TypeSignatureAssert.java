package de.flapdoodle.unravel.assertions;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.classes.Classnames;
import de.flapdoodle.unravel.signature.TypeSignature;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.AccessFlags;
import de.flapdoodle.unravel.types.JavaVersion;

public class TypeSignatureAssert extends AbstractAssert<TypeSignatureAssert, TypeSignature> implements CommonAsserts {

	public TypeSignatureAssert(TypeSignature actual) {
		super(actual, TypeSignatureAssert.class);
	}
	
	public TypeSignatureAssert isJava8() {
    if (actual.javaVersion()!=JavaVersion.V1_8) {
      failWithMessage(propertyDescription("javaVersion")+" expected to be <%s> but was <%s>", JavaVersion.V1_8, actual.javaVersion());
    }
		return this;
	}
	
	public TypeSignatureAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags())
			.describedAs(propertyDescription("accessFlags"))
			.containsOnly(values);
		return this;
	}
	
	public TypeSignatureAssert superClass(Class<?> type) {
		Assertions.assertThat(actual.superClazz()).describedAs(propertyDescription("superClazz")).isPresent();
		Assertions.assertThat(actual.superClazz().get().value()).describedAs(propertyDescription("superClazz")).isEqualTo(Classnames.nameOf(type));
		return this;
	}
	
	public TypeSignatureAssert interfaces(String ... name) {
		if (name.length==0) {
			Assertions.assertThat(actual.interfaces()).describedAs(propertyDescription("interfaces")).isEmpty();
		} else {
			Assertions.assertThat(actual.interfaces().map(ATypeName::value)).describedAs(propertyDescription("interfaces")).contains(name);
		}
		return this;
	}
	
	public TypeSignatureAssert typeNameIs(String name) {
		Assertions.assertThat(actual.typeName().value()).describedAs(propertyDescription("typeName")).isEqualTo(name);
		return this;
	}
	
	public TypeSignatureAssert typeNameIs(ATypeName name) {
		Assertions.assertThat(actual.typeName()).describedAs(propertyDescription("typeName")).isEqualTo(name);
		return this;
	}

//	public TypeSignatureAssert fields(Consumer<AFieldsAssert> consumer) {
//		consumer.accept(AFieldsAssert.assertThatFields(actual.fields()).describedAs("fields"));
//		return this;
//	}
//	
//	public TypeSignatureAssert methods(Consumer<AMethodsAssert> consumer) {
//		consumer.accept(AMethodsAssert.assertThatMethods(actual.methods()).describedAs("methods"));
//		return this;
//	}
//	
	public TypeSignatureAssert innerClasses(Consumer<TypeSignaturesAssert> consumer) {
		consumer.accept(TypeSignaturesAssert.assertThatTypeSignatures(actual.innerClasses()).describedAs(propertyDescription("innerClasses")));
		return this;
	}
//	
//	public TypeSignatureAssert annotations(Consumer<AnAnnotationsAssert> consumer) {
//		consumer.accept(AnAnnotationsAssert.assertThatAnnotations(actual.annotations()).describedAs("annotations"));
//		return this;
//	}
	
	public static TypeSignatureAssert assertThat(TypeSignature actual) {
		return new TypeSignatureAssert(actual);
	}
}
