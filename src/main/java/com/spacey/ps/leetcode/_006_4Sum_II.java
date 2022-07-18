package com.spacey.ps.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
 * return the number of tuples (i, j, k, l) such that:
 * 
 * 0 <= i, j, k, l < n. nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 
 * Output: 2 -- i.e., (0, 0, 0, 1) & (1, 1, 0, 0)
 * 
 * @author Night King
 *
 */
public class _006_4Sum_II {

	static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int a : A)
			for (int b : B)
				map.merge(a + b, 1, Integer::sum); // OR map.put( s, map.getOrDefault(s, 0)+1 );

		for (int c : C)
			for (int d : D)
				res += map.getOrDefault(-(c + d), 0);

		return res;
	}

	public static void main(String[] args) {
		System.out.println(
				fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 }, new int[] { 0, 2 }));
	}

}
