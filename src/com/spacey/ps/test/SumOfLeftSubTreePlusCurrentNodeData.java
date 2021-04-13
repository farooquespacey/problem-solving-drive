package com.spacey.ps.test;

import java.util.Scanner;

/**
 * Poshmark powered by HackerRank
 * 
 * @author Night King
 *
 */
public class SumOfLeftSubTreePlusCurrentNodeData {
	Node root;

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

	// 1. Function to insert nodes in level order
	public static Node insertLevelOrder(int[] arr, Node root, int i) {
		// Base case for recursion
		if (i < arr.length) {
			Node temp = new Node(arr[i]);
			root = temp;
			// insert left child
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
			// insert right child
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
		}
		return root;
	}

	// 2A. DFS/postorder: Given a binary tree, print its nodes according to the "bottom-up"
	// postorder traversal.
	public static void printPostorder(Node node) {
		if (node == null)
			return;
		// first recur on left subtree
		printPostorder(node.left);
		// then recur on right subtree
		printPostorder(node.right);
		// now deal with the node
		System.out.print(node.data + " ");
	}

	// 2B. DFS/inorder: Given a binary tree, print its nodes in inorder
	public static void printInorder(Node node) {
		if (node == null)
			return;
		/* first recur on left child */
		printInorder(node.left);
		/* then print the data of node */
		System.out.print(node.data + " ");
		/* now recur on right child */
		printInorder(node.right);
	}

	// 2C. DFS/preorder: Given a binary tree, print its nodes in preorder
	public static void printPreorder(Node node) {
		if (node == null)
			return;
		/* first print data of node */
		System.out.print(node.data + " ");
		/* then recur on left sutree */
		printPreorder(node.left);
		/* now recur on right subtree */
		printPreorder(node.right);
	}

	// 3. Height of the tree
	public static int height(Node root) {
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

	// 4. BST: Lowest common ancestor
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

	// 5. BST: Is this a BinarySearchTree?
	public static boolean checkBST(Node root) {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean check(Node node, int min, int max) {
		if (node == null)
			return true;
		return min < node.data && node.data < max && check(node.left, min, node.data)
				&& check(node.right, node.data, max);
	}

	// 6. BFS traversal
	public static void BFS(Node root) {
		int height = height(root);
		for (int i = 1; i <= height+1; i++) {
			printGivenLevel(root, i);
		}
	}
	public static void printGivenLevel(Node root, int level) {
		if(root == null) return;
		if(level == 1) {
			System.out.print(root.data + " ");
		} else if(level > 1) {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	
	
	private static void ZigZag(Node root) {
		int height = height(root);
		for(int i=1; i<=height+1; i++) {
			printGivenLevelInZigZag(root, i);
		}
	}
	public static void printGivenLevelInZigZag(Node root, int level) {
		if(root == null) return;
		if(level == 1) {
			System.out.print(root.data + " ");
		} else if(level > 1) {
			if(level%2 == 0) {
				printGivenLevel(root.right, level-1);
				printGivenLevel(root.left, level-1);
			} else {
				printGivenLevel(root.left, level-1);
				printGivenLevel(root.right, level-1);
			}
		}
	}

	public static void main(String[] args) {
		String[] sa = null;
		try (Scanner sc = new Scanner(System.in)) {
//			while (sc.hasNextLine()) {
			sa = sc.nextLine().split(" ");
//			}
		}
		int arr[] = new int[sa.length];
		for (int i = 0; i < sa.length; i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}
		SumOfLeftSubTreePlusCurrentNodeData ins = new SumOfLeftSubTreePlusCurrentNodeData();
		ins.root = insertLevelOrder(arr, ins.root, 0);

		printInorder(ins.root);

		int height = height(ins.root);
		System.out.println("\nHeight of the tree: " + height);

		// Node lca = lca(ins.root, 4, 7);
		// Following works only for BST
		// System.out.println("Lowest common ancestor of BST: " + lca.data);

		System.out.println("Is the input tree a BST: " + checkBST(ins.root));
		
		System.out.print("BFS traversal: ");
		BFS(ins.root);
		
		
		System.out.print("\nZigZag traversal: ");
		ZigZag(ins.root);
	}


}
