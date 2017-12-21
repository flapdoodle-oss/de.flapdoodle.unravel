package de.flapdoodle.unravel.samples.asm.basics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotations {

	@Retention(RetentionPolicy.RUNTIME)
	public @interface Samples {
		Sample[] value();
	}
	
	@Repeatable(Samples.class)
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
	public @interface Simple {
	}
	
	public static class Foo {
		static final String FOO = "foo";
		
	}
	
	@Sample(value=ConstRef.STRING, intVal=1, clazzVal=Foo.class)
	@Sample(value="bar", intVal=2, clazzVal={})
	public class Clazz {

		@Sample(value="bar", intVal=2, clazzVal = {})
		public String doStuff(@Sample(value="baz", intVal=3, clazzVal = {}) int x) {
			return "";
		}
	}
}
