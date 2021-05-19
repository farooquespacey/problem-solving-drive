package com.spacey.ps.dsa.queue;

import java.util.Arrays;

/**
 * Java program to implement basic queue operations using an array
 * 
 * @author Spacey4uq
 *
 * @param <T> the type of elements held in this collection
 */
@SuppressWarnings("unchecked")
class QueueUsingArray<T> {
	private int rear;
	private int capacity;
	private T[] els; // Maximum size of Stack

	boolean isEmpty() {
		return (rear < 0);
	}

	QueueUsingArray() {
		this(16);
	}

	QueueUsingArray(int cap) {
		rear = -1;
		capacity = cap;
		els = (T[]) new Object[capacity];
	}

	boolean enqueue(T x) {
		if (rear >= (capacity - 1)) {
			System.out.println("Queue Overflow");
			return false;
		} else {
			els[++rear] = x;
			return true;
		}
	}

	T dequeue() {
		if (rear < 0) {
			throw new RuntimeException("Queue Underflow");
		} else {
			T x = els[0];
			els = Arrays.copyOfRange(els, 1, capacity);
			rear--;
			return x;
		}
	}

	T peek() {
		return (rear < 0) ? null : els[0];
	}
}

// Driver code
class Main {
	public static void main(String args[]) {
		QueueUsingArray<String> q = new QueueUsingArray<>(4);
		q.enqueue("Farooque");
		q.enqueue("Spacey");
		q.enqueue("Spaceman");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue("Farooque");
		q.enqueue("Spacey");
		q.enqueue("Spaceman");
		System.out.println(q.peek());
	}
}