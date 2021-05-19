package com.spacey.ps.dsa.stack;

/* Java program to implement basic stack
operations */
@SuppressWarnings("unchecked")
class StackUsingArray<T> {
	private int top;
	private int capacity;
	private T[] els; // Maximum size of Stack
	
	boolean isEmpty() {
		return (top < 0);
	}

	StackUsingArray() {
		this(16);
	}

	StackUsingArray(int cap) {
		top = -1;
		capacity = cap;
		els = (T[]) new Object[capacity];
	}

	boolean push(T x) {
		if (top >= (capacity - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			els[++top] = x;
			return true;
		}
	}

	T pop() {
		if (top < 0) {
			throw new RuntimeException("Stack Underflow");
		} else {
			T x = els[top--];
			return x;
		}
	}

	T peek() {
		if (top < 0) {
			throw new RuntimeException("Stack Overflow");
		} else {
			T x = els[top];
			return x;
		}
	}
}

// Driver code
class Main {
	public static void main(String args[]) {
		StackUsingArray<String> s = new StackUsingArray<>();
		s.push("Farooque");
		s.push("Spacey");
		s.push("Spaceman");
		System.out.println(s.pop() + " Popped from stack");
	}
}