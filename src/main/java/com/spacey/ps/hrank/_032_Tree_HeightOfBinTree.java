package com.spacey.ps.hrank;

import java.util.*;
import java.io.*;

class Tree_HeightOfBinTree {

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	/*
	 * class Node int data; Node left; Node right;
	 */
	public static int height(Node root) {
		// Write your code here.
		if(root == null) return 0;
		int lH = 0, rH = 0;
		if(root.left != null) lH = 1 + height(root.left);
		if(root.right != null) rH = 1 + height(root.right);
		return Math.max(lH, rH);
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		int height = height(root);
		System.out.println(height);
	}
}