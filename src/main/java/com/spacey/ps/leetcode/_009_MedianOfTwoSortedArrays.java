package com.spacey.ps.leetcode;

import java.util.Arrays;

public class _009_MedianOfTwoSortedArrays {

	static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int[] temp = new int[nums1.length + nums2.length]; // create new array
		int m = 0;
		for (int g : nums1) { // first add array values to temp array
			temp[m++] = g;
		}
		for (int h : nums2) { 
			temp[m++] = h;
		}

		Arrays.parallelSort(temp); // sort the array

		if (temp.length % 2 == 0) { // here check the array lenth is even we need to avarage middle nums
			return (temp[temp.length / 2 - 1] + temp[temp.length / 2]) / 2.0;

		}
		return temp[temp.length / 2];
	}

	static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length, n3 = n1 + n2;
		int[] nums3 = new int[n3];
		int medianIndex = ((n1 + n2) + 1) / 2;
		int i = 0, j = 0, k = 0;
		while (k <= medianIndex && (i < n1 && j < n2)) {
			if (nums1[i] < nums2[j]) {
				nums3[k] = nums1[i];
				i++;
			} else {
				nums3[k] = nums2[j];
				j++;
			}
			k++;
		}
		while (k <= medianIndex && i < n1) {
			nums3[k] = nums1[i];
			i++;
			k++;
		}
		while (k <= medianIndex && j < n2) {
			nums3[k] = nums2[j];
			j++;
			k++;
		}
		for (int m = 0; m < nums3.length; m++)
			System.out.print(nums3[m] + " ");
		return (n3 % 2 == 0) ? (nums3[medianIndex - 1] + nums3[medianIndex]) / 2.0 : nums3[medianIndex - 1];
	}

	public static void main(String[] args) {
		System.out.println("\n" + findMedianSortedArrays1(new int[] { 1, 3 }, new int[] { 2 }));
	}

}
