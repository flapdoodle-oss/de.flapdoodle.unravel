package de.flapdoodle.unravel.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.Calls.MethodCall;
import de.flapdoodle.unravel.types.InvocationType;

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
		Assertions.assertThat(actual.signature().returnType()).describedAs(propertyDescription("returnType")).isEqualTo(AType.of(type, 0));
		return this;
	}
	
	public MethodCallAssert returnType(AType type) {
		Assertions.assertThat(actual.signature().returnType()).describedAs(propertyDescription("returnType")).isEqualTo(type);
		return this;
	}
	
	public MethodCallAssert invocationType(InvocationType type) {
		Assertions.assertThat(actual.invocationType()).describedAs(propertyDescription("invocationType")).isEqualTo(type);
		return this;
	}
	
	public MethodCallAssert parameterTypes(AType ...types) {
		if (types.length==0) {
			Assertions.assertThat(actual.signature().parameters()).describedAs(propertyDescription("parameterTypes")).isEmpty();
		} else {
			Assertions.assertThat(actual.signature().parameters()).describedAs(propertyDescription("parameterTypes")).containsExactly(types);
		}
		return this;
	}

}
