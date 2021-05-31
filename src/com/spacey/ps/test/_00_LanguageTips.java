package com.spacey.ps.test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _00_LanguageTips {
	
	

	public static void main(String[] args) {
		int arr[] = {2,3,4,5};
		intToStringConversion();
		intArrToList(arr);
	}

	private static void intArrToList(int[] arr) {
		System.out.println("> int[] to List conversion by indexed assignment");
		System.out.println(Arrays.asList(arr[0], arr[1], arr[2], arr[3]));
		System.out.println("> int[] to List conversion directly using stream");
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
	}

	private static void intToStringConversion() {
		System.out.println("> int to string conversion");
		System.out.print(1 + 2 + "");
		System.out.print(" is not same as ");
		System.out.println("" + 1 + 2);
	}

}
