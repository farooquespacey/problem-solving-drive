package com.spacey.ps.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return the number of distinct subsequences of s
 * which equals t.
 * 
 * A string's subsequence is a new string formed from the original string by
 * deleting some (can be none) of the characters without disturbing the
 * remaining characters' relative positions. (i.e., "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 * 
 * It is guaranteed the answer fits on a 32-bit signed integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "rabbbit", t = "rabbit"
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * As shown below, there are 3 ways you can generate "rabbit" from S. rabbbit
 * rabbbit rabbbit
 * 
 * Example 2:
 * 
 * Input: s = "babgbag", t = "bag"
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * As shown below, there are 5 ways you can generate "bag" from S. babgbag
 * babgbag babgbag babgbag babgbag
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, t.length <= 1000 s and t consist of English letters.
 * 
 * 
 * @author Spacey4uq
 *
 */
public class _014_DistinctSubsequences {

	static int numDistinctTabulated(String S, String T) {
		final long startTime = System.currentTimeMillis();
		int[][] table = new int[S.length() + 1][T.length() + 1];

		for (int i = 0; i < S.length(); i++)
			table[i][0] = 1;

		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
				} else {
					table[i][j] += table[i - 1][j];
				}
			}
		}

		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime));
		return table[S.length()][T.length()];
	}

	static int numDistinct(String s, String t) {
		final long startTime = System.currentTimeMillis();
		int c = findSubsequence(s, "", t);
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime));
		return c;
	}

	static int findSubsequence(String s, String ans, String t) {
		if (s.length() == 0)
			return (ans.equals(t)) ? 1 : 0;
		int times = 0;
		char ch = s.charAt(0);
		if (ans.length() <= t.length() && t.startsWith(ans)) {
			times += findSubsequence(s.substring(1), ans + ch, t);
			times += findSubsequence(s.substring(1), ans, t);
		}
		return times;
	}

	static int numDistinctMemoized(String strToSubseq, String target) {
		final long startTime = System.currentTimeMillis();
		Map<String, Integer> memo = new HashMap<>();
		int count = numDistinctMemoized(strToSubseq, target, "", memo);
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime));
		return count;
	}

	private static int numDistinctMemoized(String strToSubseq, String target, String ans, Map<String, Integer> memo) {
		if (memo.containsKey(ans + "," + strToSubseq)) {
			return memo.get(ans + "," + strToSubseq);
		}
		;
		if (ans.equals(target))
			return 1;
		int count = 0;
		if (target.startsWith(ans)) {
			for (int i = 0; i < strToSubseq.length(); i++) {
				count += numDistinctMemoized(strToSubseq.substring(i + 1), target, ans + strToSubseq.charAt(i), memo);
			}
		}
		memo.put(ans + "," + strToSubseq, count);
		return count;
	}

	public static void main(String[] args) {

		System.out.println(numDistinct("babgbag", "bag"));
		System.out.println(numDistinct("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));
		System.out.println(numDistinct(
				"aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe",
				"bddabdcae"));
		System.out.println(numDistinctTabulated("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));

		System.out.println(numDistinctTabulated(
				"aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe",
				"bddabdcae"));
		System.out.println(numDistinctMemoized("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));
		System.out.println(numDistinctMemoized(
				"aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe",
				"bddabdcae"));
		System.out.println(numDistinctMemoized("bbd", "bc")); // Memoization overlapping
	}

}
