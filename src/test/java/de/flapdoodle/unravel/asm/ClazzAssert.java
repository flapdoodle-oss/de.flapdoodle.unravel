package de.flapdoodle.unravel.asm;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.classes.Classnames;

public class ClazzAssert extends AbstractAssert<ClazzAssert, Clazz> {

	public ClazzAssert(Clazz actual) {
		super(actual, ClazzAssert.class);
	}
	
	public ClazzAssert isJava8() {
    if (actual.javaVersion()!=JavaVersion.V1_8) {
      failWithMessage("Expected java version to be <%s> but was <%s>", JavaVersion.V1_8, actual.javaVersion());
    }
		return this;
	}
	
	public ClazzAssert signature(String signature) {
		Assertions.assertThat(actual.genericSignature()).describedAs("genericSignature").isPresent().contains(signature);
		return this;
	}

	public ClazzAssert hasNoSignature() {
		Assertions.assertThat(actual.genericSignature()).describedAs("genericSignature").isEmpty();
		return this;
	}
	
	public ClazzAssert accessFlags(AccessFlags ... values) {
		Assertions.assertThat(actual.accessFlags()).containsOnly(values);
		return this;
	}
	
	public ClazzAssert superClass(Class<?> type) {
		Assertions.assertThat(actual.superClazz()).isPresent();
		Assertions.assertThat(actual.superClazz().get().value()).isEqualTo(Classnames.nameOf(type));
		return this;
	}
	
	public ClazzAssert typeNameIs(String name) {
		Assertions.assertThat(actual.typeName().value()).isEqualTo(name);
		return this;
	}

	public ClazzAssert fields(Consumer<FieldsAssert> fieldsAssertConsumer) {
		fieldsAssertConsumer.accept(FieldsAssert.assertThatFields(actual.fields()));
		return this;
	}
	
	public ClazzAssert innerClasses(Consumer<InnerClazzesAssert> innerClassesAssertConsumer) {
		innerClassesAssertConsumer.accept(InnerClazzesAssert.assertThatInnerClasses(actual.innerClasses()));
		return this;
	}
	
	public ClazzAssert annotations(Consumer<AnAnnotationsAssert> annotationsAssertConsumer) {
		annotationsAssertConsumer.accept(AnAnnotationsAssert.assertThatAnnotations(actual.annotations()));
		return this;
	}
	
	public static ClazzAssert assertThat(Clazz actual) {
		return new ClazzAssert(actual);
	}
}
