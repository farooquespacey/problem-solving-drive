package com.spacey.ps.dsa.queue;

import java.util.Stack;

/**
 * Implementation of a Queue with single Stack. This is recursive and thus very
 * inefficient but the only way to achieve the solution.
 * 
 * @author Spacey4uq
 *
 * @param <T>
 */
public class QueueUsingStack<T> {

	private Stack<T> stack = new Stack<>();

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int size() {
		return stack.size();
	}

	public void add(T element) {
		if (stack.isEmpty())
			stack.push(element);
		else {
			T piggyBack = stack.pop();
			add(element);
			stack.push(piggyBack);
		}
	}

	public T remove() {
		return stack.pop();
	}

	public T peek() {
		return stack.peek();
	}

	public static void main(String[] args) {
		QueueUsingStack<Integer> s = new QueueUsingStack<>();
		s.add(10);
		s.add(20);
		System.out.println("Front element :" + s.peek());
		s.remove();
		s.add(30);
		s.remove();
		System.out.println("Front element :" + s.peek());
	}

}
