package com.spacey.ps.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 
 * 0 <= a, b, c, d < n
 * 
 * a, b, c, and d are distinct.
 * 
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * 
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * @author Night King
 *
 */
public class _005_4Sum {


	private static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> listOfRes = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				for (int j = i + 1; j < nums.length - 2; j++) {
					if (j == i + 1 || nums[j] != nums[j - 1]) {
						int lo = j + 1, hi = nums.length - 1, sum = target - nums[i] - nums[j];
						while (lo < hi) {
							if (nums[lo] + nums[hi] == sum) {
								listOfRes.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
								while(lo < hi && nums[lo] == nums[lo+1]) lo++;
								while(lo < hi && nums[hi] == nums[hi-1]) hi--;
								lo++;
								hi--;
							} else if (nums[lo] + nums[hi] < sum) {
								lo++;
							} else {
								hi--;
							}
						}
					}

				}
			}
		}
		return listOfRes;
	}

	public static void main(String[] args) {
		System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
	}

}
