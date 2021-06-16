package com.spacey.ps.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Let the function f(s) be the frequency of the lexicographically smallest
 * character in a non-empty string s. For example, if s = "dcce" then f(s) = 2
 * because the lexicographically smallest character is 'c', which has a
 * frequency of 2.
 * 
 * You are given an array of strings words and another array of query strings
 * queries. For each query queries[i], count the number of words in words such
 * that f(queries[i]) < f(W) for each W in words.
 * 
 * Return an integer array answer, where each answer[i] is the answer to the ith
 * query.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * 
 * Output: [1]
 * 
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so
 * f("cbd") < f("zaaaz").
 * 
 * Example 2:
 * 
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 
 * Output: [1,2]
 * 
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second
 * query both f("aaa") and f("aaaa") are both > f("cc").
 * 
 * @author Spacey4uq
 *
 */
public class _013_CompareStringsbyFrequencyofSmallestCharacter {
	
	static int[] numSmallerByFrequencyOptimized(String[] queries, String[] words) {
		int[] ans = new int[queries.length];
        int[] count = new int[11]; // this is the key player in this game, an array to track count
        // in the constraints it is mentioned that max string size is 10 , means freq 10 is max
        
        for(String W : words) // store the count for the number of times f(s) occured
            count[f(W)-1]++; // for eg : f("aa") and f("bb") implies the freq '2' occured 2 times
        // the "-1" will make sense in the upcoming code
       
        for(int i=9;i>=1;i--)
            count[i] += count[i+1]; // this will update the index with 'distance from the current index to the highest frequency item'
        // for eg : [1,1,1,1,0,...,0] will become [1,3,2,1,0,...,0]
        // we can ignore the index 0 coz we will never query for "freq 0" in the upcoming code
        
        for(int i=0;i<queries.length;i++)
            ans[i] = count[f(queries[i])]; // now just query for the calculated distance
        
        return ans; // that's all !!! , oh don't forget the f(s)
	}

	static int[] numSmallerByFrequency(String[] queries, String[] words) {
		Map<Integer, Integer> numTimesByOccurances = new HashMap<>(10);
		for (int i = 0; i < words.length; i++) {
			int occurances = f(words[i]);
//			System.out.println(words[i] + " occured smallest by " + occurances + " times");
			numTimesByOccurances.merge(occurances, 1, (oldV, newV) -> oldV + newV);
		}
		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int queriedOcc = f(queries[i]);
			int out = 0;
			for (Integer occ : numTimesByOccurances.keySet()) {
				if (occ > queriedOcc) {
					out += numTimesByOccurances.get(occ);
				}
			}
			result[i] = out;
		}
		return result;
	}

	// returns the occurances for the smallest char
	static int f(String S) {
		int occurances = 1;
		char smallest = S.charAt(0);
		for (int j = 1; j < S.length(); j++) {
			Character ch = S.charAt(j);
			if (ch == smallest)
				occurances++;
			else if (ch < smallest) {
				smallest = ch;
				occurances = 1;
			}
		}
		return occurances;
	}

	public static void main(String[] args) {
		printArray(
				numSmallerByFrequencyOptimized(new String[] { "bbb", "cc", "cde" }, new String[] { "a", "aa", "aaa", "aaaa" }));
	}

	private static void printArray(int[] numSmallerByFrequency) {
		for(Integer i: numSmallerByFrequency) {
			System.out.print(i + ", ");
		}
	}

}
