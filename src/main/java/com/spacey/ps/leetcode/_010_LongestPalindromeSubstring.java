package com.spacey.ps.leetcode;

public class _010_LongestPalindromeSubstring {

	static String longestPalindromeTry1(String s) {
		return substring(s, 0, 1, "");
	}

	static String substring(String str, int start, int end, String longestPal) {
		if (start >= str.length() || end > str.length()) {
			return longestPal;
		}
		String sub = str.substring(start, end);
		if (isPalindrome(sub))
			longestPal = longestPal.length() < sub.length() ? sub : longestPal;
		if (end == str.length()) {
			return substring(str, start + 1, start + longestPal.length() + 2, longestPal);
		} else {
			return substring(str, start, end + 1, longestPal);
		}
	}

	static boolean isPalindrome(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	static String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int oddLen = expandAroundCenter(s, i, i);
			int evenLen = expandAroundCenter(s, i, i + 1);
			int len = Math.max(oddLen, evenLen);
			if (len > end - start) {
				start = i - ((len - 1) / 2);
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeTry1("cbabcsdasffaddfgddgfkl"));
		System.out.println(longestPalindrome("abcbd"));
	}

}
