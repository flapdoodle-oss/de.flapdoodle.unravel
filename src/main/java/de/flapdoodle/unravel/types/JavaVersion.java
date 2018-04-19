/**
 * Copyright (C) 2017
 *   Michael Mosmann <michael@mosmann.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.unravel.types;

import de.flapdoodle.checks.Preconditions;

public enum JavaVersion {
	V1_1(3 << 16 | 45),
	V1_2(0 << 16 | 46),
	V1_3(0 << 16 | 47),
	V1_4(0 << 16 | 48),
	V1_5(0 << 16 | 49),
	V1_6(0 << 16 | 50),
	V1_7(0 << 16 | 51),
	V1_8(0 << 16 | 52),
	V9(0 << 16 | 53);

	private final int value;

	private JavaVersion(int value) {
		this.value = value;
	}

	public static JavaVersion of(int value) {
		for (JavaVersion v : JavaVersion.values()) {
			if (v.value == value) {
				return v;
			}
		}

		return Preconditions.checkNotNull(null, "could not find version for %s", value);
	}
}
