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
