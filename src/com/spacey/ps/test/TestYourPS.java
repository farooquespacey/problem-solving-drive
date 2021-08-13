package com.spacey.ps.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestYourPS {
	
	static boolean canSum(int target, int[] nums) {
		if(target == 0) return true;
		if(target < 0) return false;
		for(int i=0; i<nums.length; i++) {
			if(canSum(target - nums[i], nums))
				return true;
		}
		return false;
	}
	
	static List<Integer> howSum(int target, int[] nums) {
		if(target == 0) return new ArrayList<>();
		if(target < 0) return null;
		List<Integer> l = null;
		for(int i=0; i<nums.length; i++) {
			l = howSum(target - nums[i], nums);
			if(l != null) {
				l.add(nums[i]);
				return l;
			}
		}
		return null;
	}
	
	static List<Integer> bestSum(int target, int[] nums) {
		if(target == 0) return new ArrayList<>();
		if(target < 0) return null;
		List<Integer> bestSum = null;
		for(int i=0; i<nums.length; i++) {
			List<Integer> l = howSum(target - nums[i], nums);
			if(l != null) l.add(nums[i]);
			if(bestSum == null || l.size() < bestSum.size()) {
				bestSum = l;
			}
		}
		return bestSum;
	}
	
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
				List<List<String>> targetWays = suffixWays.stream().map(way -> {
					way.add(word);
					return way;
				}).collect(Collectors.toList());
				listOfAllComb.addAll(targetWays);
			}
		}
		return listOfAllComb;
	}
	
	static void characterPrint() {
		for(int i=0; i<52;i++) {
			System.out.print((char)(i + '0') + ", ");
			if(i > 0 && i % 10 == 0) System.out.println();
		}
	}

	static int fib(int n) {
		if(n <= 2) return 1;
		return fib(n - 1) + fib(n - 2);
	}

	static BigInteger fact(int n) {
		if(n <= 2) return BigInteger.valueOf(n);
		return fact(n - 1).multiply(BigInteger.valueOf(n));
	}
	
	public static void main(String[] args) {
		System.out.println(canSum(6, new int[] {2,4}));
		System.out.println(howSum(6, new int[] {2,4}));
		System.out.println(bestSum(6, new int[] {2,4}));
		System.out.println(allConstruct("lol", new String[] {"a"}));
//		characterPrint();
//		System.out.println();
		System.out.println(fact(50)); 
	}

}
