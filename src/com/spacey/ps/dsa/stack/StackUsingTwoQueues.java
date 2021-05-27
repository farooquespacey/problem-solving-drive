package com.spacey.ps.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of a Stack with two Queues.
 * 
 * @author Spacey4uq
 *
 * @param <T>
 */
public class StackUsingTwoQueues<T> {

	private Queue<T> primaryQ = new LinkedList<>();
	private Queue<T> tempQ = new LinkedList<>();

	public boolean isEmpty() {
		return primaryQ.isEmpty();
	}

	public int size() {
		return primaryQ.size();
	}

	public void push(T element) {
		tempQ.add(element);
		while (!isEmpty()) {
			tempQ.add(primaryQ.remove());
		}
		Queue<T> q = primaryQ;
		primaryQ = tempQ;
		tempQ = q;
	}

	public T pop() {
		return primaryQ.remove();
	}

	public T peek() {
		return primaryQ.peek();
	}

	public static void main(String[] args) {
		StackUsingTwoQueues<Integer> s = new StackUsingTwoQueues<>();
		s.push(10);
		s.push(20);
		System.out.println("Top element :" + s.peek());
		s.pop();
		s.push(30);
		s.pop();
		System.out.println("Top element :" + s.peek());
	}

}
