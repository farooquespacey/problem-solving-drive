package com.spacey.ps.dsa.queue;

import java.util.Stack;

/**
 * Implementation of a Queue with two Stacks.
 * 
 * @author Spacey4uq
 *
 * @param <T>
 */
public class QueueUsingTwoStack<T> {

	private Stack<T> primaryStack = new Stack<>();
	private Stack<T> tempStack = new Stack<>();

	public boolean isEmpty() {
		return primaryStack.isEmpty();
	}

	public int size() {
		return primaryStack.size();
	}

	public void add(T element) {
		while (!isEmpty()) {
			tempStack.push(primaryStack.pop());
		}
		primaryStack.push(element);
		while (!tempStack.isEmpty()) {
			primaryStack.push(tempStack.pop());
		}
	}

	public T remove() {
		return primaryStack.pop();
	}

	public T peek() {
		return primaryStack.peek();
	}

	public static void main(String[] args) {
		QueueUsingTwoStack<Integer> s = new QueueUsingTwoStack<>();
		s.add(10);
		s.add(20);
		System.out.println("Front element :" + s.peek());
		s.remove();
		s.add(30);
		s.remove();
		System.out.println("Front element :" + s.peek());
	}

}
