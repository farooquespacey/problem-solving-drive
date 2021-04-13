package com.spacey.ps.test;

public class GenerateBinaryStringsWithoutConsecutive1s {

	public static void main(String[] args) {
		int k = 3;
		consecutiveBins(k, "");
	}

	private static void consecutiveBins(int k, String prev) {
		String next0 = prev+"0";
		String next1 = prev+"1";
		if(k == 1) {
			System.out.println(next0);
			System.out.println(next1);
		} else {
			consecutiveBins(k-1, next0);
			consecutiveBins(k-1, next1);
		}
	}

}
