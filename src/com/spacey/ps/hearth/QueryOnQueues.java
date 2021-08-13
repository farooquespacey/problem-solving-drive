package com.spacey.ps.hearth;

import java.util.Arrays;

/**
 * PPL
 * 
 * You're given an array containing N integers and you have to answer K queries.
 * Each query contains an integer X which is the index of the i th ( 1 based
 * index) element of the queue
 * 
 * Write a program to determine the following for each query
 * 
 * The number of segments containing the index X as the leftmost or the
 * rightmost element. and the number at the index X is >= each element of the
 * first segment.
 * 
 * Example
 * 
 * Segment formation : You have 3 numbers 1, 2 and 3
 * 
 * The possible segments for 3 are [3], [3,2], [3,2,1]
 * 
 * The possible segments for 2 are [2], [2,1]
 * 
 * Sample Input
 * 
 * Sample input: 4 2 1 3 || 1 4
 * 
 * Sample output: 4 3
 * 
 * Sample input: 4 2 3 5 1 || 1 3
 * 
 * Sample output: 3 2
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
			System.out.println(aPrevGreatest[j] + "," + j + "," + aNextGreatest[j]);
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
		int[] res = solve(3, new int[] { 1, 2, 3 }, 2, new int[] { 2, 3 });
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		res = solve(5, new int[] { 4, 2, 3, 5, 1 }, 2, new int[] { 1, 3 });
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
