/*
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

import org.objectweb.asm.Opcodes;

import de.flapdoodle.checks.Preconditions;

public enum HandleTag {
	GETFIELD(Opcodes.H_GETFIELD),
	GETSTATIC(Opcodes.H_GETSTATIC),
	PUTFIELD(Opcodes.H_PUTFIELD),
	PUTSTATIC(Opcodes.H_PUTSTATIC),
	INVOKEVIRTUAL(Opcodes.H_INVOKEVIRTUAL),
	INVOKESTATIC(Opcodes.H_INVOKESTATIC),
	INVOKESPECIAL(Opcodes.H_INVOKESPECIAL),
	NEWINVOKESPECIAL(Opcodes.H_NEWINVOKESPECIAL),
	INVOKEINTERFACE(Opcodes.H_INVOKEINTERFACE);

	private final int code;

	private HandleTag(int code) {
		this.code = code;
	}

	public static HandleTag fromCode(int code) {
		for (HandleTag t : values()) {
			if (t.code == code) {
				return t;
			}
		}
		return Preconditions.checkNotNull(null, "could not find tag for %s", code);
	}
}
