package com.spacey.ps.dsa.algo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _005_BestSum {

	// 1. Brute force
	// m = target sum
	// n = numbers.length
	// TC: O(n^m * m);
	// SC: O(m^2) where first 'm' is the depth of the tree which
	// like always is m and then another 'm' for tracking the best solution which
	// would be at most of m length and it is maintained in each recursed version.
	// that's why the O(m * m) === O(m^2)
	static List<Integer> bestSum(int target, int[] numbers) {
		if (target == 0)
			return new ArrayList<>();
		if (target < 0)
			return null;
		List<Integer> bestAns = null;
		for (int num : numbers) {
			List<Integer> ans = bestSum(target - num, numbers);
			if (ans != null) {
				ans.add(num);
				if (bestAns == null || bestAns.size() > ans.size()) {
					bestAns = ans;
				}
			}
		}
		return bestAns;
	}

	// 2. Memoization
	// TC: O(n*m^2), SC: O(m^2) where the first 'm' to store at most m keys and the
	// second 'm' to store value array of at most m length
	static List<Integer> bestSumMemoized(int target, int[] numbers) {
		return bestSumMemoized(target, numbers, new HashMap<>());
	}

	private static List<Integer> bestSumMemoized(int target, int[] numbers, Map<Integer, List<Integer>> memo) {
		if (memo.containsKey(target))
			return memo.get(target);
		if (target == 0)
			return new ArrayList<>();
		if (target < 0)
			return null;
		List<Integer> bestAns = null;
		for (int num : numbers) {
			List<Integer> ans = bestSumMemoized(target - num, numbers, memo);
			if (ans != null) {
				// copy paste into an array, instead if we simply modify the ans then it is
				// possible that it is memoized somewhere and you are simply editing that
				// instead with its reference
				List<Integer> combination = new ArrayList<>(ans);
				combination.add(num);
				if (bestAns == null || bestAns.size() > combination.size()) {
					bestAns = combination;
				}
			}
		}
		memo.put(target, bestAns);
		return bestAns;
	}

	// 8, [2,3,5]
	static List<Integer> bestSumTabulized(int target, int[] numbers) {
		ArrayList<Integer>[] table = new ArrayList[target + 1];
		table[0] = new ArrayList<>();
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				for (int j = 0; j < numbers.length; j++) {
					int num = numbers[j];
					if (i + num <= target && (table[i + num] == null || 
							table[i + num].size() - 1 > table[i].size())) {
						table[i+num] = new ArrayList<>(table[i]);
						table[i+num].add(num);
					}
				}
			}
		}
		return table[target];
	}

	public static void main(String[] args) {
		System.out.println(bestSum(7, new int[] { 2, 3 }));
		System.out.println(bestSum(7, new int[] { 5, 3, 4, 7 }));
		System.out.println(bestSum(7, new int[] { 2, 4 }));
//		System.out.println(bestSum(100, new int[] { 1, 2, 5, 25 })); // Too slow
		System.out.println(bestSumMemoized(7, new int[] { 2, 3 }));
		System.out.println(bestSumMemoized(7, new int[] { 5, 3, 4, 7 }));
		System.out.println(bestSumMemoized(7, new int[] { 2, 4 }));
		System.out.println(bestSumMemoized(100, new int[] { 1, 2, 5, 25 }));
		System.out.println(bestSumMemoized(4, new int[] { 1, 2 }));
		System.out.println(bestSumTabulized(7, new int[] { 2, 3 }));
		System.out.println(bestSumTabulized(7, new int[] { 5, 3, 4, 7 }));
		System.out.println(bestSumTabulized(7, new int[] { 2, 4 }));
		System.out.println(bestSumTabulized(100, new int[] { 1, 2, 5, 25 }));
		System.out.println(bestSumTabulized(4, new int[] { 1, 2 }));
		
	}

}
