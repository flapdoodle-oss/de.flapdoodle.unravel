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
import io.vavr.Tuple2;

public class SetCollectorTest {
	
	@Test
	public void putOneThingIntoEmpty() {
		SetCollector<Character, Tuple2<Character, String>> collector = new SetCollector<Character, Tuple2<Character, String>>(s -> s._1(), (l,r) -> l.map2(v -> v+"|"+r._2()));
		collector.add(Tuple.of('a', "first"));
		assertThat(collector.values())
			.containsExactly(Tuple.of('a',"first"));
	}
	
	@Test
	public void putSecondWithSameKey() {
		SetCollector<Character, Tuple2<Character, String>> collector = new SetCollector<Character, Tuple2<Character, String>>(s -> s._1(), (l,r) -> l.map2(v -> v+"|"+r._2()));
		collector.add(Tuple.of('a', "first"));
		collector.add(Tuple.of('a', "second"));
		assertThat(collector.values())
			.containsExactly(Tuple.of('a',"first|second"));
	}

}
