package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.Calls.MethodCall;

public class MethodCallAssert extends AbstractAssert<MethodCallAssert, MethodCall> implements CommonAsserts {

	public MethodCallAssert(MethodCall actual) {
		super(actual, MethodCallAssert.class);
	}
	
	public MethodCallAssert name(String name) {
		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
		return this;
	}

	public MethodCallAssert clazz(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public MethodCallAssert returnType(String type) {
		Assertions.assertThat(actual.returnType().value()).describedAs(propertyDescription("returnType")).isEqualTo(type);
		return this;
	}
	
	public MethodCallAssert parameterTypes(String ...names) {
		if (names.length==0) {
			Assertions.assertThat(actual.parameters()).describedAs(propertyDescription("parameterTypes")).isEmpty();
		} else {
			Assertions.assertThat(actual.parameters().map(ATypeName::value)).describedAs(propertyDescription("parameterTypes")).contains(names);
		}
		return this;
	}


}
