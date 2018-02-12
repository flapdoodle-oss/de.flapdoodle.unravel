package de.flapdoodle.unravel.signature;

import de.flapdoodle.unravel.types.ATypeName;

public class CollectingUsageListener implements UsageListener {

	@Override
	public UsageListener using(ATypeName type) {
		return this;
	}

	public Usage aggregate() {
		return Usage.builder()
				.build();
	}

}
