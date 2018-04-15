/**
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
