package com.spacey.ps.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _01_StringTest {

	// Set to store all the subsequences
	static HashSet<String> st = new HashSet<>();

	// Method 2: Function computes all the subsequence of an string
	static void subsequence(String str) {

		// Iterate over the entire string
		for (int i = 0; i < str.length(); i++) {

			// Iterate from the end of the string
			// to generate substrings
			for (int j = str.length(); j > i; j--) {
				String sub_str = str.substring(i, j);

				if (!st.contains(sub_str))
					st.add(sub_str);

				// Drop kth character in the substring
				// and if its not in the set then recur
				for (int k = 1; k < sub_str.length() - 1; k++) {
					StringBuffer sb = new StringBuffer(sub_str);

					// Drop character from the string
					sb.deleteCharAt(k);
					if (!st.contains(sb.toString()))
						subsequence(sb.toString());
				}
			}
		}
	}

	// Method 1: Pick and Don't Pick Concept
	private static void findsubsequences(String s, String ans) {
		if (s.length() == 0) {
			System.out.print(ans + ", ");
			return;
		}

		// We are adding 1st character in string
		findsubsequences(s.substring(1), ans + s.charAt(0));

		// Not adding first character of the string
		// because the concept of subsequence either
		// character will present or not
		findsubsequences(s.substring(1), ans);
	}

	
	
	// Method 1: Substrings with no recursion
	public static void substringsNoRecursion(String word) {
		for (int from = 0; from < word.length(); from++) {
			for (int to = from + 1; to <= word.length(); to++) {
				System.out.print(word.substring(from, to) + ", ");
			}
		}
	}

	// Method 2: Substrings with recursion
	/*
	 * It first checks the base case: if both start and end are equal to
	 * in.length(). Because if they are, that means there are no more substrings to
	 * be found, and the program ends.
	 * 
	 * Let's start with start=0 and end=1. They obviously don't equal in.length(),
	 * and end definitely doesn't equal in.length()+1. Thus, substring(0,1) will be
	 * printed out, which is 1. The next iteration of substrings will be
	 * substrings(0,2), and in.substring(0,2) will be printed, which is 12. This
	 * will continue until end == in.length()+1, which happens when the program
	 * finishes substrings(0,4) and tries to move on to substrings(0,5). 5 ==
	 * in.length()+1, so when that happens, the program will do
	 * substrings(start+1,start+1), which is substrings(1,1). The process will
	 * continue with substrings(1,2), and (1,3), until (1,5) when the program will
	 * run substrings(2,2).
	 * 
	 * All of this will continue until substrings(4,4), which, at that point, the
	 * program stops.
	 * 
	 * The result looks like this:
	 * 
	 * 1 12 123 1234
	 * 
	 * 2 23 234
	 * 
	 * 3 34
	 * 
	 * 4
	 */
	static void substrings(String in, int start, int end) {
		if (start == in.length())
			return;
		else {
			if (end == in.length() + 1) {
				substrings(in, start + 1, start + 2);
			} else {
				System.out.print(in.substring(start, end) + ", ");
				substrings(in, start, end + 1);
			}
		}
	}

	static void permutation(String word, String ans) {
		if (word.length() == 0) {
			System.out.print(ans + ", ");
			return;
		}
		for (int i = 0; i < word.length(); i++) {
			char curr = word.charAt(i);
			String rest = word.substring(0, i) + word.substring(i + 1);
			permutation(rest, ans + curr);
		}
	}
	
	private static void stringWithDivision(String inp, String prev) {
		if(inp.length() == 1) {
			System.out.print("[" + prev + inp + "],");
			return;
		}
		String first = prev + inp.charAt(0);
		stringWithDivision(inp.substring(1), first + "");
		stringWithDivision(inp.substring(1), first + ",");
	}
	
	private static void consecutiveBins(int k, String prev) {
		String next0 = prev+"0";
		String next1 = prev+"1";
		if(k == 1) {
			System.out.print(next0 + ", ");
			System.out.print(next1 + ", ");
		} else {
			consecutiveBins(k-1, next0);
			consecutiveBins(k-1, next1);
		}
	}
	
	private static int findMaxPalindromeSubsequence(String s, String ans) {
		if (s.length() == 0) {
			String reversed = new StringBuilder(ans).reverse().toString();
			return ans.equals(reversed) ? ans.length() : 0;
		}
		int sWithCurr = findMaxPalindromeSubsequence(s.substring(1), ans + s.charAt(0));
		int sWithoutCurr = findMaxPalindromeSubsequence(s.substring(1), ans);
		return Math.max(sWithCurr, sWithoutCurr);
	}

	
	public static int findMaxPalindromeSubsequence(String inp){
		return findMaxPalindromeSubsequence(inp, "");
	}
	
	public static void main(String[] args) {
		String inp = "abc";
		int n = inp.length();
		// 1. subsequence ex:- i/p - "abc" o/p - a,b,c,ab,ac,bc,abc
		findsubsequences(inp, "");
		System.out.println("\n----------------------------------------");
		subsequence(inp);
		System.out.println(st);
		System.out.println("\n========================================");
		// 2. substring ex:- i/p - "abc" o/p - a,b,c,ab,bc,abc
		substringsNoRecursion(inp);
		System.out.println("\n----------------------------------------");
		substrings(inp, 0, 1);
		System.out.println("\n========================================");
		// 3. permutation ex:- i/p - "abc" o/p - abc,acb,bac,bca,cab,cba
		permutation(inp, "");
		System.out.println("\n========================================");
		// 4. substring combination of whole string ex:- i/p - "abc" o/p -
		// [a,b,c],[a,bc],[ab,c],[abc]
		stringWithDivision(inp, "");
		System.out.println("\n========================================");
		// 5. binary nums combination of the given length
		// ex:- i/p - 2 o/p - 00,01,10,11 
		consecutiveBins(2, "");
		System.out.println("\n========================================");
		System.out.println(findMaxPalindromeSubsequence("BBABCBCAB"));
	}

}
