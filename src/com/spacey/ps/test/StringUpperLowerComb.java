package com.spacey.ps.test;

import java.util.*;

public class StringUpperLowerComb {
	public static void printArray(char a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}

	public static void printAll(char a[], int l, int r) {
		if (l == r) {
			printArray(a);
			return;
		}

		a[l] = Character.toUpperCase(a[l]);
		printAll(a, l + 1, r);
		a[l] = Character.toLowerCase(a[l]);
		printAll(a, l + 1, r);

	}

	public static void main(String args[]) {

		String str = "the";
		char a[] = str.toCharArray();

		printAll(a, 0, a.length);

	}

}