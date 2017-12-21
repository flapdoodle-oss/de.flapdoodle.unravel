package de.flapdoodle.unravel.assertions;

public interface CommonAsserts {

	default String propertyDescription(String property) {
		return descriptionText().isEmpty() ? property : property+" of "+descriptionText();
	}

	String descriptionText();
}
