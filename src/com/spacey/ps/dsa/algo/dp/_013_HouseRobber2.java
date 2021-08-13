package com.spacey.ps.dsa.algo.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have a security system connected, and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,2]
 * 
 * Output: 3
 * 
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money =
 * 2), because they are adjacent houses.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,1]
 * 
 * Output: 4
 * 
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * 
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 3:
 * 
 * Input: nums = [0]
 * 
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100
 * 
 * 0 <= nums[i] <= 1000
 * 
 * 
 * @author Spacey4uq
 *
 */
public class _013_HouseRobber2 {

	static int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		return Math.max(rob(nums, 0, n - 2, 0), rob(nums, 1, n - 1, 0));
	}

	// 1,2,3 .... 1,2
	static int rob(int[] nums, int lo, int hi, int sum) {
		if (lo > hi)
			return sum;
		if (lo == hi)
			return sum + nums[lo];
		return Math.max(rob(nums, lo + 1, hi, sum), rob(nums, lo + 2, hi, sum + nums[lo]));
	}

	
	public int robBest(int[] nums) {
	    if (nums.length == 1) return nums[0];
	    return Math.max(robBest(nums, 0, nums.length - 2), robBest(nums, 1, nums.length - 1));
	}
	
	
	private int robBest(int[] num, int lo, int hi) {
	    int include = 0, exclude = 0;
	    for (int j = lo; j <= hi; j++) {
	        int i = include, e = exclude;
	        include = e + num[j];
	        exclude = Math.max(e, i);
	    }
	    return Math.max(include, exclude);
	}
	

	public static void main(String[] args) {
		int[] nums = { 3, 5, 1, 7, 2, 9, 4 };
//		int[] nums = { 1, 2 };
		System.out.println(rob(nums));
	}

}
