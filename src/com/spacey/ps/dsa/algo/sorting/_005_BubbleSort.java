package com.spacey.ps.dsa.algo.sorting;

import com.spacey.ps.dsa.Utils;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
 * swapping the adjacent elements if they are in wrong order.
 * 
 * Time Complexity: O(n^2)
 * 
 * Auxiliary Space: O(1)
 * 
 * @author Spacey4uq
 *
 */
public class _005_BubbleSort {

	private static int[] optimizedBubbleSort(int[] arr, int n) {
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++) {
			swapped = false;
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j] and arr[j+1]
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			// IF no two elements were
			// swapped by inner loop, then break
			if (swapped == false)
				break;
		}
		return arr;
	}

	private static int[] bubbleSort(int[] inp) {
		int n = inp.length;
		// 'i' iterates for each pass.
		// on each pass, at least the largest element will be placed in its right
		// position.
		// that's why the number of pass is always n-1.
		for (int i = 0; i < n - 1; i++) {
			// runs till the unsorted part alone (n-i-1)
			for (int j = 0; j < n - i - 1; j++) {
				if (inp[j] > inp[j + 1]) {
					swap(inp, j, j + 1);
				}
			}
		}
		return inp;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int[] inp = { 15, 45, 35, 25, 5 };
		Utils.printArray(bubbleSort(inp));
	}

}
