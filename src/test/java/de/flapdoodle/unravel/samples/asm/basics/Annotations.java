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
	
	public enum SampleEnum {
		A,B,C
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Parameters {
		String string() default "defaultString";
		String[] stringArray() default {"a","b"};
		
		int integer();
		long[] integerArray();
		
		SampleEnum sample();
		SampleEnum[] sampleArray();
		
		Class<?> clazz();
		Class<?>[] clazzArray();
		
		WrappedWrapped wrapped();
		WrappedWrapped[] wrappedArray();
	}
	
	@Parameters(
			integer=2,
			integerArray={1,2,3},
			sample=SampleEnum.B,
			sampleArray={SampleEnum.A,SampleEnum.C},
			clazz=WrapperSample.class,
			clazzArray={Wrapper.class, Wrapped.class},
			wrapped=@WrappedWrapped("X"),
			wrappedArray={@WrappedWrapped("Y"),@WrappedWrapped("Z")})
	public static class ParameterSample {
		
	}
}
