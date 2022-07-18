package com.spacey.ps.dsa.algo.dp;

import java.util.Map;

//import java.util.HashMap;
//import java.util.Map;

public class _001_FibMemoization {

	// 1. General recursive approach
	// TimeC: O(2^(n)), SpaceC (depth of the tree): O(n)
	static int fib(int n) {
		if (n <= 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	// memoization
	// TimeC: O(n), SpaceC: O(n)
	static long fibMemoized(int n) {
//		return fibMemoized(n, new HashMap<>());
		 return fibMemoized(n, new Long[n+1]);
	}

	static long fibMemoized(int n, Long[] memo) {
		if(memo[n] != null) return memo[n];
		if(n <= 2) return 1;
		memo[n] = fibMemoized(n-1, memo) + fibMemoized(n-2, memo);
		return memo[n];
	}
		
	
	static long fibMemoized(int n, Map<Integer, Long> memo) {
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		long ans = 0;
		if (n <= 2) {
			ans = 1;
		} else {
			ans = fibMemoized(n - 1, memo) + fibMemoized(n - 2, memo);
		}
		memo.putIfAbsent(n, ans);
		return ans;
	}
	

	public static void main(String[] args) {
		System.out.println(fib(6));
		System.out.println(fib(7));
		System.out.println(fib(8));
//		System.out.println(fib(50)); // This takes up lot of time.
		System.out.println(fibMemoized(6));
		System.out.println(fibMemoized(7));
		System.out.println(fibMemoized(8));
		System.out.println(fibMemoized(50)); // This is super fast
	}

}
