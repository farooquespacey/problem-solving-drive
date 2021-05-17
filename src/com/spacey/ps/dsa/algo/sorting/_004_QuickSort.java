package com.spacey.ps.dsa.algo.sorting;

import com.spacey.ps.dsa.Utils;

/**
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an
 * element as pivot and partitions the given array around the picked pivot.
 * There are many different versions of quickSort that pick pivot in different
 * ways.
 * 
 * 1) Always pick first element as pivot.
 * 
 * 2) Always pick last element as pivot (implemented below)
 * 
 * 3) Pick a random element as pivot.
 * 
 * 4) Pick median as pivot.
 * 
 * Time Complexity: O(n^2)
 * 
 * Auxiliary Space: O(1)
 * 
 * @author Spacey4uq
 *
 */
public class _004_QuickSort {

	private static int[] quickSort(int[] inp) {
		sort(inp, 0, inp.length - 1);
		return inp;
	}

	private static void sort(int[] a, int l, int r) {
		if (l < r) {
			int pi = partition(a, l, r);

			sort(a, l, pi - 1);
			sort(a, pi + 1, r);
		}
	}

	/**
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 * 
	 * 
	 * @param a - inp array
	 * @param l - left idx
	 * @param r - right idx
	 * @return the correct position of the pivot for the range l..r
	 */
	private static int partition(int[] a, int l, int r) {
		// taken last element as pivot
		int pivot = a[r];

		// keep track of the number of elements lower than the pivot
		// help insert the pivot after this index
		int i = l - 1;

		for (int j = l; j <= r - 1; j++) {
			if (a[j] < pivot) {
				i++;
				// swap to make sure i tracks smaller element
				swap(a, i, j);
			}
		}

		swap(a, i + 1, r);
		return i + 1;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int[] inp = { 15, 45, 35, 25, 5 };
		Utils.printArray(quickSort(inp));
	}

}
