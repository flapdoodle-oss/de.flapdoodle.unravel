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