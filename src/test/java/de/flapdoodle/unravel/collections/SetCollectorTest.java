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
