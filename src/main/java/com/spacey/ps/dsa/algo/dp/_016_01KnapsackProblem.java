package com.spacey.ps.dsa.algo.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given weights and values of n items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack. In other words,
 * given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
 * and weights associated with n items respectively. Also given an integer W
 * which represents knapsack capacity, find out the maximum value subset of
 * val[] such that sum of the weights of this subset is smaller than or equal to
 * W. You cannot break an item, either pick the complete item or don’t pick it
 * (0-1 property).
 * 
 * @author Spacey4uq
 *
 */
public class _016_01KnapsackProblem {

	// naive approach -- strategy 1
	static int knapsack(int W, int[] weight, int[] value, int n) {
		if (W == 0 || n == weight.length)
			return 0;
		if (weight[n] > W)
			return knapsack(W, weight, value, n + 1);
		else
			return Math.max(value[n] + knapsack(W - weight[n], weight, value, n + 1),
					knapsack(W, weight, value, n + 1));
	}

	// naive approach -- strategy 2
	static int knapsack2(int W, int[] weight, int[] value) {
		int maxVal = 0;
		for (int i = 0; i < weight.length; i++) {
			if (weight[i] <= W) {
				int curr = value[i] + knapsack2(W - weight[i], Arrays.copyOfRange(weight, i + 1, weight.length),
						Arrays.copyOfRange(value, i + 1, value.length));
				maxVal = Math.max(maxVal, curr);
			}
		}
		return maxVal;
	}

	// Memoized version
	static int knapsackMemoized(int W, int[] weight, int[] value, int n, Map<String, Integer> memo) {
		if (W == 0 || n == weight.length)
			return 0;
		if (memo.containsKey(W + ":" + n))
			return memo.get(W + ":" + n);
		int result;
		if (weight[n] > W)
			result = knapsackMemoized(W, weight, value, n + 1, memo);
		else
			result = Math.max(value[n] + knapsackMemoized(W - weight[n], weight, value, n + 1, memo),
					knapsackMemoized(W, weight, value, n + 1, memo));
		memo.put(W + ":" + n, result);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(knapsack(50, new int[] { 10, 20, 30 }, new int[] { 60, 100, 120 }, 0));
//		System.out.println(knapsack(10,
//				new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//						1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
//				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3,
//						4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
//				0));
		System.out.println(knapsack2(50, new int[] { 10, 20, 30 }, new int[] { 60, 100, 120 }));
//		System.out.println(knapsack2(10,
//				new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//						1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
//				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3,
//						4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));

		System.out.println(
				knapsackMemoized(50, new int[] { 10, 20, 30 }, new int[] { 60, 100, 120 }, 0, new HashMap<>()));
		System.out.println(knapsackMemoized(10,
				new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3,
						4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				0, new HashMap<>()));

	}

}
