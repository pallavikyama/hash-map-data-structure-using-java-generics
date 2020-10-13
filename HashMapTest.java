package com.blz.hashmap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HashMapTest {

	@Test
	public void hashMapTestUC1() {
		String sentence = "To be or not to be";
		MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value += 1;
			myHashMap.add(word, value);
		}
		int frequency = myHashMap.get("to");
		System.out.println(myHashMap);
		assertEquals(2, frequency);
	}
}