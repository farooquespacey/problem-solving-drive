package com.spacey.ps.hrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Function Description
 * 
 * Complete the circularArrayRotation function in the editor below.
 * 
 * circularArrayRotation has the following parameter(s):
 * 
 * int a[n]: the array to rotate
 * 
 * int k: the rotation count
 * 
 * int queries[1]: the indices to report
 * 
 * Returns
 * 
 * int[q]: the values in the rotated
 * 
 * 
 * Sample Input 0
 * 
 * 3 2 3
 * 
 * 1 2 3
 * 
 * 0
 * 
 * 1
 * 
 * 2
 * 
 * Sample Output 0
 * 
 * 2
 * 
 * 3
 * 
 * 1
 * 
 * 
 * @author Spacey4uq
 *
 */
public class _030_CircularArrayRotation {

	// Complete the circularArrayRotation function below.
	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int len = a.length;
		int[] newArr = new int[len];
		for (int i = 0; i < a.length; i++) {
			newArr[(i + k) % len] = a[i];
		}
		return newArr;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] nkq = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nkq[0]);

		int k = Integer.parseInt(nkq[1]);

		int q = Integer.parseInt(nkq[2]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] queries = new int[q];

		for (int i = 0; i < q; i++) {
			int queriesItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			queries[i] = queriesItem;
		}

		int[] result = circularArrayRotation(a, k, queries);

		for (int i = 0; i < result.length; i++) {
			System.out.print(String.valueOf(result[i]));
			if (i != result.length - 1) {
				System.out.println();
			}
		}

		System.out.println("\n=============");
		for (int i = 0; i < q; i++) {
			System.out.println(result[queries[i]]);
		}

		System.out.println();
		scanner.close();
	}
}
