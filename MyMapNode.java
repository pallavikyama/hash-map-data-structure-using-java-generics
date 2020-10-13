package com.blz.hashmap;

import com.blz.datastructures.NodeInterface;

public class MyMapNode<K, V> implements NodeInterface<K> {
	K key;
	V value;
	MyMapNode<K, V> next;

	MyMapNode(K key, V value) {
		this.key = key;
		this.value = value;
		next = null;
	}

	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return this.value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public NodeInterface<K> getNext() {
		return (MyMapNode<K, V>) next;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setNext(NodeInterface<K> next) {
		this.next = (MyMapNode<K, V>) next;
	}

	@Override
	public String toString() {
		StringBuilder myMapNodeString = new StringBuilder();
		myMapNodeString.append("MyMapNode{K=").append(key).append(" V=").append(value).append("}");
		if (next != null)
			myMapNodeString.append(" -> ").append(next);
		return myMapNodeString.toString();
	}
}