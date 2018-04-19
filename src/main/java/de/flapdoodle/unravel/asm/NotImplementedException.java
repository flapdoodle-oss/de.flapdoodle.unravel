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
package de.flapdoodle.unravel.asm;

import de.flapdoodle.checks.Preconditions;

public class NotImplementedException extends RuntimeException {

	public NotImplementedException(String message) {
		super(message);
	}

	public NotImplementedException(String message, Object... parameterMapAsList) {
		super(asMessage(message, parameterMapAsList));
	}

	private static String asMessage(String message, Object... parameterMapAsList) {
		Preconditions.checkArgument(parameterMapAsList.length % 2 == 0, "uneven parameter size: %s", parameterMapAsList.length);
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(message).append("\n");
		for (int i = 0; i < parameterMapAsList.length; i = i + 2) {
			sb.append(parameterMapAsList[i]).append(": ").append(parameterMapAsList[i + 1]).append(",\n");
		}
		return sb.toString();
	}

	public static <T> T with(String message, Object... parameterMapAsList) {
		throw new NotImplementedException(message, parameterMapAsList);
	}
}
