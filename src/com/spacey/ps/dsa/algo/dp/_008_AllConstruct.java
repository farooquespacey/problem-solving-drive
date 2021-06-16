package com.spacey.ps.dsa.algo.dp;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _008_AllConstruct {

	// 1. Brute force
	// m = target.length, n = wordBank.length
	static List<List<String>> allConstruct(String target, String[] wordBank) {
		List<List<String>> listOfAllComb = new ArrayList<>();
		if (target.isEmpty()) {
			listOfAllComb.add(new ArrayList<>());
			return listOfAllComb;
		}
		for (String word : wordBank) {
			if (target.startsWith(word)) {
				String suffix = target.substring(word.length());
				List<List<String>> suffixWays = allConstruct(suffix, wordBank);
//				for (List<String> suffixWay : suffixWays) {
//					suffixWay.add(word);
//				}
				List<List<String>> targetWays = suffixWays.stream().map(way -> {
					way.add(word);
					return way;
				}).collect(Collectors.toList());
				listOfAllComb.addAll(targetWays);
			}
		}
		return listOfAllComb;
	}

	// 2. Memoization
	static List<List<String>> allConstructMemoized(String target, String[] wordBank) {
		return allConstructMemoized(target, wordBank, new HashMap<>());
	}

	static List<List<String>> allConstructMemoized(String target, String[] wordBank,
			Map<String, List<List<String>>> memo) {
		if (memo.containsKey(target))
			return memo.get(target);
		List<List<String>> listOfAllComb = new ArrayList<>();
		if (target.isEmpty()) {
			listOfAllComb.add(new ArrayList<>());
			return listOfAllComb;
		}
		for (String word : wordBank) {
			if (target.startsWith(word)) {
				String suffix = target.substring(word.length());
				List<List<String>> suffixWays = allConstructMemoized(suffix, wordBank, memo);
//				for (List<String> suffixWay : suffixWays) {
//					suffixWay.add(word);
//				}
				List<List<String>> targetWays = suffixWays.stream().map(way -> {
					List<String> wayCopy = new ArrayList<>(way);
					wayCopy.add(word);
					return wayCopy;
				}).collect(Collectors.toList());
				listOfAllComb.addAll(targetWays);
			}
		}
		memo.put(target, listOfAllComb);
		return listOfAllComb;
	}

	static List<List<String>> allConstructTabulized(String target, String[] wordBank) {
		List<List<String>>[] table = new ArrayList[target.length() + 1];
		for (int i = 0; i < table.length; i++) {
			table[i] = new ArrayList<>();
		}
		// base case
		table[0].add(new ArrayList<>());
		for (int i = 0; i <= target.length(); i++) {
			if(table[i].size() > 0) {
				for (int j = 0; j < wordBank.length; j++) {
					String word = wordBank[j];
					if ((target.length() - i >= word.length()) && target.substring(i, i + word.length()).equals(word)) {
						List<List<String>> comb = new ArrayList<>(table[i]);
						comb = comb.stream().map(way -> {
							List<String> wayCopy = new ArrayList<>(way);
							wayCopy.add(word);
							return wayCopy;
						}).collect(Collectors.toList());
						table[i + word.length()].addAll(comb);
					}
				}
			}
		}
		return table[target.length()];
	}

	public static void main(String[] args) {
		System.out.println(allConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
		System.out.println(allConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
		System.out.println(allConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
//		System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
//				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" })); // Too slow
		System.out.println(allConstructMemoized("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
		System.out.println(allConstructMemoized("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
		System.out.println(
				allConstructMemoized("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
		System.out.println(allConstructMemoized("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" }));
		
		System.out.println(allConstructTabulized("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
		System.out.println(allConstructTabulized("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
		System.out.println(
				allConstructTabulized("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
		System.out.println("OVER");
		System.out.println(allConstructTabulized("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" }));

	}

}
