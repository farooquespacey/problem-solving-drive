package com.spacey.ps.hearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * WSN
 * @author Night King
 *
 */
public class PickTopApps {

	public static class UserRating {
		private int rate;
		private int numUsersRated;

		public UserRating(int rate, int numUsersRated) {
			this.rate = rate;
			this.numUsersRated = numUsersRated;
		}

		public UserRating rated(int rate) {
			this.rate += rate;
			numUsersRated++;
			return this;
		}

		public double avg() {
			return (double) rate / getNumUsersRated();
		}
		
		public int getNumUsersRated() {
			return numUsersRated;
		}

		@Override
		public String toString() {
			return "" + avg();
		}

	}

	public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {
		Map<String, UserRating> appToUserRating = new HashMap<>();

		@Override
		public void putNewRating(String app, int rating) {
			// YOUR CODE HERE
			appToUserRating.compute(app, (theApp, theUserRating) -> theUserRating == null ? (new UserRating(rating, 1))
					: theUserRating.rated(rating));
		}

		@Override
		public double getAverageRating(String app) {
			// YOUR CODE HERE
			return appToUserRating.get(app).avg();
		}

		@Override
		public int getRatingsCount(String app) {
			// YOUR CODE HERE
			return appToUserRating.get(app).getNumUsersRated();
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface RatingStatisticsCollector {
		// Ratings feed will call this method when new app rating information is
		// received. This is input to your class. ratings is a non negative integer
		// between 0 to 10.
		public void putNewRating(String app, int rating);

		// Report the average rating of the app.
		public double getAverageRating(String app);

		// Report the total number of rating for an app.
		public int getRatingsCount(String app);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numLines = Integer.parseInt(scanner.nextLine());
		int currentLine = 0;
		while (currentLine++ < numLines) {
			final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
			final Set<String> apps = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			for (int i = 0; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String app = tokens[0];
				apps.add(app);
				final int runs = Integer.parseInt(tokens[1]);

				stats.putNewRating(app, runs);

			}

			for (String app : apps) {
				System.out.println(
						String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
			}

		}
		scanner.close();

	}
}