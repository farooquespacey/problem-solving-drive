package com.spacey.ps.test;

public class TreeTesting {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int d) {
			data = d;
		}
	}

	public static Node insertLevelOrder(int[] input, Node root, int idx) {
		if (idx < input.length) {
			root = new Node(input[idx]);
			root.left = insertLevelOrder(input, root.left, idx * 2 + 1);
			root.right = insertLevelOrder(input, root.right, idx * 2 + 2);
		}
		return root;
	}

	public static void printInOrder(Node root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.print(root.data + " ");
			printInOrder(root.right);
		}
	}

	public static void printPreOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	public static void printPostOrder(Node root) {
		if (root != null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	private static int height(Node root) {
		if (root == null) {
			return 0;
		}
		int lHeight = 0, rHeight = 0;
		if (root.left != null) {
			lHeight = 1 + height(root.left);
		}
		if (root.right != null) {
			rHeight = 1 + height(root.right);
		}
		return Integer.max(lHeight, rHeight);
	}

	public static void BFS(Node root) {
		for (int level = 1; level <= height(root) + 1; level++) {
			printLevelOrder(root, level);
		}
	}

	private static void printLevelOrder(Node root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
		} else {
			printLevelOrder(root.left, level - 1);
			printLevelOrder(root.right, level - 1);
		}
	}

	public static void ZigZag(Node root) {
		for (int level = 1; level <= height(root) + 1; level++) {
			ZigZagTraversal(root, level);
		}
	}

	private static void ZigZagTraversal(Node root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
		} else {
			if (level % 2 == 0) {
				printLevelOrder(root.right, level - 1);
				printLevelOrder(root.left, level - 1);
			} else {
				printLevelOrder(root.left, level - 1);
				printLevelOrder(root.right, level - 1);
			}
		}
	}

	public static boolean isBST(Node root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean checkBST(Node root, int min, int max) {
		if (root == null)
			return true;
		return min < root.data && root.data < max && checkBST(root.left, min, root.data)
				&& checkBST(root.right, root.data, max);
	}
	
    static int findMinDays(int n, int m) {
    	int doubling = 0;
    	int reductionDoubling=0;
        if(n==m){
            return 0;
        }
        if(n>m){
            return n-m;
        } else if(m/2== n){
            return 1;
        } else if (m/2 > n) {
        	doubling = 1 + findMinDays(n*2, m);
        } else{
            reductionDoubling = 1 + findMinDays(n-1, m);
        }
        return Math.max(doubling, reductionDoubling);
    }


	public static void main(String[] args) {
//		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		Node root = null;
//		root = insertLevelOrder(input, root, 0);
//		printInOrder(root);
//		System.out.println();
//		printPreOrder(root);
//		System.out.println();
//		printPostOrder(root);
//		System.out.println();
//		System.out.println("Height: " + height(root));
//		BFS(root);
//		System.out.println();
//		ZigZag(root);
//		System.out.println("\nIs BST? " + isBST(root));
		
		System.out.println(findMinDays(6, 14));
	}

}
