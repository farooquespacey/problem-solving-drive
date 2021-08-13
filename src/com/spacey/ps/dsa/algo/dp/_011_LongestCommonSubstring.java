package com.spacey.ps.dsa.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class _011_LongestCommonSubstring {
	
	static String lcsNaiveRecursive(String X, String Y, String prev) {
		if(X.length() == 0 || Y.length() == 0) return prev;
		int m = X.length() - 1, n = Y.length() - 1;
		String current = "";
		if(X.charAt(m) == Y.charAt(n)) {
			current = lcsNaiveRecursive(X.substring(0, m), Y.substring(0, n), X.charAt(m) + prev);
		} 
		String left = lcsNaiveRecursive(X, Y.substring(0, n), "");
		String right = lcsNaiveRecursive(X.substring(0, m), Y, "");
		String betterChild = right.length() > left.length() ? right : left;
		return current.length() > betterChild.length() ? current : betterChild;
	}
	
	// doesn't work --> trying to implement good recursion but failed to do so...
	static String lcsNaiveRecursiveTry2(String X, String Y) {
		if(X.length() == 0 || Y.length() == 0) return "";
		int m = X.length() - 1, n = Y.length() - 1;
		String current = "";
		if(X.charAt(m) == Y.charAt(n)) {
			current = lcsNaiveRecursiveTry2(X.substring(0, m), Y.substring(0, n)) + X.charAt(m);
		}
		String left = lcsNaiveRecursiveTry2(X.substring(0, m + 1), Y.substring(0, n));
		String right = lcsNaiveRecursiveTry2(X.substring(0, m), Y.substring(0, n + 1));		
		String betterChild = right.length() > left.length() ? right : left;
		return current.length() > betterChild.length() ? current : betterChild;
	}
	
	
	static String lcsMemoized(String X, String Y) {
		return lcs(X, Y, "", new HashMap<>());
	}

	private static String lcs(String x, String y, String ans, Map<String, String> memo) {
		if(memo.containsKey(x + "," + y + "," + ans)) return memo.get(x + "," + y + "," + ans);
		String lastAns = ans;
		if (x.length() == 0 || y.length() == 0)
			return ans;
		int m = x.length() - 1;
		int n = y.length() - 1;
		if (x.charAt(m) == y.charAt(n)) {
			ans = lcs(x.substring(0, m), y.substring(0, n), x.charAt(m) + ans, memo);
		}
		String left = lcs(x, y.substring(0, n), "", memo);
		String right = lcs(x.substring(0, m), y, "", memo);
		String betterChild = left.length() > right.length() ? left : right;
		ans = betterChild.length() > ans.length() ? betterChild : ans;
		memo.put(x + "," + y + "," + lastAns, ans);
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(lcsNaiveRecursive("ABC", "BCA", ""));
		System.out.println(lcsNaiveRecursive("aaaffaaaffaaaa", "aaafffaaa", ""));
		System.out.println(lcsMemoized("ABC", "BCA"));
		System.out.println(lcsMemoized("aaaffaaaffaaaa", "aaafffaaa"));
		
		System.out.println(lcsNaiveRecursiveTry2("ABC", "BCA"));
		System.out.println(lcsNaiveRecursiveTry2("ABCxMNy", "MNxABCy"));
	}

}
