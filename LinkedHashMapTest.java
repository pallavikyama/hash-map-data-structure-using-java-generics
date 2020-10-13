package com.blz.hashmap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedHashMapTest {

	// GIVEN A PARAGRAPH/PHRASE SHOULD RETURN THE SPECIFIED WORD'S FREQUENCY
	@Test
	public void linkedHashMapTestUC2() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value += 1;
			myLinkedHashMap.add(word, value);
		}
		System.out.println(myLinkedHashMap);
		int frequency = myLinkedHashMap.get("paranoid");
		assertEquals(3, frequency);
	}

	// GIVEN A PARAGRAPH/PHRASE AND A WORD SHOULD REMOVE THE SPECIFIED WORD'S NODE
	@Test
	public void linkedHashMapTestUC3() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value += 1;
			myLinkedHashMap.add(word, value);
		}
		System.out.println(myLinkedHashMap);
		myLinkedHashMap.remove("avoidable");
		assertTrue(myLinkedHashMap.get("avoidable") == null);
		System.out.println("After removing 'avoidable': " + myLinkedHashMap);
	}
}