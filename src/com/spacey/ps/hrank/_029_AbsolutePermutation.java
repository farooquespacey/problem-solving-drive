package com.spacey.ps.hrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class _029_AbsolutePermutation {

	// Complete the absolutePermutation function below.
	static int[] absolutePermutation(int n, int k) {
		if (k == 0) {
			int[] newN = new int[n];
			for (int i = 1; i <= n; i++) {
				newN[i - 1] = i;
			}
			return newN;
		}
		if (n % (k * 2) != 0) {
			return new int[] { -1 };
		} else {
			int[] newN = new int[n];
			for (int i = 0; i < n; i++) {
				int n1 = i % (k * 2);
				if (n1 < k) {
					newN[i] = (i+1) + k;
				} else {
					newN[i] = (i+1) - k;
				}
			}
			return newN;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int tItr = 0; tItr < t; tItr++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);

			int[] result = absolutePermutation(n, k);

			for (int i = 0; i < result.length; i++) {
				System.out.print(String.valueOf(result[i]));

				if (i != result.length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		scanner.close();
	}
}
