package com.spacey.ps.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class _008_LengthOfLongestSubstringWithoutRepeatingChars {

	static int lengthOfLongestSubstringBruteForce(String s) {
		int n = s.length();

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (checkRepetition(s, i, j)) {
					res = Math.max(res, j - i + 1);
				}
			}
		}

		return res;
	}

	static boolean checkRepetition(String s, int start, int end) {
		int[] chars = new int[128];

		for (int i = start; i <= end; i++) {
			char c = s.charAt(i);
			chars[c]++;
			if (chars[c] > 1) {
				return false;
			}
		}

		return true;
	}

	static int lengthOfLongestSubstringSlidingWindow(String s) {
		int[] chars = new int[128];

		int left = 0;
		int right = 0;

		int res = 0;
		while (right < s.length()) {
			char r = s.charAt(right);
			chars[r]++;

			while (chars[r] > 1) {
				char l = s.charAt(left);
				chars[l]--;
				left++;
			}

			res = Math.max(res, right - left + 1);

			right++;
		}
		return res;
	}

	// best solution
	static int lengthOfLongestSubstringSlidingWindowOptimized(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	// best solution
	// str = "ababca" ans = 3 for "abc" or "bca"
	static int lengthOfLongestSubstringMyTry2(String str) {
		int maxLen = 0;
		Map<Character, Integer> charToIdx = new HashMap<>();
		for (int idx = 0, startOfSub = 0; idx < str.length(); idx++) {
			char ch = str.charAt(idx);
			if(charToIdx.containsKey(ch)) {
				startOfSub = Math.max(charToIdx.get(ch) + 1, startOfSub);
			}
			maxLen = Math.max(maxLen, idx - startOfSub + 1);
			charToIdx.put(ch, idx);
		}
		return maxLen;
	}

	static int lengthOfLongestSubstringMyTry1(String s) {
		int maxLen = 0;
		Set<Character> set = new LinkedHashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!set.contains(ch)) {
				set.add(ch);
			} else {
				maxLen = maxLen < set.size() ? set.size() : maxLen;
				Iterator<Character> it = set.iterator();
				while (it.hasNext()) {
					Character toRemove = it.next();
					it.remove();
					if (toRemove == ch) {
						set.add(ch);
						break;
					}
				}
			}
		}
		maxLen = maxLen < set.size() ? set.size() : maxLen;
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringSlidingWindowOptimized("aabaab!bb"));
		System.out.println(lengthOfLongestSubstringSlidingWindowOptimized(" "));
		System.out.println(lengthOfLongestSubstringMyTry2("aabaab!bb"));
		System.out.println(lengthOfLongestSubstringMyTry2(" "));
		System.out.println(lengthOfLongestSubstringMyTry2("ababca"));
	}

}
