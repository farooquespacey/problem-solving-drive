package com.spacey.ps.dsa.algo.dp;

import java.util.Arrays;

/**
 * Partition a set into two subsets such that the difference of subset sums is
 * minimum
 * 
 * Given a set of integers, the task is to divide it into two sets S1 and S2
 * such that the absolute difference between their sums is minimum. If there is
 * a set S with n elements, then if we assume Subset1 has m elements, Subset2
 * must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2))
 * should be minimum.
 * 
 * Example:
 * 
 * Input: arr[] = {1, 6, 11, 5}
 * 
 * Output: 1
 * 
 * Explanation:
 * 
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * 
 * Subset2 = {11}, sum of Subset2 = 11
 * 
 * @author Spacey4uq
 *
 */
public class _012_MinimumPartition {

	static int findMin(int[] arr) {
		int total = 0;
		for (int i = 0; i < arr.length; i++)
			total += arr[i];
		return findMinPartDiff(arr, total / 2) + (total % 2 == 0 ? 0 : 1);
	}


	private static int findMinPartDiff(int[] arr, int sumToMatch) {
		if (sumToMatch <= 0)
			// multiply by 2 because the sum is broken into half initially 
			return Math.abs(sumToMatch) * 2;
		int min = sumToMatch * 2;
		for (int i = 0; i < arr.length; i++) {
			int withCurr = findMinPartDiff(Arrays.copyOfRange(arr, i + 1, arr.length), sumToMatch - arr[i]);
			min = Math.min(min, withCurr);
		}
		return min;
	}

	public static void main(String[] args) {
//		int arr[] = { 3, 1, 4, 2, 2, 1 };
//		int arr[] = { 1, 2, 3 };
		int arr[] = {2,3,11,5};
		System.out.print("The minimum difference between two sets is " + findMin(arr));
	}

}
