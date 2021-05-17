package com.spacey.ps.hearth;

import java.util.Arrays;

/**
 * PPL
 * 
 * @author Night King
 *
 */
public class QueryOnQueues {

	static int[] solve(int n, int[] a, int k, int[] queries) {
		int[] res = new int[queries.length];
		int[] aPrevGreatest = new int[a.length];
		int[] aNextGreatest = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int prevIdx, nextIdx;
			for (prevIdx = i - 1; prevIdx >= 0; prevIdx--) {
				if (a[i] < a[prevIdx]) {
					aPrevGreatest[i] = prevIdx;
					break;
				}
			}
			if (prevIdx < 0) {
				aPrevGreatest[i] = -1;
			}
			for (nextIdx = i + 1; nextIdx < a.length; nextIdx++) {
				if (a[i] < a[nextIdx]) {
					aNextGreatest[i] = nextIdx;
					break;
				}
			}
			if (nextIdx == a.length) {
				aNextGreatest[i] = a.length;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			int j = queries[i] - 1;
			System.out.println(j + "," + aPrevGreatest[j] + "," + aNextGreatest[j]);
			res[i] = (j - aPrevGreatest[j] - 1) + (aNextGreatest[j] - j - 1) + 1;
		}
		return res;
	}

	static int[] Solve(int N, int[] A, int K, int[] Queries) {
		int[] res = new int[Queries.length];
		int[] ks = new int[Queries.length];
		for (int i = 0; i < Queries.length; i++) {
			ks[i] = A[Queries[i] - 1];
		}
		Arrays.sort(A);
		for (int q = 0; q < Queries.length; q++) {
			int valToCheck = ks[q];
			int idx = 0;
			while (A[idx] != valToCheck) {
				idx++;
			}
			res[q] = idx + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] res = solve(4, new int[] { 1,2,3 }, 2, new int[] { 2,3 });
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		res = solve(4, new int[] { 4, 2, 3, 5, 1 }, 2, new int[] { 1, 3 });
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
