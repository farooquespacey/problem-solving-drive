package com.spacey.ps.dsa.stack;

public class _02_StackUsingSLL<T> {
	
	Node<T> top;
	
	static class Node<T> {
		T data;
		Node<T> next;
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	public void push(T element) {
		if(top == null) {
			top = new Node<T>(element, null);
		} else {
			Node<T> tmp = new Node<T>(element, top);
			top = tmp;
		}
	}
	
	public T pop() {
		if(top == null) throw new RuntimeException("Stack is empty");
		T removedElement = top.data;
		top = top.next;
		return removedElement;
	}
	
	public T peek() {
		return top == null ? null : top.data;
	}
	
	public boolean isEmpty() {
		return top == null ? true : false;
	}
	
	public static void main(String[] args) {
		_02_StackUsingSLL<Integer> s1 = new _02_StackUsingSLL<Integer>();
		s1.push(1);
		s1.push(3);
		s1.pop();
		s1.pop();
		System.out.println(s1.isEmpty());
	}

}
