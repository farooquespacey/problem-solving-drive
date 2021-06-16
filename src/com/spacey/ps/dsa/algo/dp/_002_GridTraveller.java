package com.spacey.ps.dsa.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class _002_GridTraveller {

	// 1. Brute force
	// better to start off with brute force technique and then see the pattern for
	// overlaps
	// TC: O(2^(n+m)), SC: O(n+m)
	static int gridTraveller(int r, int c) {
		if (r == 0 || c == 0)
			return 0;
		if (r == 1 || c == 1)
			return 1;
		return gridTraveller(r - 1, c) + gridTraveller(r, c - 1);
	}

	// 2. Memoization
	// TC: O(m*n), SC: O(n+m)
	static long gridTravellerMemoized(int r, int c) {
		return gridTravellerMemoized(r, c, new HashMap<>());
	}

	static long gridTravellerMemoized(int r, int c, Map<String, Long> memo) {
		String key = r + "," + c;
		if (memo.containsKey(key))
			return memo.get(key);
		if (r == 0 || c == 0)
			return 0;
		if (r == 1 || c == 1)
			return 1;
		memo.put(key, gridTravellerMemoized(r - 1, c, memo) + gridTravellerMemoized(r, c - 1, memo));
		return memo.get(key);
	}

	public static void main(String[] args) {
		System.out.println(gridTraveller(2, 3));
		System.out.println(gridTraveller(10, 10));
//		System.out.println(gridTraveller(50, 50)); // Too slow
		System.out.println(gridTravellerMemoized(2, 3));
		System.out.println(gridTravellerMemoized(10, 10));
		System.out.println(gridTravellerMemoized(50, 50));
	}

}
