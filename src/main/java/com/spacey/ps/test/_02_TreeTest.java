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

	public static int sumOfLeftSubtreePlusCurrNode(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		node.data += sumOfLeftSubtreePlusCurrNode(node.left);
		return node.data + sumOfLeftSubtreePlusCurrNode(node.right);
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

	public static Node insertLevelOrder(int src[], Node node, int i) {
		if (i < src.length) {
			Node tmp = new Node(src[i]);
			node = tmp;
			node.left = insertLevelOrder(src, node.left, 2 * i + 1);
			node.right = insertLevelOrder(src, node.right, 2 * i + 2);
		}
		return node;
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

	private static void printInZigZag(Node node, int height, boolean left) {
		if (node == null) return;
		if (height == 1) {
			System.out.print(node.data + " ");
			return;
		}
		if (left) {
			printInZigZag(node.left, height - 1, true);
			printInZigZag(node.right, height - 1, true);
		} else {
			printInZigZag(node.right, height - 1, false);
			printInZigZag(node.left, height - 1, false);
		}
	}

	private static void ZigZag(Node node) {
		boolean left = true;
		for (int i=1; i<=height2(node); i++) {
			printInZigZag(node, i, left);
			left = !left;
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

	private static int height2(Node node) {
		if (node == null)
			return 0;

		int lH = 1, rH = 1;
		if (node.left != null)
			lH += height2(node.left);
		if (node.right != null)
			rH += height2(node.right);
		return Math.max(lH, rH);
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

	private static boolean check(Node node, int minValue, int maxValue) {
		if (node == null)
			return true;
		return minValue < node.data && node.data < maxValue && check(node.left, minValue, node.data)
				&& check(node.right, node.data, maxValue);
	}

	public static Node lca(Node root, int v1, int v2) {
		// Decide if you have to call rekursively
		// Samller than both
		if (root.data < v1 && root.data < v2) {
			return lca(root.right, v1, v2);
		}
		// Bigger than both
		if (root.data > v1 && root.data > v2) {
			return lca(root.left, v1, v2);
		}
		// Else solution already found
		return root;
	}

	/* Returns true if binary tree with root as root is height-balanced */
	static boolean isBalanced(Node node) {
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = height(node.left);
		rh = height(node.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}
	
	static Node getMirrorOfBinaryTree(Node root) {
		swapChildren(root);
		return root;
	}

	private static void swapChildren(Node root) {
		if(root != null) {
			Node tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			swapChildren(root.left);
			swapChildren(root.right);
		}
	}
	
	static class MyInteger {
		int val;
		MyInteger(int val){
			this.val = val;
		}
		
		public void inc() {
			val++;
		}
	}

	static int countNumOfSubtreesWithinRange(Node node, int low, int hi) {
		MyInteger count = new MyInteger(0);
		countNumOfSubtreesWithinRange(node, low, hi, count);
		return count.val;
	}
	
	private static boolean countNumOfSubtreesWithinRange(Node node, int low, int hi, MyInteger count) {
		if(node == null) return true;
		boolean left = countNumOfSubtreesWithinRange(node.left, low, hi, count);
		boolean right = countNumOfSubtreesWithinRange(node.right, low, hi, count);
		if(left && right && inRange(node, low, hi)) {
			count.inc();
			return true;
		}
		return false;
	}
	
	static boolean inRange(Node node, int low, int high) {
        return node.data >= low && node.data <= high;
    }

	public static void main(String[] args) {
		Node root = null;
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		int[] array = { 10, 6, 18, 4, 8, 15, 21 };

		root = insertLevelOrder(array, root, 0);
		//	    	 1
		//     2 	     3
		//   4    5    6     7
		// 8   9

		inOrderTraversal(root);
		System.out.println();
		preOrderTraversal(root);
		System.out.println();
		postOrderTraversal(root);
		System.out.println();

		System.out.println("Height: " + height2(root));
		System.out.print("BFS: ");
		BFS(root);
		System.out.println();
		getMirrorOfBinaryTree(root);
		System.out.print("BFS after mirroring: ");
		BFS(root);
		System.out.println();

		System.out.print("ZigZag: ");
		ZigZag(root);
		System.out.println();

		System.out.println("Is BST? " + checkBST(root));

		sumOfLeftSubtreePlusCurrNode(root);
		BFS(root);

		System.out.println("\nIs Balanced Tree? " + isBalanced(root));
		
		array = new int[]{ 10, 8, 15, 7, 9, 13, 16 };
		root = insertLevelOrder(array, root, 0);
		System.out.println("Number of Subtrees within range: " + countNumOfSubtreesWithinRange(root, 7, 13));
	}
}
