package com.spacey.ps.dsa.algo.searching;

import java.util.Arrays;

/**
 * Search a sorted array by repeatedly dividing the search interval in half.
 * Begin with an interval covering the whole array. If the value of the search
 * key is less than the item in the middle of the interval, narrow the interval
 * to the lower half. Otherwise, narrow it to the upper half. Repeatedly check
 * until the value is found or the interval is empty.
 * 
 * Time complexity: O(Log n)
 * 
 * @author Spacey4uq
 *
 */
public class BinarySearch {

	private static boolean binarySearch(int[] arr, int elementToSearch) {
		Arrays.sort(arr);
		int n = arr.length;
		return search(arr, elementToSearch, 0, n - 1);
	}

	private static boolean search(int[] arr, int search, int l, int r) {
		if (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == search) {
				return true;
			} else if (arr[mid] < search) {
				return search(arr, search, mid + 1, r);
			} else {
				return search(arr, search, l, mid - 1);
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, 40, 30 };
		System.out.println(binarySearch(arr, 30));
	}

}
