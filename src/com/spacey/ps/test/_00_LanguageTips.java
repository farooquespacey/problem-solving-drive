package com.spacey.ps.test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class is designed to help develops understand some of the lesser known
 * facts/tweaks in java
 * 
 * @author Spacey4uq
 *
 */
public class _00_LanguageTips {

	public static void main(String[] args) {
		String name = "zubair";
		
		
		intToStringConversion();
		intArrToList();
		arrayIsAnObject();
	}

	private static void arrayIsAnObject() {
		System.out.println("Class name for 1D int array: " + (new int[1]).getClass().getName());
		System.out.println("Class name for 2D long array: " + (new long[1][1]).getClass().getName());
		System.out.println("Class name for 1D bool array: " + (new boolean[1]).getClass().getName());
		System.out.println("=========================================");
	}

	private static void intArrToList() {
		int arr[] = { 2, 3, 4, 5 };
		System.out.println("> int[] to List conversion by indexed assignment");
		System.out.println(Arrays.asList(arr[0], arr[1], arr[2], arr[3]));
		System.out.println("> int[] to List conversion directly using stream");
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		System.out.println("=========================================");
	}

	private static void intToStringConversion() {
		System.out.println("> int to string conversion");
		System.out.print(1 + 2 + "");
		System.out.print(" is not same as ");
		System.out.println("" + 1 + 2);
		System.out.println("=========================================");
	}

}
