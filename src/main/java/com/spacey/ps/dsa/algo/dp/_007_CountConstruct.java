package com.spacey.ps.dsa.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class _007_CountConstruct {

	// 1. Brute force
	// m = target.length, n = wordBank.length
	// TC: O(n^m * m) where additional m is when it copies a substring from a target
	// string which would in turn iterate target over for m times in the worst case;
	// SC: O(m^2) where additional m is when each stack frame has to maintain a
	// suffix of at most m length
	static int countConstruct(String target, String[] wordBank) {
		if (target.isEmpty())
			return 1;
		int totalCount = 0;
		for (String word : wordBank) {
			if (target.startsWith(word)) {
				String suffix = target.substring(word.length());
				totalCount += countConstruct(suffix, wordBank);
			}
		}
		return totalCount;
	}

	// 2. Memoization
	// TC: O(n* m^2); SC: O(m^2)
	static int countConstructMemoized(String target, String[] wordBank) {
		return countConstructMemoized(target, wordBank, new HashMap<>());
	}

	static int countConstructMemoized(String target, String[] wordBank, Map<String, Integer> memo) {
		if (memo.containsKey(target))
			return memo.get(target);
		if (target.isEmpty())
			return 1;
		int totalCount = 0;
		for (String word : wordBank) {
			if (target.startsWith(word)) {
				String suffix = target.substring(word.length());
				totalCount += countConstructMemoized(suffix, wordBank, memo);
			}
		}
		memo.put(target, totalCount);
		return totalCount;
	}

	static int countConstructTabulized(String target, String[] wordBank) {
		int[] table = new int[target.length() + 1];
		table[0] = 1;
		for (int i = 0; i <= target.length(); i++) {
			if (table[i] > 0) {
				for (int j = 0; j < wordBank.length; j++) {
					String word = wordBank[j];
					if ((target.length() - i >= word.length()) && target.substring(i, i + word.length()).equals(word)) {
						table[i + word.length()] += table[i];
					}
				}
			}
		}
		return table[target.length()];
	}

	public static void main(String[] args) {
		System.out.println(countConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
		System.out.println(countConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
		System.out.println(countConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
//		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
//				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" })); // Too slow

		System.out.println(countConstructMemoized("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
		System.out.println(countConstructMemoized("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
		System.out.println(
				countConstructMemoized("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
		System.out.println(countConstructMemoized("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" }));

		System.out.println(countConstructTabulized("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
		System.out.println(countConstructTabulized("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
		System.out.println(
				countConstructTabulized("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
		System.out.println(countConstructTabulized("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" }));

	}

}
