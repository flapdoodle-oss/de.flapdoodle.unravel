package de.flapdoodle.unravel.asm;

public interface CommonAsserts {

	default String propertyDescription(String property) {
		return descriptionText().isEmpty() ? property : property+" of "+descriptionText();
	}

	String descriptionText();
}
