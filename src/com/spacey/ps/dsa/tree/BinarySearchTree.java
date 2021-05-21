package com.spacey.ps.dsa.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {

	Node<T> root;
	int nodeCount = 0;

	static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}

	public boolean contains(T element) {
		return contains(root, element);
	}

	private boolean contains(Node<T> node, T element) {
		if (node == null)
			return false;
		int compared = node.data.compareTo(element);
		if (compared == 0)
			return true;
		else if (compared < 0)
			return contains(node.right, element);
		else
			return contains(node.left, element);
	}

	public boolean add(T element) {
		if (contains(element)) {
			return false;
		} else {
			root = add(root, element);
			nodeCount++;
			return true;
		}
	}

	private Node<T> add(Node<T> node, T element) {
		if (node == null)
			node = new Node<T>(element, null, null);
		else if (node.data.compareTo(element) < 0)
			node.right = add(node.right, element);
		else
			node.left = add(node.left, element);
		return node;
	}

	public boolean remove(T element) {
		if (contains(element)) {
			root = remove(root, element);
			nodeCount++;
			return true;
		}
		return false;
	}

	private Node<T> remove(Node<T> node, T element) {
		int compared = node.data.compareTo(element);
		if (compared < 0) {
			node.right = remove(node.right, element);
		} else if (compared > 0) {
			node.left = remove(node.left, element);
		} else {
			if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			} else {
				Node<T> minNode = findMinNode(node.right);
				node.data = minNode.data;
				node.right = remove(node.right, minNode.data);
			}
		}
		return node;
	}

	private Node<T> findMinNode(Node<T> node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

	public Iterator<T> iterator(TreeTraversalOrder order) {
		switch (order) {
		case IN_ORDER:
			return inOrderTraversal();
		case PRE_ORDER:
			return preOrderTraversal();
		case POST_ORDER:
			return postOrderTraversal();
		case LEVEL_ORDER:
			return levelOrderTraversal();
		default:
			return null;
		}
	}

	// BFS
	private Iterator<T> levelOrderTraversal() {
		System.out.println("Level Order Traversal");
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);

		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				return root != null && !queue.isEmpty();
			}

			@Override
			public T next() {
				Node<T> node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				return node.data;
			}

		};
	}

	// left, right , root
	private Iterator<T> postOrderTraversal() {
		System.out.println("PostOrder Traversal");
		Stack<Node<T>> stack1 = new Stack<>();
		Stack<Node<T>> stack2 = new Stack<>();

		stack1.push(root);

		while (!stack1.empty()) {
			Node<T> node = stack1.pop();
			if (node != null) {
				stack2.push(node);
				if (node.left != null)
					stack1.push(node.left);
				if (node.right != null)
					stack1.push(node.right);
			}
		}

		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return root != null && !stack2.isEmpty();
			}

			@Override
			public T next() {
				return stack2.pop().data;
			}
		};
	}

	// root, left, right
	private Iterator<T> preOrderTraversal() {
		System.out.println("PreOrder Traversal");
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);

		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				return root != null && !stack.isEmpty();
			}

			@Override
			public T next() {
				Node<T> node = stack.pop();

				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
				return node.data;
			}
		};
	}

	// left, root, right
	private Iterator<T> inOrderTraversal() {
		System.out.println("InOrder Traversal");
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);

		return new Iterator<T>() {
			Node<T> trav = root;

			@Override
			public boolean hasNext() {
				return root != null && !stack.isEmpty();
			}

			@Override
			public T next() {
				while (trav != null && trav.left != null) {
					stack.push(trav.left);
					trav = trav.left;
				}

				Node<T> node = stack.pop();

				if (node.right != null) {
					stack.push(node.right);
					trav = node.right;
				}
				return node.data;
			}
		};
	}

	public static <T> List<T> inOrderTraversed(Node<T> root) {
		List<T> result = new LinkedList<T>();
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);

		Node<T> trav = root;

		while (root != null && !stack.isEmpty()) {
			while (trav != null && trav.left != null) {
				trav = trav.left;
				stack.push(trav);
			}

			Node<T> node = stack.pop();
			if (node.right != null) {
				trav = node.right;
				stack.push(node.right);
			}
			result.add(node.data);
		}
		return result;
	}

	public static <T> List<T> inOrderTraversedRecursively(Node<T> root) {
		List<T> result = new LinkedList<>();
		inOrderTraversedRecursively(root, result);
		return result;
	}

	private static <T> void inOrderTraversedRecursively(Node<T> root, List<T> list) {
		if (root != null) {
			inOrderTraversedRecursively(root.left, list);
			list.add(root.data);
			inOrderTraversedRecursively(root.right, list);
		}
	}

	public static <T> List<T> preOrderTraversed(Node<T> root) {
		List<T> result = new LinkedList<>();
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);

		while (root != null && !stack.isEmpty()) {
			Node<T> node = stack.pop();

			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
			result.add(node.data);
		}
		return result;
	}

	public static <T> List<T> preOrderTraversedRecursively(Node<T> root) {
		List<T> result = new LinkedList<>();
		preOrderTraversedRecursively(root, result);
		return result;
	}

	private static <T> void preOrderTraversedRecursively(Node<T> root, List<T> list) {
		if (root != null) {
			list.add(root.data);
			preOrderTraversedRecursively(root.left, list);
			preOrderTraversedRecursively(root.right, list);
		}
	}

	public static <T> List<T> postOrderTraversed(Node<T> root) {
		List<T> result = new LinkedList<>();
		Stack<Node<T>> stack1 = new Stack<>();
		Stack<Node<T>> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			Node<T> node = stack1.pop();
			if (node != null) {
				stack2.push(node);
				if (node.left != null)
					stack1.push(node.left);
				if (node.right != null)
					stack1.push(node.right);
			}
		}
		while (root != null && !stack2.isEmpty())
			result.add(stack2.pop().data);
		return result;
	}

	public static <T> List<T> postOrderTraversedRecursively(Node<T> root) {
		List<T> result = new LinkedList<>();
		postOrderTraversedRecursively(root, result);
		return result;
	}

	private static <T> void postOrderTraversedRecursively(Node<T> root, List<T> list) {
		if (root != null) {
			postOrderTraversedRecursively(root.left, list);
			postOrderTraversedRecursively(root.right, list);
			list.add(root.data);
		}
	}

	public static <T> List<T> levelOrderTraversed(Node<T> root) {
		List<T> result = new LinkedList<>();
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);

		while (root != null && !queue.isEmpty()) {
			Node<T> node = queue.poll();
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			result.add(node.data);
		}
		return result;
	}

	public static <T> List<T> levelOrderTraversedRecursively(Node<T> root) {
		List<T> result = new LinkedList<>();
		levelOrderTraversedRecursively(root, result);
		return result;
	}

	private static <T> int height(Node<T> root) {
		if (root == null)
			return 0;
		int leftHeight = 0;
		int rightHeight = 0;

		if (root.left != null) {
			leftHeight = 1 + height(root.left);
		}
		if (root.right != null) {
			rightHeight = 1 + height(root.right);
		}
		return Math.max(leftHeight, rightHeight);
	}

	private static <T> void levelOrderTraversedRecursively(Node<T> root, List<T> list) {
		int levels = height(root) + 1;
		for (int i = 1; i <= levels; i++) {
			levelOrderTraversedRecursively(root, list, i);
		}
	}

	private static <T> void levelOrderTraversedRecursively(Node<T> root, List<T> list, int level) {
		if (root == null)
			return;
		if (level == 1) {
			list.add(root.data);
		} else {
			levelOrderTraversedRecursively(root.left, list, level - 1);
			levelOrderTraversedRecursively(root.right, list, level - 1);
		}
	}

}
