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
package de.flapdoodle.unravel.collections;

import java.util.function.BiFunction;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;

public class MapCollector<K, V> {

	private final BiFunction<V, V, V> valueMerge;
	Map<K, V> map = HashMap.empty();

	public MapCollector(BiFunction<V, V, V> valueMerge) {
		this.valueMerge = valueMerge;
	}

	public MapCollector<K, V> put(K key, V value) {
		map = map.put(key, map.get(key)
				.map(opt -> valueMerge.apply(opt, value))
				.getOrElse(value));
		return this;
	}

	public Map<K, V> map() {
		return map;
	}
}
