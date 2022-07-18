package com.spacey.ps.dsa.array;

public class StaticArray {

	private static void check(int[] arr, int toCheckValue) {
		// check if the specified element
		// is present in the array or not
		// using Linear Search method
		boolean test = false;
		for (int element : arr) {
			if (element == toCheckValue) {
				test = true;
				break;
			}
		}

		// Print the result
		System.out.println("Is " + toCheckValue + " present in the array: " + test);
	}

	public static void main(String[] args) {
		int[] staticArray = new int[] { 4, 6, 1, 7, 8 };
		// Access - O(1)
		int indexedVal = staticArray[2];
		System.out.println(indexedVal);
		// Search - O(n)
		check(staticArray, 7);
	}

}
