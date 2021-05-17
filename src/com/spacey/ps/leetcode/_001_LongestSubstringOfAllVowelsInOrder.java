package com.spacey.ps.leetcode;

import java.util.Collections;
import java.util.HashSet;
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
		Stack<Character> vow = new Stack<Character>();
		Set<Integer> lengthsRecorded = new HashSet<>();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			switch (c) {
			case 'a':
				if (!vow.empty() && vow.peek() != 'a') {
					vow.clear();
				}
				vow.push(c);
				break;
			case 'e':
				if (!vow.empty() && (vow.peek() == 'a' || vow.peek() == 'e')) {
					vow.push(c);
				} else {
					vow.clear();
				}
				break;
			case 'i':
				if (!vow.empty() && (vow.peek() == 'e' || vow.peek() == 'i')) {
					vow.push(c);
				} else {
					vow.clear();
				}
				break;
			case 'o':
				if (!vow.empty() && (vow.peek() == 'i' || vow.peek() == 'o')) {
					vow.push(c);
				} else {
					vow.clear();
				}
				break;
			case 'u':
				if (!vow.empty() && (vow.peek() == 'o' || vow.peek() == 'u')) {
					vow.push(c);
					lengthsRecorded.add(vow.size());
				} else {
					vow.clear();
				}
				break;
			}
		}
		return lengthsRecorded.size() > 0 ? Collections.max(lengthsRecorded) : 0;
	}

	public static void main(String[] args) {
		System.out.println(longestBeautifulSubstring("iaeoooeuuaaaeiiioooouuuaeeeooiiuuu"));
	}

}
