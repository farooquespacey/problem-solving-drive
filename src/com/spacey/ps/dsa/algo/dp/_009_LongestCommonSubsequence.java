package com.spacey.ps.dsa.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class _009_LongestCommonSubsequence {

	static String lcsMemoized(String X, String Y) {
		return lcs(X, Y, new HashMap<>());
	}
	
	// gets the output string
	static String lcs(String X, String Y, Map<String, String> memo) {
		if (memo.containsKey(X + "," + Y)) {
			System.out.println("Contained: " + (X + "," + Y));
			return memo.get(X + "," + Y);
		}
		if (X.length() == 0 || Y.length() == 0)
			return "";
		int m = X.length() - 1;
		int n = Y.length() - 1;
		if (X.charAt(m) == Y.charAt(n)) {
			memo.put(X + "," + Y, lcs(X.substring(0, m), Y.substring(0, n), memo) + X.charAt(m));
			return memo.get(X + "," + Y);
		} else {
			String left = lcs(X, Y.substring(0, n), memo);
			String right = lcs(X.substring(0, m), Y, memo);
			memo.put(X + "," + Y, left.length() > right.length() ? left : right);
			return memo.get(X + "," + Y);
		}
	}

	// gets the output count
//	static int lcs(String X, String Y, Map<String, Integer> memo) {
//		if (memo.containsKey(X + "," + Y)) {
//			System.out.println("Contained: " + (X + "," + Y));
//			return memo.get(X + "," + Y);
//		}
//		if (X.length() == 0 || Y.length() == 0)
//			return 0;
//		int m = X.length() - 1;
//		int n = Y.length() - 1;
//		if (X.charAt(m) == Y.charAt(n)) {
//			memo.put(X + "," + Y, 1 + lcs(X.substring(0, m), Y.substring(0, n), memo));
//			return memo.get(X + "," + Y);
//		} else {
//			memo.put(X + "," + Y, Integer.max(lcs(X, Y.substring(0, n), memo), lcs(X.substring(0, m), Y, memo)));
//			return memo.get(X + "," + Y);
//		}
//	}

	public static void main(String[] args) {
		System.out.println(lcsMemoized("AGGTAB", "GXTXAYB"));
	}

}
