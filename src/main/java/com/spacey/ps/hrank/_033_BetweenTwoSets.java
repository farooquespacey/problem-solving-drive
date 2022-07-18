package com.spacey.ps.hrank;

import java.util.Arrays;

public class _033_BetweenTwoSets {

	public static int gcf(int a, int b) {
		int lowest = Math.min(a, b);
		for (int i = lowest / 2; 0 < i; i--) {
			if (a % i == 0 && b % i == 0) {
				System.out.println("Found GCF: " + i);
				return i;
			}
		}
		return -1;
	}

	public static int lcm(int a, int b) {
		int gcf = gcf(a, b);
		return a/gcf * b;
	}

	public static void main(String[] args) {
		System.out.println("Found LCM: " + lcm(18, 30));
	}

}
