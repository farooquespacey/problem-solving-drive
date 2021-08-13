package com.spacey.ps.dsa.algo.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _003_CanSum {

	static boolean canSumWithNoNumReuse(int target, int[] numbers) {
		if (target == 0)
			return true;
		if (target < 0)
			return false;
		for (int i = 0; i < numbers.length; i++) {
			if (canSumWithNoNumReuse(target - numbers[i], Arrays.copyOfRange(numbers, i + 1, numbers.length)))
				return true;
		}
		return false;
	}

	// 1. Brute force
	// TC: O(n^m), SC: O(m) where m=targetSum and n=numbers.length
	static boolean canSum(int target, int[] numbers) {
		if (target == 0)
			return true;
		if (target < 0)
			return false;
		for (int num : numbers) {
			if (canSum(target - num, numbers))
				return true;
		}
		return false;
	}

	// 2. Memoization
	// TC: O(m * n), SC: O(m) where m=targetSum and n=numbers.length
	static boolean canSumMemoized(int target, int[] numbers) {
		return canSumMemoized(target, numbers, new HashMap<>());
	}

	private static boolean canSumMemoized(int target, int[] numbers, Map<Integer, Boolean> memo) {
		if (memo.containsKey(target))
			return memo.get(target);
		if (target == 0)
			return true;
		if (target < 0)
			return false;
		boolean ans = false;
		for (int num : numbers) {
			if (canSumMemoized(target - num, numbers, memo)) {
				ans = true;
				break;
			}
		}
		memo.put(target, ans);
		return memo.get(target);
	}

	public static void main(String[] args) {
		System.out.println(canSum(7, new int[] { 2, 3 }));
		System.out.println(canSum(7, new int[] { 5, 3, 4, 7 }));
		System.out.println(canSum(7, new int[] { 2, 4 }));
		System.out.println(canSumWithNoNumReuse(6, new int[] { 3, 4, 5 }));
//		System.out.println(canSum(300, new int[] {7, 14})); // Too slow
		System.out.println(canSumMemoized(7, new int[] { 2, 3 }));
		System.out.println(canSumMemoized(7, new int[] { 5, 3, 4, 7 }));
		System.out.println(canSumMemoized(7, new int[] { 2, 4 }));
		System.out.println(canSumMemoized(300, new int[] { 7, 14 }));
		System.out.println(canSumMemoized(100, new int[] { 1, 2, 5, 25 }));

	}

}
