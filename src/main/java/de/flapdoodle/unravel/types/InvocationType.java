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

import org.objectweb.asm.Opcodes;

import de.flapdoodle.checks.Preconditions;

public enum InvocationType {
	INVOKESTATIC(Opcodes.INVOKESTATIC),
	INVOKEDYNAMIC(Opcodes.INVOKEDYNAMIC),
	INVOKEINTERFACE(Opcodes.INVOKEINTERFACE),
	INVOKESPECIAL(Opcodes.INVOKESPECIAL),
	INVOKEVIRTUAL(Opcodes.INVOKEVIRTUAL);
	
	private final int opcode;

	private InvocationType(int opcode) {
		this.opcode = opcode;
	}
	
	public static InvocationType ofOpcode(int opcode) {
		for (InvocationType t : values()) {
			if (t.opcode==opcode) {
				return t;
			}
		}
		return Preconditions.checkNotNull(null, "could not map opcode %s to invocationType", opcode);
	}
}
