package de.flapdoodle.unravel.collections;

import java.util.function.BiFunction;

import io.vavr.control.Option;

public class MergingCollector<T> {

	private final BiFunction<T, T, T> merge;
	Option<T> current=Option.none();
	
	public MergingCollector(BiFunction<T, T, T> merge) {
		this.merge = merge;
	}
	
	public MergingCollector<T> set(T value) {
		current = current.map(v -> merge.apply(v, value))
				.orElse(Option.of(value));
		return this;
	}
	
	public Option<T> get() {
		return current;
	}
}
