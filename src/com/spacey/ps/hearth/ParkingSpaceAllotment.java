package com.spacey.ps.hearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WSN
 * @author Night King
 *
 */
public class ParkingSpaceAllotment {

	class ParkTime {
		int start;
		int end;

		ParkTime(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public boolean overlaps(ParkTime other) {
			return (start > other.start && end < other.end) || (start < other.start && end > other.end)
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

	public void allot(int[][] parkedTimes) {
		Map<Integer, List<ParkTime>> spotsToParkTimes = new HashMap<>();
		for (int i = 0; i < parkedTimes.length; i++) {
			int start = parkedTimes[i][0];
			int end = parkedTimes[i][1];
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
		System.out.println(spotsToParkTimes);
	}

	public static void main(String[] args) {
		int[][] parkedTimes = { { 5, 15 }, { 0, 20 }, { 25, 40 }, { 35, 50 }, { 20, 25 }, { 0, 5 }, { 40, 45 } };
		new ParkingSpaceAllotment().allot(parkedTimes);
	}

}
