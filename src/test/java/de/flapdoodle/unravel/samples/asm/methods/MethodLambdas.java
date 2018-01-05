package de.flapdoodle.unravel.samples.asm.methods;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodLambdas {

	public String lambdas(List<Integer> list) {
		biFunc(MethodLambdas::biMapNoop,3d,133);
		func(MethodLambdas::mapNoop,2);
		
		return list.stream()
				.map(MethodLambdas::mapNoop)
				.map(s -> s)
				.filter(s -> s.length()>0)
				.filter(String::isEmpty)
				.filter(MethodLambdas::isEmpty)
				.findAny()
				.orElse(null);
	}
	
	private static <S,D> D func(Function<S, D> func, S source) {
		return func.apply(source);
	}
	
	private static <S1, S2 ,D> D biFunc(BiFunction<S1, S2, D> func, S1 source1, S2 source2) {
		return func.apply(source1, source2);
	}
	
	private static boolean isEmpty(String s) {
		return s.isEmpty();
	}
	
	private static String mapNoop(int s) {
		return ""+s;
	}
	
	private static String biMapNoop(double d, int s) {
		return ""+d+s;
	}
}
