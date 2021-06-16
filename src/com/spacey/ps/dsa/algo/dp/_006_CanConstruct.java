package com.spacey.ps.dsa.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class _006_CanConstruct {

	// 1. Brute force
	// m = target.length, n = wordBank.length
	// TC: O(n^m * m) where additional m is when it copies a substring from a target
	// string which would in turn iterate target over for m times in the worst case;
	// SC: O(m^2) where additional m is when each stack frame has to maintain a
	// suffix of at most m length
	static boolean canConstruct(String target, String[] wordBank) {
		if (target.isEmpty())
			return true;
		for (String word : wordBank) {
			if (target.startsWith(word)) {
				String suffix = target.substring(word.length());
				if (canConstruct(suffix, wordBank))
					return true;
			}
		}
		return false;
	}

	// 2. Memoization
	// TC: O(n* m^2); SC: O(m^2)
	static boolean canConstructMemoized(String target, String[] wordBank) {
		return canConstructMemoized(target, wordBank, new HashMap<>());
	}

	static boolean canConstructMemoized(String target, String[] wordBank, Map<String, Boolean> memo) {
		if (memo.containsKey(target))
			return memo.get(target);
		if (target.isEmpty())
			return true;
		for (String word : wordBank) {
			if (target.startsWith(word)) {
				String suffix = target.substring(word.length());
				if (canConstructMemoized(suffix, wordBank, memo)) {
					memo.put(target, true);
					return true;
				}
			}
		}
		memo.put(target, false);
		return false;
	}

	static boolean canConstructTabulized(String target, String[] wordBank) {
		boolean[] table = new boolean[target.length() + 1];
		table[0] = true;
		for (int i = 0; i <= target.length(); i++) {
			if (table[i] == true) {
				for (int j = 0; j < wordBank.length; j++) {
					String word = wordBank[j];
					if ((target.length() - i >= word.length())
							&& target.substring(i, i + word.length()).equals(word)) {
						table[i + word.length()] = true;
					}
				}
			}
		}
		return table[target.length()];
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
		System.out.println(canConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
//		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
//				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" })); // Too slow
		System.out.println(canConstructMemoized("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
		System.out.println(
				canConstructMemoized("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
		System.out.println(canConstructMemoized("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" }));
		System.out.println(canConstructTabulized("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
		System.out.println(
				canConstructTabulized("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
		System.out.println(canConstructTabulized("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" }));
	}

}
