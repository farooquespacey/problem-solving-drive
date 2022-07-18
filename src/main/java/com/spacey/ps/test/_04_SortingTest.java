package com.spacey.ps.test;

import java.util.Arrays;

public class _04_SortingTest {

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
	 * @param inp
	 * @return
	 */
	static int[] selectionSort(int[] inp) {
		for (int i = 0; i < inp.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < inp.length; j++)
				min = inp[j] < inp[min] ? j : min;
			int tmp = inp[min];
			inp[min] = inp[i];
			inp[i] = tmp;
		}
		return inp;
	}

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
	 * @param inp
	 * @return
	 */
	private static int[] insertionSort(int[] inp) {
		for (int i = 1; i < inp.length; i++) {
			int j = i - 1;
			int currNo = inp[i];
			while (j >= 0 && inp[j] > currNo) {
				inp[j + 1] = inp[j];
				j--;
			}
			inp[j + 1] = currNo;
		}
		return inp;
	}

	/**
	 * 
	 * Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides the
	 * input array into two halves, calls itself for the two halves, and then merges
	 * the two sorted halves. The merge() function is used for merging two halves.
	 * The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and
	 * arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. See the
	 * following C implementation for details.
	 * 
	 * 
	 * 
	 * @param inp
	 * @return
	 */
	private static int[] mergeSort(int[] inp) {
		// TODO Auto-generated method stub
		return null;
	}

	static void printArray(int[] inp) {
		Arrays.stream(inp).boxed().forEach(e -> System.out.print(e + " "));
	}

	public static void main(String[] args) {
		int[] inp = { 15, 45, 35, 25, 5 };
		printArray(selectionSort(inp.clone()));
		System.out.println();

		printArray(insertionSort(inp.clone()));
		System.out.println();

		printArray(mergeSort(inp.clone()));
		System.out.println();

	}

}
