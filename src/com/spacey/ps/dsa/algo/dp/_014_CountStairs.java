package com.spacey.ps.dsa.algo.dp;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top.
 * The person can climb either 1 stair or 2 stairs at a time. Count the number
 * of ways, the person can reach the top.
 * 
 * Consider the example shown in the diagram. The value of n is 3. There are 3
 * ways to reach the top. The diagram is taken from Easier Fibonacci puzzles
 * 
 * Examples:
 * 
 * Input: n = 1; Output: 1
 * 
 * There is only one way to climb 1 stair
 * 
 * Input: n = 2; Output: 2
 * 
 * There are two ways: (1, 1) and (2)
 * 
 * Input: n = 4; Output: 5
 * 
 * (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)
 * 
 * @author Spacey4uq
 *
 */
public class _014_CountStairs {
	
	static long countStairs(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		return countStairs(n - 1) + countStairs(n - 2);
	}
	
	// DP: Memoized version
	static long countStairsMemoized(int n) {
		return countStairsMemoized(n, new Long[n + 1]);
	}

	private static long countStairsMemoized(int n, Long[] memo) {
		if(memo[n] != null) return memo[n];
		if(n == 1) return 1;
		if(n == 2) return 2;
		memo[n] = countStairsMemoized(n - 1, memo) + countStairsMemoized(n - 2, memo);
		return memo[n];
	}

	public static void main(String[] args) {
		System.out.println(countStairs(47));
		System.out.println(countStairsMemoized(47));
	}

}
