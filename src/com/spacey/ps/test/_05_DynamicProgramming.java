package com.spacey.ps.test;

public class _05_DynamicProgramming {

	public static void main(String[] args) {
		System.out.println(findNthUgyNumbers(150));
	}

	/**
	 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
	 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By
	 * convention, 1 is included. Given a number n, the task is to find n’th Ugly
	 * number
	 * 
	 * @param n
	 * @return
	 */
	static int findNthUgyNumbers(int n) {
		int i = 1;
		int uglyCount = 1;
		while (uglyCount < n) {
			i++;
			if (isUgly(i))
				uglyCount++;
		}
		return i;
	}

	private static boolean isUgly(int i) {
		i = maxDivide(i, 2);
		i = maxDivide(i, 3);
		i = maxDivide(i, 5);
		return i == 1;
	}

	private static int maxDivide(int i, int div) {
		while (i % div == 0) {
			i = i / div;
		}
		return i;
	}

}
