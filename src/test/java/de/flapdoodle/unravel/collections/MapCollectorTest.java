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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import io.vavr.Tuple;

public class MapCollectorTest {

	@Test
	public void putOneThingIntoEmpty() {
		MapCollector<String, String> collector = new MapCollector<String, String>((l,r) -> l+"|"+r);
		collector.put("a", "first");
		assertThat(collector.map())
			.containsExactly(Tuple.of("a","first"));
	}
	
	@Test
	public void putSecondWithSameKey() {
		MapCollector<String, String> collector = new MapCollector<String, String>((l,r) -> l+"|"+r);
		collector.put("a", "first");
		collector.put("a", "second");
		assertThat(collector.map())
			.containsExactly(Tuple.of("a","first|second"));
	}
}