package com.spacey.ps.test;

public class _02_TreeTest {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
    public static int mapValues(Node node){
		if (node == null) {
			return 0;
		}
		if(node.left == null && node.right == null) {
			return node.data;
		}
		node.data += mapValues(node.left);
		return node.data + mapValues(node.right);
//		My own try:-		
//        if(node == null) {
//            return 0;
//        }
//        if(node.left != null){
//            node.data += mapValues(node.left);
//        }
//        if(node.right != null) {
//            return node.data + mapValues(node.right);
//        }
//        return node.data;
    }

	public static Node insertLevelOrder(int a[], Node root, int i) {
		if (i < a.length) {
			Node tmp = new Node(a[i]);
			root = tmp;
			root.left = insertLevelOrder(a, root.left, 2 * i + 1);
			root.right = insertLevelOrder(a, root.right, 2 * i + 2);
		}
		return root;
	}

	public static void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}

	private static void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	private static void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void BFS(Node root) {
		for (int i = 1; i <= height(root) + 1; i++) {
			printGivenLevel(root, i);
		}
	}

	private static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
		} else {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public static void ZigZag(Node root) {
		for (int i = 1; i <= height(root) + 1; i++) {
			printInZigZag(root, i);
		}
	}

	private static void printInZigZag(Node root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
		} else {
			if (level % 2 == 0) {
				printGivenLevel(root.right, level - 1);
				printGivenLevel(root.left, level - 1);
			} else {
				printGivenLevel(root.left, level - 1);
				printGivenLevel(root.right, level - 1);
			}

		}
	}

	public static int height(Node root) {
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

	private static boolean checkBST(Node root) {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
//		My own try(has a bug, try to figure that out):-		
//		if(root == null) {
//			return true;
//		} else {
//			boolean compare = true;
//			if(root.left != null) {
//				compare = compare && root.left.data < root.data; 
//			} 
//			if (root.right != null) {
//				compare = compare && root.data < root.right.data; 
//			}
//			compare = compare && checkBST(root.left) && checkBST(root.right);
//			return compare;
//		}
	}

	private static boolean check(Node root, int minValue, int maxValue) {
		if (root == null)
			return true;
		return minValue < root.data && root.data < maxValue && check(root.left, minValue, root.data)
				&& check(root.right, root.data, maxValue);
	}

	public static void main(String[] args) {
		Node root = null;
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
//		int[] array = { 10, 6, 18, 4, 8, 15, 21 };
		
		root = insertLevelOrder(array, root, 0);
//		System.out.println(root.data + ":" + root.left.data + ":" + root.right.data);

//		mapValues(root);
		inOrderTraversal(root);
		System.out.println();
		preOrderTraversal(root);
		System.out.println();
		postOrderTraversal(root);
		System.out.println();
//
		System.out.println("Height: " + height(root));
		System.out.print("BFS: ");
		BFS(root);
		System.out.println();
//
		System.out.print("ZigZag: ");
		ZigZag(root);
		System.out.println();
//
		System.out.println("Is BST? " + checkBST(root));
		
		mapValues(root);
		inOrderTraversal(root);
	}
	
	
	
}
