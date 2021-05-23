package com.spacey.ps.dsa.list;

import com.spacey.ps.dsa.array.DynamicArray;

/**
 * Java program to implement a doubly linked list using array
 * 
 * @author Spacey4uq
 *
 */
class DoublyLinkedListUsingArray<T> {
	private int head = -1;
	private int tail = -1;

	DynamicArray<T> array = new DynamicArray<T>();

	public void clear() {
		array.clear();
		head = tail = -1;
	}

	public int size() {
		return array.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void add(T elem) {
		addLast(elem);
	}

	public void addLast(T elem) {
		array.add(elem);
		if (tail == -1) {
			head = tail = 0;
		} else {
			tail = array.size() - 1;
		}
	}

	public void addFirst(T elem) {
		if (isEmpty()) {
			head = tail = 0;
			array.add(elem);
		} else {
			array.set(head, elem);
		}
	}

	public T peekFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty list");
		return array.get(head);
	}

	public T peekLast() {
		if (isEmpty())
			throw new RuntimeException("Empty list");
		return array.get(tail);
	}

	public T removeFirst() {
		// Can't remove data from an empty list
		if (isEmpty())
			throw new RuntimeException("Empty list");

		T data = array.get(head);
		removeAt(head);

		if (isEmpty())
			tail = -1;

		return data;
	}

	public T removeLast() {
		// Can't remove data from an empty list
		if (isEmpty())
			throw new RuntimeException("Empty list");

		T data = array.get(tail);
		removeAt(tail);

		if (isEmpty())
			head = -1;

		return data;
	}

	public boolean remove(T node) {
		int pos = array.indexOf(node);

		if (pos > -1) {
			removeAt(pos);
			return true;
		}
		return false;
	}

	public T removeAt(int index) {
		if (index < 0 || index >= array.size()) {
			throw new IllegalArgumentException();
		}

		return array.removeAt(index);
	}

	public int indexOf(T obj) {
		return array.indexOf(obj);
	}

	// Check is a value is contained within the linked list
	public boolean contains(T obj) {
		return indexOf(obj) != -1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i = 0; i < size() - 1; i++) {
			sb.append(array.get(i) + ", ");
		}
		sb.append(array.get(size() - 1) + " ]");
		return sb.toString();
	}

	public static void main(String[] args) {
		DoublyLinkedListUsingArray<Integer> sList = new DoublyLinkedListUsingArray<>();

		// Add nodes to the list
		sList.add(1);
		sList.add(2);
		sList.add(3);
		sList.add(4);
		
		System.out.println(sList);
	}
}