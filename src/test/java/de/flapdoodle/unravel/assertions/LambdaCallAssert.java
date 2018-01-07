package de.flapdoodle.unravel.assertions;

import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import de.flapdoodle.unravel.types.AMethodSignature;
import de.flapdoodle.unravel.types.AType;
import de.flapdoodle.unravel.types.ATypeName;
import de.flapdoodle.unravel.types.Calls.LambdaCall;

public class LambdaCallAssert extends AbstractAssert<LambdaCallAssert, LambdaCall> implements CommonAsserts {

	public LambdaCallAssert(LambdaCall actual) {
		super(actual, LambdaCallAssert.class);
	}
	
	public LambdaCallAssert name(String name) {
		Assertions.assertThat(actual.name()).describedAs(propertyDescription("name")).isEqualTo(name);
		return this;
	}

	public LambdaCallAssert clazz(String type) {
		Assertions.assertThat(actual.clazz().value()).describedAs(propertyDescription("clazz")).isEqualTo(type);
		return this;
	}
	
	public LambdaCallAssert factoryClazz(ATypeName type) {
		Assertions.assertThat(actual.factoryClazz()).describedAs(propertyDescription("factoryClazz")).isEqualTo(type);
		return this;
	}
	
	public LambdaCallAssert factorySignature(AMethodSignature signature) {
		Assertions.assertThat(actual.factorySignature()).describedAs(propertyDescription("factorySignature")).isEqualTo(signature);
		return this;
	}
	
	public LambdaCallAssert returnType(String type) {
		Assertions.assertThat(actual.signature().returnType()).describedAs(propertyDescription("returnType")).isEqualTo(AType.of(type, 0));
		return this;
	}
	
	public LambdaCallAssert returnType(AType type) {
		Assertions.assertThat(actual.signature().returnType()).describedAs(propertyDescription("returnType")).isEqualTo(type);
		return this;
	}
	
	public LambdaCallAssert parameterTypes(AType ...types) {
		if (types.length==0) {
			Assertions.assertThat(actual.signature().parameters()).describedAs(propertyDescription("parameterTypes")).isEmpty();
		} else {
			Assertions.assertThat(actual.signature().parameters()).describedAs(propertyDescription("parameterTypes")).containsExactly(types);
		}
		return this;
	}

	public LambdaCallAssert methodAsLambdaReturnType(AType type) {
		Assertions.assertThat(actual.methodAsLambdaSignature().returnType()).describedAs(propertyDescription("methodAsLambdaReturnType")).isEqualTo(type);
		return this;
	}
	
	public LambdaCallAssert methodAsLambdaParameterTypes(AType ...types) {
		if (types.length==0) {
			Assertions.assertThat(actual.methodAsLambdaSignature().parameters()).describedAs(propertyDescription("methodAsLambdaParameterTypes")).isEmpty();
		} else {
			Assertions.assertThat(actual.methodAsLambdaSignature().parameters()).describedAs(propertyDescription("methodAsLambdaParameterTypes")).containsExactly(types);
		}
		return this;
	}
	
	public LambdaCallAssert delegate(Consumer<MethodCallAssert> consumer) {
		consumer.accept(new MethodCallAssert(actual.delegate()).describedAs(propertyDescription("delegate")));
		return this;
	}

}
