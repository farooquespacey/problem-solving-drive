package com.spacey.ps.dsa.algo.searching;

/**
 * A simple approach is to do a linear search, i.e
 * 
 * Start from the leftmost element of arr[] and one by one compare x with each
 * element of arr[]
 * 
 * If x matches with an element, return the index.
 * 
 * If x doesn’t match with any of elements, return -1
 * 
 * Time complexity: O(n)
 * 
 * @author Spacey4uq
 *
 */
public class LinearSearch {

	private static boolean linearSearch(int[] arr, int elementToSearch) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == elementToSearch)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, 40, 30 };
		System.out.println(linearSearch(arr, 40));
	}

}
