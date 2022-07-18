package com.spacey.ps.dsa.tree;

public class AVLTree<T extends Comparable<T>> {

	Node<T> root;
	int nodeCount = 0;

	static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;
		int height;
		int balancedFactor;

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node(T data, Node<T> left, Node<T> right, int height, int balancedFactor) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.height = height;
			this.balancedFactor = balancedFactor;
		}
	}

	public boolean contains(T element) {
		return contains(root, element);
	}

	public boolean contains(Node<T> node, T element) {
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
		if (contains(element))
			return false;
		else {
			root = add(root, element);
			nodeCount++;
			return true;
		}
	}

	private Node<T> add(Node<T> node, T element) {
		if (node == null)
			return new Node<>(element, null, null, 0, 0);
		if (node.data.compareTo(element) < 0) {
			node.right = add(node.right, element);
		} else {
			node.left = add(node.left, element);
		}
		// Update balance factor and height values.
		update(node);
		// Re-balance tree.
		return balanced(node);
	}

	public boolean remove(T element) {
		if (contains(element)) {
			root = remove(root, element);
			nodeCount--;
			return true;
		}
		return false;
	}

	private Node<T> remove(Node<T> node, T element) {
		if (node == null)
			return null;
		int compared = node.data.compareTo(element);
		if (compared < 0) {
			node.right = remove(node.right, element);
		} else if (compared > 0) {
			node.left = remove(node.left, element);
		} else {
			if (node.left == null) {
				// direct return without update()/balanced() call because:
				// case 1: "node.right is also null" -> then nothing changes in the height/bf
				// plus if you call it anyway you have to especially handle nulls in both
				// update() and balanced() method which would become an additional step.
				// case 2: "node.right is a subtree" -> since we made no changes in node.right
				// structure, calling update(node.right)/balanced(node.right) would not change a
				// thing.
				return node.right;
			} else if (node.right == null) {
				// direct return without update()/balanced() -- same reason as above
				return node.left;
			} else {
				// if both the child are present
				Node<T> rightMinNode = findMinNode(node.right);
				node.data = rightMinNode.data;
				node.right = remove(node.right, rightMinNode.data);
			}
		}
		update(node);
		return balanced(node);
	}

	private void update(Node<T> node) {
		int lH = -1;
		int rH = -1;
		if (node.left != null)
			lH = node.left.height;
		if (node.right != null)
			rH = node.right.height;
		node.height = 1 + Math.max(lH, rH);
		node.balancedFactor = rH - lH;
	}

	public int height(Node<T> node) {
		if (node == null)
			return 0;
		return node.height;
	}

	// Re-balance a node if its balance factor is +2 or -2.
	private Node<T> balanced(Node<T> node) {
		// left heavy subtree
		if (node.balancedFactor == -2) {
			// <=0 because there is a possibility of left child having both the children.
			if (node.left.balancedFactor <= 0) {
				return leftLeftCase(node);
			} else {
				return leftRightCase(node);
			}
		}
		// right heavy subtree
		else if (node.balancedFactor == 2) {
			// >=0 because there is a possibility of right child having both the children.
			if (node.right.balancedFactor >= 0) {
				return rightRightCase(node);
			} else {
				return rightLeftCase(node);
			}
		}

		// node has balance factor of -1, 0 or +1
		// which we do not need to balance.
		return node;
	}

	private Node<T> leftLeftCase(Node<T> node) {
		return rightRotation(node);
	}

	private Node<T> leftRightCase(Node<T> node) {
		node.left = leftRotation(node.left);
		return rightRotation(node);
	}

	private Node<T> rightRightCase(Node<T> node) {
		return leftRotation(node);
	}

	private Node<T> rightLeftCase(Node<T> node) {
		node.right = rightRotation(node.right);
		return leftRotation(node);
	}

	private Node<T> rightRotation(Node<T> node) {
		Node<T> nodeLeft = node.left;
		node.left = nodeLeft.right;
		nodeLeft.right = node;
		update(node);
		update(nodeLeft);
		return nodeLeft;
	}

	private Node<T> leftRotation(Node<T> node) {
		Node<T> nodeRight = node.right;
		node.right = nodeRight.left;
		nodeRight.left = node;
		update(node);
		update(nodeRight);
		return nodeRight;
	}

	private Node<T> findMinNode(Node<T> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		AVLTree<Integer> avlTree = new AVLTree<>();
		avlTree.add(1);
		avlTree.add(2);
		avlTree.add(3);
		avlTree.add(4);
		avlTree.add(5);
		avlTree.add(6);
		avlTree.add(7);
		avlTree.remove(6);
		avlTree.remove(5);
		avlTree.remove(7);
		System.out.println(avlTree.root.data);
	}

}
