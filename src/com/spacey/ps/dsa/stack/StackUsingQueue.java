package com.spacey.ps.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of a Stack with a single Queue.
 * 
 * @author Spacey4uq
 *
 * @param <T>
 */
public class StackUsingQueue<T> {

	private Queue<T> q = new LinkedList<>();

	public boolean isEmpty() {
		return q.isEmpty();
	}

	public int size() {
		return q.size();
	}

	public void push(T element) {
		int prevSize = q.size();
		q.add(element);
		while (prevSize != 0) {
			T piggyBack = q.remove();
			q.add(piggyBack);
			prevSize--;
		}
	}

	public T pop() {
		return q.remove();
	}

	public T peek() {
		return q.peek();
	}

	public static void main(String[] args) {
		StackUsingQueue<Integer> s = new StackUsingQueue<>();
		s.push(10);
		s.push(20);
		System.out.println("Top element :" + s.peek());
		s.pop();
		s.push(30);
		s.pop();
		System.out.println("Top element :" + s.peek());
	}

}
