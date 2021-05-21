package com.spacey.ps.dsa.tree;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.add(4);
		bst.add(2);
		bst.add(6);
		bst.add(10);
		bst.add(3);
		bst.add(7);
		bst.add(-1);
		bst.add(1);
		bst.add(5);
		bst.remove(-1);
		bst.remove(10);
		System.out.println("Tree traversal:-");
		testingInOrderIterator(bst);

		testingPreOrderIterator(bst);

		testingPostOrderIterator(bst);

		testingLevelOrderIterator(bst);

		System.out.println("\n\n\nDisplay traversed tree:-");
		System.out.println("InOrder traversed");
		System.out.println("w/o recursion:\t" + bst.inOrderTraversed());
		System.out.println("with recursion:\t" + bst.inOrderTraversedRecursively());

		System.out.println("PreOrder traversed");
		System.out.println("w/o recursion:\t" + bst.preOrderTraversed());
		System.out.println("with recursion:\t" + bst.preOrderTraversedRecursively());

		System.out.println("PostOrder traversed");
		System.out.println("w/o recursion:\t" + bst.postOrderTraversed());
		System.out.println("with recursion:\t" + bst.postOrderTraversedRecursively());

		System.out.println("LevelOrder traversed");
		System.out.println("w/o recursion:\t" + bst.levelOrderTraversed());
		System.out.println("with recursion:\t" + bst.levelOrderTraversedRecursively());

	}

	private static void testingLevelOrderIterator(BinarySearchTree<Integer> bst) {
		Iterator<Integer> levelOrderIterator = bst.iterator(TreeTraversalOrder.LEVEL_ORDER);

		while (levelOrderIterator.hasNext()) {
			System.out.print(levelOrderIterator.next() + " ");
		}
		System.out.println();
	}

	private static void testingPostOrderIterator(BinarySearchTree<Integer> bst) {
		Iterator<Integer> postOrderIterator = bst.iterator(TreeTraversalOrder.POST_ORDER);

		while (postOrderIterator.hasNext()) {
			System.out.print(postOrderIterator.next() + " ");
		}

		System.out.println();
	}

	private static void testingPreOrderIterator(BinarySearchTree<Integer> bst) {
		Iterator<Integer> preOrderIterator = bst.iterator(TreeTraversalOrder.PRE_ORDER);

		while (preOrderIterator.hasNext()) {
			System.out.print(preOrderIterator.next() + " ");
		}

		System.out.println();
	}

	private static void testingInOrderIterator(BinarySearchTree<Integer> bst) {
		Iterator<Integer> inOrderIterator = bst.iterator(TreeTraversalOrder.IN_ORDER);

		while (inOrderIterator.hasNext()) {
			System.out.print(inOrderIterator.next() + " ");
		}
		System.out.println();
	}

}
