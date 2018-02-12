package de.flapdoodle.unravel.signature;

import de.flapdoodle.unravel.types.ATypeName;

public interface UsageListener {
	UsageListener using(ATypeName type);
}
