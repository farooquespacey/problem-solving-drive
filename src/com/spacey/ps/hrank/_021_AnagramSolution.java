package com.spacey.ps.hrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class _021_AnagramSolution {

	static private Map<Character, Integer> getMappings(String s){
		Map<Character, Integer> sMappings = new HashMap<>();
		for (char c : s.toCharArray()) {
			sMappings.compute(c, (theChar, theOccurance) -> theOccurance == null ? 1 : theOccurance + 1);
		}
		return sMappings;
	}
	
	static private int deleteChars(Map<Character, Integer> s1Mappings, Map<Character, Integer> s2Mappings) {
		int charDeleted = 0;
		for(char c: s1Mappings.keySet()) {
			int s1Occ = s1Mappings.get(c);
			if(s2Mappings.containsKey(c)) {
				int s2Occ = s2Mappings.get(c);
				charDeleted += Math.abs(s1Occ - s2Occ); 
			} else {
				charDeleted += s1Occ;
			}
		}
		for(char c: s2Mappings.keySet()) {
			int s2Occ = s2Mappings.get(c);
			if(!s1Mappings.containsKey(c)) {
				charDeleted += s2Occ;
			}
		}
		return charDeleted;
	}
	
	
	// best solution
    public static int numberNeeded(String first, String second) {
        int[] freqFirst = new int[26];
        int[] freqSecond = new int[26];
        int deletions = 0;
        System.out.println("first[0]: " + (first.charAt(0) - 'a'));
        
        for(int i = 0; i < first.length(); i++)
            freqFirst[first.charAt(i)-'a'] = freqFirst[first.charAt(i)-'a'] + 1; //Increment frequency of char at i
        for(int i = 0; i < second.length(); i++)
            freqSecond[second.charAt(i)-'a'] = freqSecond[second.charAt(i)-'a'] + 1; //Increment frequency of char at i
        
        for(int i = 0; i < 26; i++)
            deletions += Math.abs(freqFirst[i] - freqSecond[i]); //Track the total deletions needed
        
        return deletions;
    }
	
	// Complete the makingAnagrams function below.
	static int makingAnagrams(String s1, String s2) {
		Map<Character, Integer> s1Mappings = getMappings(s1);
		Map<Character, Integer> s2Mappings = getMappings(s2);
		int charDeleted = 0;
		charDeleted += deleteChars(s1Mappings, s2Mappings);
		return charDeleted;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s1 = scanner.nextLine();

		String s2 = scanner.nextLine();

		long startTime = System.currentTimeMillis();
		int result = makingAnagrams(s1, s2);
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " milliseconds");

		long startTime2 = System.currentTimeMillis();
		int result2 = numberNeeded(s1, s2);
		long endTime2 = System.currentTimeMillis();
		System.out.println("It took " + (endTime2 - startTime2) + " milliseconds");
		
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
		System.out.println(result);
		System.out.println(result2);
		scanner.close();
	}
}
