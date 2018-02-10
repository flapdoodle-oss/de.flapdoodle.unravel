package de.flapdoodle.unravel.collections;

import java.util.function.BiFunction;

import com.google.common.base.Function;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;

public class SetCollector<K,V> {

	private final Function<V, K> keyOfValue;
	private final MapCollector<K,V> mapCollector;

	public SetCollector(Function<V, K> keyOfValue, BiFunction<V, V, V> valueMerge) {
		this.keyOfValue = keyOfValue;
		this.mapCollector = new MapCollector<>(valueMerge);
	}
	
	public SetCollector<K,V> add(V value) {
		K key = keyOfValue.apply(value);
		mapCollector.put(key, value);
		return this;
	}
	
	public Set<V> values() {
		return HashSet.ofAll(mapCollector.map().values());
	}
}
