package com.spacey.ps.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Input: nums = [3,2,4], target = 6 Output: [1,2]
 * 
 * @author Night King
 *
 */
public class _004_TwoSum {

	// 3,2,1,4,7; t=6; O(n) time complexity
	static int[] twoSum(int[] nums, int target) {
		int i1 = -1, i2 = -1;
		Map<Integer, Integer> numToIdx = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int currNo = nums[i];
			int numToCheckFor = target - currNo;
			if (numToIdx.containsKey(numToCheckFor)) {
				i1 = numToIdx.get(numToCheckFor);
				i2 = i;
				break;
			} else {
				numToIdx.put(currNo, i);
			}
		}
		return new int[] { i1, i2 };
	}

	// 3,2,1,4,7; t=6; O(n^2) time complexity
	static int[] twoSum1(int[] nums, int target) {
		int i1 = 0, i2 = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					i1 = i;
					i2 = j;
					break;
				}
			}
		}
		return new int[] { i1, i2 };
	}

	public static void main(String[] args) {
		printArray(twoSum1(new int[] { 3, 2, 4 }, 6));
	}

	private static void printArray(int[] arr) {
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
	}

}
