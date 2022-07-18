package com.spacey.ps.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * A string is considered beautiful if it satisfies the following conditions:
 * 
 * Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least
 * once in it. The letters must be sorted in alphabetical order (i.e. all 'a's
 * before 'e's, all 'e's before 'i's, etc.).
 * 
 * For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful,
 * but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful.
 * 
 * Given a string word consisting of English vowels, return the length of the
 * longest beautiful substring of word. If no such substring exists, return 0.
 * 
 * A substring is a contiguous sequence of characters in a string.
 * 
 * Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * 
 * Output: 13
 * 
 * Explanation: The longest beautiful substring in word is "aaaaeiiiiouuu" of
 * length 13.
 * 
 * @author Night King
 *
 */
public class _001_LongestSubstringOfAllVowelsInOrder {

	public static int longestBeautifulSubstring(String word) {
		int longest = 0;
		Set<Character> vow = new HashSet<>();
		for (int lo = -1, hi = 0; hi < word.length(); hi++) {
			if(hi > 0 && word.charAt(hi - 1) > word.charAt(hi)) {
				vow = new HashSet<>();
				lo = hi - 1;
			}
			vow.add(word.charAt(hi));
			if(vow.size() == 5) {
				longest = Math.max(longest, hi - lo);
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		System.out.println(longestBeautifulSubstring("iaeoooeuuaaaeiiioooouuuaeeeooiiuuu"));
		System.out.println(longestBeautifulSubstring("aaaaaaeiiiioou"));
	}

}
