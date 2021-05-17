package com.spacey.ps.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayIsGoodOrBad {
	/**
	 * Find if the array is Good or Bad.
	 * 
	 * Good denotes sum of any 2 subsequences of an int array are never same
	 * 
	 * Optionally try to make it Good in the Bad case by removing as min number(s)
	 * from the array as possible
	 * 
	 * @param a
	 */
	static void findRecurseSum(int[] a) {
		List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
		Integer sum = l.stream().reduce(0, (x, y) -> x + y);
		findRecurseSum(l, 0, sum);
	}

	static void findRecurseSum(List<Integer> a, int prev, int sum) {
		if (a.size() == 0) {
			if (sum / 2 == prev) {
				System.out.println("Bad");
			} else {
				System.out.println("Good");
			}
			return;
		}
		findRecurseSum(a.subList(1, a.size()), prev + a.get(0), sum);
		findRecurseSum(a.subList(1, a.size()), prev, sum);
	}

	public static void main(String... args) {
		findRecurseSum(new int[] { 3, 5, 6, 14, 6, 8, 42 });
	}
}
