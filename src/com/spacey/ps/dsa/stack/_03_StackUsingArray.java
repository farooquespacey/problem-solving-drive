package com.spacey.ps.dsa.stack;

/* Java program to implement basic stack
operations */
@SuppressWarnings("unchecked")
class _03_StackUsingArray<T> {
	private int top;
	private T[] els; // Maximum size of Stack
	private int capacity;

	boolean isEmpty() {
		return (top < 0);
	}

	_03_StackUsingArray() {
		this(16);
	}

	_03_StackUsingArray(int cap) {
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
			throw new RuntimeException("Stack Overflow");
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
		_03_StackUsingArray<String> s = new _03_StackUsingArray<>();
		s.push("Farooque");
		s.push("Spacey");
		s.push("Spaceman");
		System.out.println(s.pop() + " Popped from stack");
	}
}