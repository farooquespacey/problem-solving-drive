package com.spacey.ps.dsa.list;

/**
 * Java program to implement a singly linked list
 * 
 * @author Spacey4uq
 *
 */
class SinglyLinkedList<T> {
	// Represent the head and tail of the singly linked list
	private Node<T> head;
	private Node<T> tail;

	// Represent a node of the singly linked list
	private static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	// addNode() will add a new node to the list
	public void addNode(T data) {
		// Create a new node
		Node<T> newNode = new Node<T>(data, null);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	// display() will display all the nodes present in the list
	public void display() {
		// Node current will point to head
		Node<T> current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of singly linked list: ");
		while (current != null) {
			// Prints each node by incrementing pointer
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();

		// Add nodes to the list
		sList.addNode(1);
		sList.addNode(2);
		sList.addNode(3);
		sList.addNode(4);

		// Displays the nodes present in the list
		sList.display();
	}
}