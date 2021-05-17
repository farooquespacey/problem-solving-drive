package com.spacey.ps.codeforces;

/**
 * Let's call a positive integer n ordinary if in the decimal notation all its
 * digits are the same. For example, 1, 2 and 99 are ordinary numbers, but 719
 * and 2021 are not ordinary numbers.
 * 
 * @author Night King
 *
 */
public class _1520_B_OrdinaryNumbers {

	private static int numOfOrdinaries(int range) {
		int cnt = 0;
		int rem = 0;
		for (int i = 1; i <= range; i++) {
			rem = i % 10;
			int tmp = i;
			while (tmp % 10 == rem) {
				tmp /= 10;
			}
			if (tmp == 0)
				cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(numOfOrdinaries(100));
	}

}
