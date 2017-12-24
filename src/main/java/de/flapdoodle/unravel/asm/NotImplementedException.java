package de.flapdoodle.unravel.asm;

import de.flapdoodle.checks.Preconditions;

public class NotImplementedException extends RuntimeException {

	public NotImplementedException(String message) {
		super(message);
	}
	
	public NotImplementedException(String message, Object ... parameterMapAsList) {
		super(asMessage(message, parameterMapAsList));
	}

	private static String asMessage(String message, Object ... parameterMapAsList) {
		Preconditions.checkArgument(parameterMapAsList.length % 2 == 0,"uneven parameter size: %s", parameterMapAsList.length);
		StringBuilder sb=new StringBuilder();
		sb.append(message).append(" ");
		for (int i=0;i<parameterMapAsList.length;i=i+2) {
			sb.append(parameterMapAsList[i]).append(": ").append(parameterMapAsList[i+1]).append(", ");
		}
		return sb.toString();
	}
	
	public static <T> T with(String message, Object ... parameterMapAsList) {
		throw new NotImplementedException(message, parameterMapAsList);
	}
}
