package com.spacey.ps.dsa.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the
 * longest subsequence of a given sequence such that all elements of the
 * subsequence are sorted in increasing order. For example, the length of LIS
 * for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60,
 * 80}.
 * 
 * @author Spacey4uq
 *
 */
public class _010_LongestIncreasingSubsequence {

	static int max_ref; // stores the LIS

	/*
	 * To make use of recursive calls, this function must return two things: 1)
	 * Length of LIS ending with element arr[n-1]. We use max_ending_here for this
	 * purpose 2) Overall maximum as the LIS may end with an element before arr[n-1]
	 * max_ref is used this purpose. The value of LIS of full array of size n is
	 * stored in max_ref which is our final result
	 */
	static int _lis(int arr[], int n) {
		// base case
		if (n == 1)
			return 1;

		// 'max_ending_here' is length of LIS ending with
		// arr[n-1]
		int res, max_ending_here = 1;

		/*
		 * Recursively get all LIS ending with arr[0], arr[1] ... arr[n-2]. If arr[i-1]
		 * is smaller than arr[n-1], and max ending with arr[n-1] needs to be updated,
		 * then update it
		 */
		for (int i = 1; i < n; i++) {
			res = _lis(arr, i);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		// Compare max_ending_here with the overall max. And
		// update the overall max if needed
		if (max_ref < max_ending_here)
			max_ref = max_ending_here;

		// Return length of LIS ending with arr[n-1]
		return max_ending_here;
	}

	// The wrapper function for _lis()
	static int lis(int arr[], int n) {
		// The max variable holds the result
		max_ref = 1;

		// The function _lis() stores its result in max
		_lis(arr, n);

		// returns max
		return max_ref;
	}

	static int lisNaive(int[] nums) {
		return lisNaive(nums, 0, 1);
	}

	// bad recursion: lis(child) is not consistent
	// 100,50,25,40 ........... 7,8,1,2.....7,8,9,1,2,10
	private static int lisNaive(int[] nums, int start, int len) {
		if (start == nums.length - 1) {
			return len;
		}
		int curr = nums[start];
		int maxCount = len;
		for (int i = start + 1; i < nums.length; i++) {
			int count = 0;
			if (nums[i] > curr) {
				count = lisNaive(nums, i, 1 + len);
			} else {
				count = lisNaive(nums, i, 1);
			}
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

	static int lisNaiveMemoized(int[] nums) {
		return lisNaiveMemoized(nums, 0, 1, new HashMap<>());
	}

	private static int lisNaiveMemoized(int[] nums, int start, int len, Map<String, Integer> memo) {
		if (start == nums.length - 1)
			return len;
		if (memo.containsKey(start + ":" + len)) {
			return memo.get(start + ":" + len);
		}
		int curr = nums[start];
		int maxCount = len;
		for (int i = start + 1; i < nums.length; i++) {
			int count = 0;
			if (nums[i] > curr) {
				count = lisNaiveMemoized(nums, i, 1 + len, memo);
			} else {
				count = lisNaiveMemoized(nums, i, 1, memo);
			}
			maxCount = Math.max(maxCount, count);
		}
		memo.put(start + ":" + len, maxCount);
		return maxCount;
	}

	static int lisNaive2(int[] nums) {
		return lisNaive2(nums, 0);
	}

	// try for a good recursion: lis(child) is consistent (tho it fails "7, 8, 1,
	// 2")
	private static int lisNaive2(int[] nums, int start) {
		if (start >= nums.length - 1)
			return 1;
		int curr = nums[start];
		int bestChild = 0;
		for (int i = start + 1; i < nums.length; i++) {
			int childLis;
			if (nums[i] > curr) {
				childLis = 1 + lisNaive2(nums, i);
			} else {
				childLis = lisNaive2(nums, i);
			}
			bestChild = Math.max(bestChild, childLis);
		}
		return bestChild;
	}
	
	private static int lisNaive3(int[] nums) {
		for(Integer num: nums) {
			
		}
		return 0;
	}

	static int lisNaive2Memoized(int[] nums) {
		return lisNaive2Memoized(nums, 0, new HashMap<>());
	}

	private static int lisNaive2Memoized(int[] nums, int start, Map<Integer, Integer> memo) {
		if (memo.containsKey(nums[start])) {
			return memo.get(nums[start]);
		}
		if (start == nums.length - 1)
			return 1;
		int curr = nums[start];
		int bestChild = 0;
		for (int i = start + 1; i < nums.length; i++) {
			if (nums[i] > curr) {
				int child = lisNaive2Memoized(nums, i, memo);
				if (child > bestChild)
					bestChild = child;
			}
		}
		memo.put(nums[start], 1 + bestChild);
		return memo.get(nums[start]);
	}

	public static void main(String[] args) {
//		int[] arr = { 10, 22, 11, 33, 21, 50, 41, 60, 80 }; // 10, 22, 33, 50, 60, 80
		int[] arr = { 1, 2, 3, 4, 4, 6, 7, 2, 3, 4, 5, 6, 72, 3, 4, 5, 6, 7, 8 };
		System.out.println(lisNaive(arr));
		System.out.println(lisNaive2(arr));
		System.out.println(lis(arr, arr.length));
		System.out.println(lisNaive2Memoized(arr));

		System.out.println(lisNaive2(new int[] { 100, 50, 25, 40 }));
		System.out.println(lisNaive2(new int[] { 25, 40, 100, 50 }));
		System.out.println(lisNaive2(new int[] { 25, 30, 26, 27 }));
		System.out.println(lisNaive2(new int[] { 10, 22, 11, 33, 21, 50, 41, 60, 80 }));
		System.out.println(lisNaive2(new int[] { 7, 8, 1, 2 }));
		System.out.println(lisNaive2(new int[] { 7, 8, 9, 1, 2, 10 }));
		System.out.println("==================================");
		System.out.println(lisNaive(new int[] { 100, 50, 25, 40 }));
		System.out.println(lisNaive(new int[] { 25, 40, 100, 50 }));
		System.out.println(lisNaive(new int[] { 25, 30, 26, 27 }));
		System.out.println(lisNaive(new int[] { 10, 22, 11, 33, 21, 50, 41, 60, 80 }));
		System.out.println(lisNaive(new int[] { 7, 8, 1, 2 }));
		System.out.println(lisNaive(new int[] { 7, 8, 9, 1, 2, 10 }));
		System.out.println("==================================");
		System.out.println(lisNaiveMemoized(new int[] { 100, 50, 25, 40 }));
		System.out.println(lisNaiveMemoized(new int[] { 25, 40, 100, 50 }));
		System.out.println(lisNaiveMemoized(new int[] { 25, 30, 26, 27 }));
		System.out.println(lisNaiveMemoized(new int[] { 10, 22, 11, 33, 21, 50, 41, 60, 80 }));
		System.out.println(lisNaiveMemoized(new int[] { 7, 8, 1, 2 }));
		System.out.println(lisNaiveMemoized(new int[] { 7, 8, 9, 1, 2, 10 }));
		System.out.println("==================================");
		System.out.println(lis(new int[] { 100, 50, 25, 40 }, 4));
		System.out.println(lis(new int[] { 25, 40, 100, 50 }, 4));
		System.out.println(lis(new int[] { 25, 30, 26, 27 }, 4));
		System.out.println(lis(new int[] { 10, 22, 11, 33, 21, 50, 41, 60, 80 }, 9));
		System.out.println(lis(new int[] { 7, 8, 1, 2 }, 4));
		System.out.println(lis(new int[] { 7, 8, 9, 1, 2, 10 }, 6));
		System.out.println("==================================");
		System.out.println(lisNaiveMemoized(new int[] { 7, 8, 1, 2 }));
	}

}
