package de.flapdoodle.unravel.samples.asm.inherit;

import java.lang.annotation.Annotation;
import java.util.Objects;

public class ClassImplementsAnnotation implements SomeAnnotation {

	private final String value;
	public ClassImplementsAnnotation(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		ClassImplementsAnnotation that = (ClassImplementsAnnotation) o;
		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}
	@Override
	public String toString() {
		return "ClassImplementsAnnotation{}";
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		return SomeAnnotation.class;
	}
}
