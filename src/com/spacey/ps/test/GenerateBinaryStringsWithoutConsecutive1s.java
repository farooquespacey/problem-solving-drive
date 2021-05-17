package com.spacey.ps.test;

public class GenerateBinaryStringsWithoutConsecutive1s {

	public static void main(String[] args) {
		int k = 3;
		consecutiveBins(k, "");
	}
	



	private static void consecutiveBins(int k, String prev) {
		if(k==0) {
			System.out.print(prev + " ");
			return;
		}
		consecutiveBins(k-1, prev + "0");
		consecutiveBins(k-1, prev + "1");
	}

}
