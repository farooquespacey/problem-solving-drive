package com.spacey.ps.test;

/**
 * CB
 * @author Night King
 *
 *         Link:
 *         https://www.geeksforgeeks.org/minimum-number-of-sets-with-numbers-less-than-y/
 *
 *         Given a string of consecutive digits and a number Y, the task is to
 *         find the number of minimum sets such that every set follows the below
 *         rule:
 * 
 *         i) Set should contain consecutive numbers ii) No digit can be used
 *         more than once. iii) The number in the set should not be more than Y.
 * 
 *         Examples:
 * 
 *         Input: s = "1234", Y = 30
 * 
 *         Output: 3
 * 
 *         Three sets of {12, 3, 4}
 * 
 * 
 *         Input: s = "1234", Y = 4
 * 
 *         Output: 4
 * 
 *         Four sets of {1}, {2}, {3}, {4}
 * 
 */

public class MinNbSets {

	static int minSets(String input1, int input2) {
		int count = 0;
		int num = 0;
		boolean lesser = false;
		int len = input1.length();
		for (int i = 0; i < len; i++) {
			int currNo = input1.charAt(i) - '0';
			num = num * 10 + currNo;
			if (num <= input2) {
				lesser = true;
			} else {
				if (lesser) { // prev was any lesser
					count++;
				}
				num = currNo;
				lesser = false;
				if (num <= input2) {
					lesser = true;
				} else {
					num = 0;
				}
			}
		}
		if (lesser)
			count++;
		return count;
	}

	public static void main(String[] args) {
		String input1 = "3456";
		int input2 = 6;
		System.out.println(minSets(input1, input2));
	}

}
