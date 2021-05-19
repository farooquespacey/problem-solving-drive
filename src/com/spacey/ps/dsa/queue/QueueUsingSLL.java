package com.spacey.ps.dsa.queue;

public class QueueUsingSLL<T> {
	private Node<T> head;
	private Node<T> tail;

	private static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	public void enqueue(T element) {
		if (tail == null) {
			head = tail = new Node<T>(element, null);
		} else {
			Node<T> tmp = new Node<T>(element, null);
			tail.next = tmp;
			tail = tail.next;
		}
	}

	public T dequeue() {
		if (head == null)
			throw new RuntimeException("Queue empty");
		T headToRemove = head.data;
		Node<T> next = head.next;
		head = head.next = null;
		head = next;
		return headToRemove;
	}

	public T peek() {
		return head == null ? null : head.data;
	}

	public static void main(String[] args) {
		QueueUsingSLL<String> q1 = new QueueUsingSLL<String>();
		q1.enqueue("Farooque");
		q1.enqueue("Spacey");
		q1.enqueue("Spaceman");
		q1.dequeue();
		System.out.println(q1.peek());
	}

}
