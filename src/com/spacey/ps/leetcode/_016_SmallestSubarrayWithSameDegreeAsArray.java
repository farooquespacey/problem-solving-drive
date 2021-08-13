package com.spacey.ps.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of n integers, we define its degree as the maximum frequency
 * of any element in the array. For example, the array [1, 2, 3, 4, 2, 2, 3] has
 * a degree of 3 because the number 2 occurs three times (which is more than any
 * other number in the array). We want to know the size of the smallest subarray
 * of our array such that the subarray&#39;s degree is equal to the array&#39;s
 * degree. For example, the array [1, 2, 2, 3, 1] has a degree of 2 because 1
 * and 2 occur a maximal two times. There are two possible subarrays with this
 * degree: [1, 2, 2, 3, 1] and [2, 2]. Our answer is the length of the smallest
 * subarray, which is 2. Complete the function in the editor below. It has one
 * parameter: an array of n integers, arr. The function must return an integer
 * denoting the minimum size of the subarray such that the degree of the
 * subarray is equal to the degree of the array.
 * 
 * Input Format The first line contains an integer, n, denoting the number of
 * elements in arr. Each line i of the n subsequent lines (where 0 ≤ i &lt; n)
 * contains an integer describing arr i . Constraints
 *  
 * Output Format
 * 
 * Return an integer denoting the minimum size of the subarray such that the
 * degree of the subarray is equal to the degree of the array.
 * 
 * @author Spacey4uq
 *
 */
public class _016_SmallestSubarrayWithSameDegreeAsArray {
	
	static int smallestSubarray(int[] nums) {
		Map<Integer, Integer> numberToTheirOccurances = new HashMap<>();
		Map<Integer, Integer> numberToTheirLastOccIdx = new HashMap<>();
		Map<Integer, Integer> numberToTheirFirstOccIdx = new HashMap<>();
		for(int i=0; i<nums.length;i++) { 
			numberToTheirOccurances.merge(nums[i], 1, Integer::sum);
			numberToTheirFirstOccIdx.putIfAbsent(nums[i], i);
			numberToTheirLastOccIdx.put(nums[i], i);
		}
		int longest = numberToTheirOccurances.values().stream()
                .max(Integer::compare)
                .orElse(-1);
		return numberToTheirOccurances.entrySet().stream().filter(e -> e.getValue() == longest)
//					.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
					.mapToInt(e -> numberToTheirLastOccIdx.get(e.getKey())
							- numberToTheirFirstOccIdx.get(e.getKey()) + 1)
					.min().orElse(0);
	}

	public static void main(String[] args) {
		int[] nums = {3,1,2,3,4,2,2,3};
		System.out.println(smallestSubarray(nums));
	}

}
