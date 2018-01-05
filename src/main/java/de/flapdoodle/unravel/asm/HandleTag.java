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
			if (t.code==code) {
				return t;
			}
		}
		return Preconditions.checkNotNull(null, "could not find tag for %s", code);
	}
}
