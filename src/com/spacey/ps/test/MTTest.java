package com.spacey.ps.test;

import java.util.Arrays;

public class MTTest {

	// N=3, P=5, O=9
	// 3*1, 3*2, 3*3, 3*4, 3*5
	static int average(int N, int P) {
		int total = 0, j = 0;
		for (total = N, j = 1; j <= P; j++, total += N * j) {
			System.out.println(total);
		}
		return total / P;
	}

	public static void main(String[] args) {
		// 4,5,7
		int arr[] = { 2, 1 };
		int len = arr.length;

		Arrays.sort(arr);
		System.out.println(arr[0]);
		System.out.println(average(3, 5));
	}

}
