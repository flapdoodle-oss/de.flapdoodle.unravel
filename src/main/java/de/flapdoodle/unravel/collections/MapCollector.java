package de.flapdoodle.unravel.collections;

import java.util.function.BiFunction;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;

public class MapCollector<K,V> {

	private final BiFunction<V, V, V> valueMerge;
	Map<K, V> map=HashMap.empty();

	public MapCollector(BiFunction<V, V, V> valueMerge) {
		this.valueMerge = valueMerge;
	}
	
	public MapCollector<K,V> put(K key, V value) {
		map = map.put(key, map.get(key)
				.map(opt -> valueMerge.apply(opt, value))
				.getOrElse(value));
		return this;
	}
	
	public Map<K, V> map() {
		return map;
	}
}
