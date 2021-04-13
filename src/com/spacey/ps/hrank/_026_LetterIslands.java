package com.spacey.ps.hrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class _026_LetterIslands {

	static int getMarkedIslands(String s, String substr) {
		String markedString = s.replaceAll(substr, "X");
		Pattern X_Pat = Pattern.compile("X+");
		Matcher X_Mat = X_Pat.matcher(markedString);
		int count = 0;
		while (X_Mat.find()) {
			count++;
		}
		return count;
	}

	static Set<String> getSubstrCombination(String s) {
		Set<String> setOfSubstr = new HashSet<String>();
		for(int i=0; i<s.length(); i++) {
			int j = i+1;
			while(j <= s.length()) {
				System.out.println(s.substring(i, j));
				setOfSubstr.add(s.substring(i, j));
				j++;
			}
		}
		return setOfSubstr;
	}

	/*
	 * Complete the letterIslands function below.
	 */
	static int letterIslands(String s, int k) {
		/*
		 * Write your code here.
		 */
		int neededIslands = k;
		int substrThatSatisfies = 0;
		for(String comb: getSubstrCombination(s)) {
			int markedIslands = getMarkedIslands(s, comb);
			if(markedIslands == neededIslands)
				substrThatSatisfies++;
		}
		return substrThatSatisfies;
	}
	
	
	
//	static int letterIslandsTry2(String s, int k) {
//		int len = s.length();
//		int comb = 0;
//		for(int currIdx=0; currIdx<len; currIdx++) {
//			int nextIdx = currIdx;
//			String substr =  s.substring(currIdx, nextIdx);
//			while(nextIdx <= len && s.indexOf(substr)>-1) {
//				substr = s.substring(currIdx, nextIdx);
//				if(getMarkedIslands(s, substr) == k) {
//					comb++;
//				}
//				nextIdx++;
//			}
//		}
//	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();

		int k = Integer.parseInt(scanner.nextLine().trim());

		int result = letterIslands(s, k);

		System.out.println(String.valueOf(result));
	}
}
