package com.spacey.ps.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*' where:
 * 
 * '.' Matches any single character.​​​​ '*' Matches zero or more of the
 * preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aa", p = "a"
 * 
 * Output: false
 * 
 * Explanation: "a" does not match the entire string "aa".
 * 
 * Example 2:
 * 
 * Input: s = "aa", p = "a*"
 * 
 * Output: true
 * 
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore,
 * by repeating 'a' once, it becomes "aa".
 * 
 * Example 3:
 * 
 * Input: s = "ab", p = ".*"
 * 
 * Output: true
 * 
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * Example 4:
 * 
 * Input: s = "aab", p = "c*a*b"
 * 
 * Output: true
 * 
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore,
 * it matches "aab".
 * 
 * Example 5:
 * 
 * Input: s = "mississippi", p = "mis*is*p*."
 * 
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 20
 * 
 * 0 <= p.length <= 30
 * 
 * s contains only lowercase English letters.
 * 
 * p contains only lowercase English letters, '.', and '*'.
 * 
 * It is guaranteed for each appearance of the character '*', there will be a
 * previous valid character to match.
 * 
 * 
 * @author Spacey4uq
 *
 */
public class _015_RegexMatching {

	// without wildcard(*), solution would be
//	def match(text, pattern):
//	    if not pattern: return not text
//	    first_match = bool(text) and pattern[0] in {text[0], '.'}
//	    return first_match and match(text[1:], pattern[1:])

	// with wildcard(*)
//	class Solution {
//	    public boolean isMatch(String text, String pattern) {
//	        if (pattern.isEmpty()) return text.isEmpty();
//	        boolean first_match = (!text.isEmpty() &&
//	                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//	        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
//	            return (isMatch(text, pattern.substring(2)) ||
//	                    (first_match && isMatch(text.substring(1), pattern)));
//	        } else {
//	            return first_match && isMatch(text.substring(1), pattern.substring(1));
//	        }
//	    }
//	}

	static boolean isMatch(String s, String p, Map<String, Boolean> memo) {
		if (memo.containsKey(s + "," + p)) {
			System.out.println("Contains:  " + (s+","+p));
			return memo.get(s + "," + p);
		}
		if (p.isEmpty())
			return s.isEmpty();
		boolean matched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		boolean zeroOrMore = p.length() > 1 && p.charAt(1) == '*';
		if (zeroOrMore) {
			memo.put(s + "," + p, isMatch(s, p.substring(2), memo) || (matched && isMatch(s.substring(1), p, memo)));
			return memo.get(s + "," + p);
		} else {
			memo.put(s + "," + p, matched && isMatch(s.substring(1), p.substring(1), memo));
			return memo.get(s + "," + p);
		}
	}

	public static void main(String[] args) {
		System.out.println(isMatch("mississippi", "mis*is*p*.", new HashMap<>()));
		System.out.println(isMatch("aaaaaaaaaaaaaaaaaaa", "aaaa*aa*a*a.", new HashMap<>()));
	}

}
