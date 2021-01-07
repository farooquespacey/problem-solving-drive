package com.spacey.ps.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpaceAllotment2 {
	static class ParkTime {
		long start;
		long end;

		ParkTime(long start, long end) {
			this.start = start;
			this.end = end;
		}

		// cases: -_-, _-_, -_-_, _-_-
		public boolean overlaps(ParkTime other) {
			return (start >= other.start && end <= other.end) || (start <= other.start && end >= other.end)
					|| (start > other.start && start < other.end && end > other.end)
					|| (start < other.start && end > other.start && end < other.end);
		}

		public boolean overlapsAny(List<ParkTime> parkTimes) {
			return parkTimes.stream().anyMatch(this::overlaps);
		}

		@Override
		public String toString() {
			return "(" + start + "," + end + ")";
		}
	}

	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		// YOUR CODE HERE
		Map<Integer, List<ParkTime>> spotsToParkTimes = new HashMap<>();
		for (int i = 0; i < parkingStartEndTimes.length; i++) {
			int start = parkingStartEndTimes[i][0];
			int end = parkingStartEndTimes[i][1];
			ParkTime newParkTime = new ParkTime(start, end);
			int spaceToUse = 0; // 0 for new spot allotment
			for (Integer existingSpot : spotsToParkTimes.keySet()) {
				if (!newParkTime.overlapsAny(spotsToParkTimes.get(existingSpot))) {
					spaceToUse = existingSpot;
					break;
				}
			}
			spaceToUse = (spaceToUse == 0) ? spotsToParkTimes.size() + 1 : spaceToUse;
			spotsToParkTimes.compute(spaceToUse, (k, v) -> {
				List<ParkTime> parkTimes = (v == null) ? new ArrayList<>() : v;
				parkTimes.add(newParkTime);
				return parkTimes;
			});
		}
		return spotsToParkTimes.size();
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}