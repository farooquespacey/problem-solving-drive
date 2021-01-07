package com.spacey.ps.hearth;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PickTopMovies {

	public static void main(String[] args) {
		int[][] movieAndRatings = { { 5, 7 }, { 9, 10 }, { 1, 6 }, { 2, 7 }, { 3, 10 }, { 4, 3 }, { 10, 8 }, { 11, 6 },
				{ 9, 1 }, { 6, 8 }, { 7, 8 }, { 5, 3 }, { 8, 9 }, { 10, 8 }, { 11, 2 } };
		pickTopN(movieAndRatings, 5);
	}

	private static void pickTopN(int[][] movieAndRatings, int n) {
		Map<Integer, RatingByUser> movieToRatings = new HashMap<>();
		for (int i = 0; i < movieAndRatings.length; i++) {
			int movie = movieAndRatings[i][0];
			int rate = movieAndRatings[i][1];
			movieToRatings.compute(movie, (m, r) -> r == null ? (new RatingByUser(rate, 1)) : r.rated(rate));
		}
		// sort by key automatically
		TreeMap<Integer, RatingByUser> sortedByKey = new TreeMap<>(movieToRatings);
		System.out.println("I. Sorted by Key: " + sortedByKey);
		// sort by any nature
		List<Map.Entry<Integer, RatingByUser>> sortedByAny = new LinkedList<Map.Entry<Integer, RatingByUser>>(
				movieToRatings.entrySet());
		Collections.sort(sortedByAny, (o1, o2) -> Integer.compare(o1.getKey(), o2.getKey()));
		System.out.println("II. Sorted by Key: " + sortedByAny);
		Collections.sort(sortedByAny, (o1, o2) -> Integer.compare(o1.getValue().avg(), o2.getValue().avg()));
		System.out.println("II. Sorted by Value(Rating): " + sortedByAny);
	}

	static class RatingByUser {
		int rate;
		int numUsersRated;

		public RatingByUser(int rate, int numUsersRated) {
			this.rate = rate;
			this.numUsersRated = numUsersRated;
		}

		public RatingByUser rated(int rate) {
			this.rate += rate;
			numUsersRated++;
			return this;
		}

		public int avg() {
			return rate / numUsersRated;
		}

		@Override
		public String toString() {
			return "" + avg();
		}

	}
}
