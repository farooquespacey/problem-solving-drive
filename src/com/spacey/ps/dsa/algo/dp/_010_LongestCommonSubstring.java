package com.spacey.ps.dsa.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class _010_LongestCommonSubstring {

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
		System.out.println(lcsMemoized("ABC", "BCA"));
		System.out.println(lcsMemoized("aaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaa"));
	}

}
