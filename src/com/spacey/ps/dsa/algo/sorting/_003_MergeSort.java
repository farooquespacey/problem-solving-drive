package com.spacey.ps.dsa.algo.sorting;

import com.spacey.ps.dsa.Utils;

/**
 * 
 * Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides the
 * input array into two halves, calls itself for the two halves, and then merges
 * the two sorted halves. The merge() function is used for merging two halves.
 * The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and
 * arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. See the
 * following C implementation for details.
 * 
 * Time Complexity: O(n logn)
 * 
 * Auxiliary Space: O(n)
 * 
 * @author Spacey4uq
 */
public class _003_MergeSort {
	private static int[] mergeSort(int[] inp) {
		sort(inp, 0, inp.length - 1);
		return inp;
	}

	// Main function that sorts arr[l..r] using
	// merge()
	private static void sort(int[] a, int l, int r) {
		if (l < r) {
			int pi = l + ((r - l) / 2);

			sort(a, l, pi);
			sort(a, pi + 1, r);

			merge(a, l, pi, r);
		}
	}

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	private static void merge(int[] a, int l, int m, int r) {// assume l=0, m=3, r=7
		/* Find sizes of two subarrays to be merged */
		int n1 = (m - l) + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int[] L = new int[n1];
		int[] R = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = a[i + l];
		for (int j = 0; j < n2; ++j)
			R[j] = a[j + m + 1];

		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (L[i] > R[j]) {
				a[k] = R[j];
				j++;
			} else {
				a[k] = L[i];
				i++;
			}
			k++;
		}
		while (i < n1) {
			a[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			a[k] = R[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] inp = { 15, 45, 35, 25, 5 };
		Utils.printArray(mergeSort(inp));
	}

}
