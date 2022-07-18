package com.spacey.ps.leetcode;

import java.util.Arrays;

/**
 * It is a sweltering summer day, and a boy wants to buy some ice cream bars.
 * 
 * At the store, there are n ice cream bars. You are given an array costs of
 * length n, where costs[i] is the price of the ith ice cream bar in coins. The
 * boy initially has coins coins to spend, and he wants to buy as many ice cream
 * bars as possible.
 * 
 * Return the maximum number of ice cream bars the boy can buy with coins coins.
 * 
 * Note: The boy can buy the ice cream bars in any order.
 * 
 * Example 1:
 * 
 * Input: costs = [1,3,2,4,1], coins = 7
 * 
 * Output: 4
 * 
 * Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total
 * price of 1 + 3 + 2 + 1 = 7.
 * 
 * @author Night King
 *
 */
public class _002_MaxIceCreamBars {

	// Time limit exceeds (without sorting)
	/*
	 * static int maxIceCream1(int[] costs, int coins) { return maxIceCream1(costs,
	 * coins, 0, 0); }
	 * 
	 * static int maxIceCream1(int[] costs, int coins, int sum, int count) { if
	 * (costs.length == 0 || sum > coins) { return sum > coins ? count - 1 : count;
	 * }
	 * 
	 * int c1 = maxIceCream1(Arrays.copyOfRange(costs, 1, costs.length), coins, sum
	 * + costs[0], count + 1); int c2 = maxIceCream1(Arrays.copyOfRange(costs, 1,
	 * costs.length), coins, sum, count);
	 * 
	 * return Math.max(c1, c2); }
	 */

	static int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		for (int i = 0; i < costs.length; ++i)
			if (coins >= costs[i])
				coins -= costs[i];
			else
				return i;
		return costs.length;
	}

	public static void main(String[] args) {
		System.out.println(maxIceCream(new int[] { 1, 3, 2, 4, 1 }, 7));
	}

}
