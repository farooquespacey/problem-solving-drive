package com.spacey.ps.dsa.algo.sorting;

import com.spacey.ps.dsa.Utils;

/**
 * Insertion sort is a simple sorting algorithm that works similar to the way
 * you sort playing cards in your hands. The array is virtually split into a
 * sorted and an unsorted part. Values from the unsorted part are picked and
 * placed at the correct position in the sorted part. Algorithm To sort an array
 * of size n in ascending order:
 * 
 * 1: Iterate from arr[1] to arr[n] over the array.
 * 
 * 2: Compare the current element (key) to its predecessor.
 * 
 * 3: If the key element is smaller than its predecessor, compare it to the
 * elements before. Move the greater elements one position up to make space for
 * the swapped element.
 * 
 * Time Complexity: O(n^2)
 * 
 * Auxiliary Space: O(1)
 * 
 * @author Spacey4uq
 */
public class _002_InsertionSort {

	private static int[] selectionSort(int[] inp) {
		for (int i = 1; i < inp.length; i++) {
			int j = i - 1;
			int curr = inp[i];
			while (j >= 0 && curr < inp[j]) {
				inp[j + 1] = inp[j];
				j--;
			}
			inp[j + 1] = curr;
		}
		return inp;
	}

	public static void main(String[] args) {
		int[] inp = { 15, 45, 35, 25, 5 };
		Utils.printArray(selectionSort(inp));
	}

}
