package com.spacey.ps.dsa.stack;

/**
 * Java program to implement basic stack operations using doubly linked list
 * 
 * @author Spacey4uq
 *
 * @param <T> the type of elements held in this collection
 */
public class StackUsingDLL<T> implements Iterable<T> {

	// since doubly linked list is already defined by java, let's use that
	private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

	// Create an empty stack
	public StackUsingDLL() {
	}

	// Create a Stack with an initial element
	public StackUsingDLL(T firstElem) {
		push(firstElem);
	}

	// Return the number of elements in the stack
	public int size() {
		return list.size();
	}

	// Check if the stack is empty
	public boolean isEmpty() {
		return size() == 0;
	}

	// Push an element on the stack
	public void push(T elem) {
		list.addLast(elem);
	}

	// Pop an element off the stack
	// Throws an error is the stack is empty
	public T pop() {
		if (isEmpty())
			throw new java.util.EmptyStackException();
		return list.removeLast();
	}

	// Peek the top of the stack without removing an element
	// Throws an exception if the stack is empty
	public T peek() {
		if (isEmpty())
			throw new java.util.EmptyStackException();
		return list.peekLast();
	}

	// Allow users to iterate through the stack using an iterator
	@Override
	public java.util.Iterator<T> iterator() {
		return list.iterator();
	}
}