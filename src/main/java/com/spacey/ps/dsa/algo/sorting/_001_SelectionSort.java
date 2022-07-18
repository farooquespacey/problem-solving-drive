package com.spacey.ps.dsa.algo.sorting;

import com.spacey.ps.dsa.Utils;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum
 * element (considering ascending order) from unsorted part and putting it at
 * the beginning. The algorithm maintains two subarrays in a given array.
 * 
 * 1) The subarray which is already sorted.
 * 
 * 2) Remaining subarray which is unsorted.
 * 
 * In every iteration of selection sort, the minimum element (considering
 * ascending order) from the unsorted subarray is picked and moved to the sorted
 * subarray.
 * 
 * Time Complexity: O(n^2) as there are two nested loops.
 * 
 * Auxiliary Space: O(1)
 * 
 * @author Spacey4uq
 */
public class _001_SelectionSort {

	static int[] selectionSort(int[] inp) {
		for (int i = 0; i < inp.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < inp.length; j++) {
				min = inp[j] < inp[min] ? j : min;
			}
			int tmp = inp[min];
			inp[min] = inp[i];
			inp[i] = tmp;
		}
		return inp;
	}

	public static void main(String[] args) {
		int[] inp = { 15, 45, 35, 25, 5 };
		Utils.printArray(selectionSort(inp));
	}

}
