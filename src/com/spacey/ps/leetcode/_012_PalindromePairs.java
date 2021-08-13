package com.spacey.ps.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of unique words, return all the pairs of the distinct indices
 * (i, j) in the given list, so that the concatenation of the two words words[i]
 * + words[j] is a palindrome.
 * 
 * Example 1:
 * 
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * 
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * 
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * Example 2:
 * 
 * Input: words = ["bat","tab","cat"]
 * 
 * Output: [[0,1],[1,0]]
 * 
 * Explanation: The palindromes are ["battab","tabbat"]
 * 
 * Example 3:
 * 
 * Input: words = ["a",""]
 * 
 * Output: [[0,1],[1,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 5000 0 <= words[i].length <= 300 words[i] consists of
 * lower-case English letters.
 * 
 * 
 * @author Spacey4uq
 *
 */
public class _012_PalindromePairs {
	static List<List<Integer>> palindromePairsTryTest(String[] words) {
		Map<String, Integer> wordToPos = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			wordToPos.put(words[i], i);
		}
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				String str1 = word.substring(0, j);
				String str2 = word.substring(j);
				if(isPalindrome(str1)) {
					String str2Rev = new StringBuilder(str2).reverse().toString();
					if(wordToPos.containsKey(str2Rev)) {
						result.add(Arrays.asList(wordToPos.get(str2Rev), i));
					}
				}
				if(isPalindrome(str2)) {
					String str1Rev = new StringBuilder(str1).reverse().toString();
					if(wordToPos.containsKey(str1Rev)) {
						result.add(Arrays.asList(i, wordToPos.get(str1Rev)));
					}
				}
			}
		}
		return result;
	}

	// https://medium.com/@harycane/palindrome-pairs-46c5b8511397
	static List<List<Integer>> palindromePairsTry2(String[] words) {
		// result list of lists
		List<List<Integer>> res = new ArrayList<>();

		if (words == null || words.length < 2)
			return res;

		// declare hashmap
		HashMap<String, Integer> map = new HashMap<>();

		// map each word and its index in hashmap
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		// iterate over words array
		for (int currIdx = 0; currIdx < words.length; currIdx++) {
			// iterate over each letter in each word; <= to take into account "" word
			for (int j = 0; j <= words[currIdx].length(); j++) {
				// substring 1
				String str1 = words[currIdx].substring(0, j);
				// substring 2; remaining part of the words[i]
				String str2 = words[currIdx].substring(j);

				if (isPalindrome(str1)) {

					String str2revs = new StringBuilder(str2).reverse().toString();
					if (map.containsKey(str2revs) && map.get(str2revs) != currIdx)
						res.add(Arrays.asList(map.get(str2revs), currIdx));
				}

				if (isPalindrome(str2)) {
					String str1revs = new StringBuilder(str1).reverse().toString();
					if (map.containsKey(str1revs) && map.get(str1revs) != currIdx && str2.length() != 0)
						res.add(Arrays.asList(currIdx, map.get(str1revs)));
				}
			}
		}
		return res;

		// T O(nk^2) n length of words, k avg/worst case length of each word S O(n)
	}

	static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (isPalindrome(words[i] + words[j])) {
					res.add(Arrays.asList(i, j));
				}
				if (isPalindrome(words[j] + words[i])) {
					res.add(Arrays.asList(j, i));
				}
			}
		}
		return res;
	}

	private static boolean isPalindrome(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	public static void main(String[] args) {
		System.out.println(palindromePairsTry2(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
		System.out.println(palindromePairsTry2(new String[] { "ababa", "ba", "ab" }));
		// case 1: first half palindromic (bab from babcd)
		System.out.println(palindromePairsTry2(new String[] { "dc", "babcd" }));
		// case 2: second half palindromic (bab from dcbab)
		System.out.println(palindromePairsTry2(new String[] { "dcbab", "cd" }));
		// case 3: middle of palindrome
		System.out.println(palindromePairsTry2(new String[] { "cba", "abc" }));
	}

}
