package com.spacey.ps.dsa.algo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _004_HowSum {

	// 1. Brute force
	// TC: O(n^m * m), SC: O(m)
	static List<Integer> howSum(int target, int[] numbers) {
		if (target == 0)
			return new ArrayList<>();
		if (target < 0)
			return null;
		for (int num : numbers) {
			List<Integer> ans = howSum(target - num, numbers);
			if (ans != null) {
				ans.add(num);
				return ans;
			}
		}
		return null;
	}

	// 2. Memoization
	// TC: O(n*m^2), SC: O(m^2) where the first 'm' to store at most m keys and the
	// second 'm' to store value array of at most m length
	static List<Integer> howSumMemoized(int target, int[] numbers) {
		return howSumMemoized(target, numbers, new HashMap<>());
	}

	private static List<Integer> howSumMemoized(int target, int[] numbers, Map<Integer, List<Integer>> memo) {
		if (memo.containsKey(target))
			return memo.get(target);
		if (target == 0)
			return new ArrayList<>();
		if (target < 0)
			return null;
		List<Integer> ans = null;
		for (int num : numbers) {
			ans = howSumMemoized(target - num, numbers, memo);
			if (ans != null) {
				ans.add(num);
				break;
			}
		}
		memo.put(target, ans);
		return memo.get(target);
	}

	public static void main(String[] args) {
		System.out.println(howSum(7, new int[] { 2, 3 }));
		System.out.println(howSum(7, new int[] { 5, 3, 4, 7 }));
		System.out.println(howSum(7, new int[] { 2, 4 }));
//		System.out.println(canSum(300, new int[] {7, 14})); // Too slow
		System.out.println(howSumMemoized(7, new int[] { 2, 3 }));
		System.out.println(howSumMemoized(7, new int[] { 5, 3, 4, 7 }));
		System.out.println(howSumMemoized(7, new int[] { 2, 4 }));
		System.out.println(howSumMemoized(300, new int[] { 7, 14 }));
		System.out.println(howSumMemoized(100, new int[] { 1, 2, 5, 25 }));
	}

}
