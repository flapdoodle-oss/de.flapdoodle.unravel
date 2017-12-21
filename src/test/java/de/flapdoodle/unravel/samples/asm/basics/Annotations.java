package de.flapdoodle.unravel.samples.asm.basics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotations {

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.ANNOTATION_TYPE,
			ElementType.CONSTRUCTOR,
			ElementType.FIELD,
			ElementType.LOCAL_VARIABLE,
			ElementType.METHOD,
			ElementType.PACKAGE,
			ElementType.PARAMETER,
			ElementType.TYPE,
			ElementType.TYPE_USE,
			ElementType.TYPE_PARAMETER,
	})
	public @interface Sample {
		String value() default "";
		int intVal();
		Class<?>[] clazzVal();
	}
	
	public static class Foo {
		
	}
	
	@Sample(value="foo", intVal=1, clazzVal=Foo.class)
	public class Clazz {
		
		
		@Sample(value="bar", intVal=2, clazzVal = {})
		public String doStuff(@Sample(value="baz", intVal=3, clazzVal = {}) int x) {
			return "";
		}
	}
}
