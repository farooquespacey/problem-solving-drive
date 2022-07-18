package com.spacey.ps.test;

public class CalculateAngeleBetweenHourNMin {

	// Function to calculate the angle
	static int calcAngle(double h, double m) {
		// validate the input
		if (h < 0 || m < 0 || h > 12 || m > 60)
			System.out.println("Wrong input");

		if (h == 12)
			h = 0;
		if (m == 60) {
			m = 0;
			h += 1;
			if (h > 12)
				h = h - 12;
		}

		// Calculate the angles moved by hour and minute hands
		// with reference to 12:00
		int minute_angle = (int) (6 * m); // as 1m == 6deg
		int hour_angle = (int) (30 * (h + (m / 60))); // as 1h == 30deg
//		int hour_angle = (int) (0.5 * (h * 60 + m));


		// Find the difference between two angles
		int angle = Math.abs(hour_angle - minute_angle);

		// smaller angle of two possible angles
		angle = Math.min(360 - angle, angle);

		return angle;
	}

	public static void main(String[] args) {
		System.out.println(calcAngle(12, 60) + " degree"); // 30 degree
		System.out.println(calcAngle(9, 60) + " degree");// 60 degree
		System.out.println(calcAngle(3, 30) + " degree");// 75 degree
		System.out.println(calcAngle(3, 47) + " degree");// 169 degree
	}

}
