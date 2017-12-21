package de.flapdoodle.unravel.samples.asm.basics;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Annotations {

	@Retention(RetentionPolicy.RUNTIME)
	public @interface RetentionRuntime {	}
	
	@Retention(RetentionPolicy.CLASS)
	public @interface RetentionClass {	}

	@Retention(RetentionPolicy.SOURCE)
	public @interface RetentionSource {	}
	
	@RetentionRuntime
	@RetentionClass
	@RetentionSource
	public static class RetentionSample {
		
	}
	
	
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Wrapper {	
		Wrapped[] value();
	}

	@Repeatable(Wrapper.class)
	public @interface Wrapped {
		WrappedWrapped[] value();
	}

	public @interface WrappedWrapped {	
		String value();
	}
	
	@Wrapped({})
	@Wrapped(@WrappedWrapped("a"))
	@Wrapped({@WrappedWrapped("b"), @WrappedWrapped("c")})
	public static class WrapperSample {
		
	}
}
