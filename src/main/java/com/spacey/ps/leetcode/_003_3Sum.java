package com.spacey.ps.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Input: nums = [-1,0,1,2,-1,-4]
 * 
 * Output: [[-1,-1,2],[-1,0,1]]
 * 
 * @author Night King
 *
 */
public class _003_3Sum {

	// sorted: -4,-3,-2,-2,-1,0,1,2,2,3,4
	static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			// if this is one of the prev number, then skip it
			if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						// following two while(s) to avoid duplicate triplets in the result
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
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
		return res;
	}

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { 1, 4, 2, 3, -1, -4, 0, -2, -2, -3, 2 }));
	}

}
