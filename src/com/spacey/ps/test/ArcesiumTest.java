package com.spacey.ps.test;

import java.util.List;

public class ArcesiumTest {

	/**
	 * An inverted apple tree with two branches arising from each node is given.
	 * Basically a binary tree. An apple can be normal, nearly overhydrated or neary
	 * underhydrated. Penalties for overhydrated and underhydrated apple are given.
	 * You have to water just one node in tree such that the sum of overhydrated and
	 * underhydrated penalties for the whole tree is minimized. Input for tree is
	 * given in the form of a parent array and another array denotes the status of
	 * each of the apple node as 0 (neutral), -1 (under hydrated) and 1
	 * (overhydrated).
	 * 
	 * @author Night King
	 *
	 */
	static class HydrateNodes {
		static int minimumPouringWaterPenalty(List<Integer> parent, List<Integer> waterLevel, int overhydratedPenalty,
				int underhydratedPenalty) {

			return 0;
		}

		public static void main(String[] args) {

		}
	}

	static class PositiveProduct {
		static int maxLength(List<Integer> arr) {
			return 0;
		}

		public static void main(String[] args) {

		}
	}

	static class WeirdStock {
		static int findMinDays(int n, int m) {
//			int res = 0;
//			while(n < m) {
//		        m = m/2 < n ? m + 1 : m / 2;
//		        res++;
//			}
//			return res + (n-m);
			if (n == m) {
				return 0;
			}
			if (n > m) {
				return n - m;
			} else if (n * 2 == m) {
				return 1;
			} else if (n * 2 - 1 == m) {
				return 2;
			} else if (n * 2 > m) {
				return 1 + findMinDays(n - 1, m);
			} else {
				return 1 + findMinDays(n * 2, m);
			}
		}

		public static void main(String[] args) {
			System.out.println(findMinDays(6, 10));
		}
	}

}
