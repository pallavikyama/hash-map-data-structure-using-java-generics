package com.blz.hashmap;

import java.util.ArrayList;

import com.blz.datastructures.MyLinkedList;
import com.blz.datastructures.NodeInterface;

public class MyLinkedHashMap<K, V> {
	private final int NUM_OF_BUCKETS;
	ArrayList<MyLinkedList<K>> myBucketArray;

	public MyLinkedHashMap() {
		this.NUM_OF_BUCKETS = 10;
		this.myBucketArray = new ArrayList<>(NUM_OF_BUCKETS);
		for (int i = 0; i < NUM_OF_BUCKETS; i++)
			this.myBucketArray.add(null);
	}

	// USING A HASH-FUNCTION TO FIND INDEX FOR A KEY
	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % NUM_OF_BUCKETS;
		return index;
	}

	// GET VALUE OF THE SPECIFIED KEY
	@SuppressWarnings("unchecked")
	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null)
			return null;
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	// ADD NEW KEY AND VALUE TO THE HASH-MAP(OR)REPLACE EXISTING ONES WITH NEW ONES
	@SuppressWarnings("unchecked")
	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			this.myBucketArray.set(index, myLinkedList);
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			myLinkedList.append(myMapNode);
		} else
			myMapNode.setValue(value);
	}

	// REMOVE MAP-NODE OF THE GIVEN KEY
	@SuppressWarnings("unchecked")
	public void remove(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode != null) {
			NodeInterface<K> tempMapNode = myLinkedList.getHead();
			while (tempMapNode.getNext() != myMapNode) {
				tempMapNode = tempMapNode.getNext();
			}
			tempMapNode.setNext(myMapNode.getNext());
		}
	}

	@Override
	public String toString() {
		return "MyLinkedHashMap List {" + myBucketArray + "} ";
	}
}