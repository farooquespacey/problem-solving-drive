package com.spacey.ps.hrank;

/**
 * Watson likes to challenge Sherlock's math ability. He will provide a starting
 * and ending value that describe a range of integers, inclusive of the
 * endpoints. Sherlock must determine the number of square integers within that
 * range.
 * 
 * Note: A square integer is an integer which is the square of an integer, e.g.
 * 1,4,9,16,25.
 * 
 * Example: a = 24, b = 49
 * 
 * There are three square integers in the range: 25, 36 and 49. Return 3.
 * 
 * @author Spacey4uq
 *
 */
public class _035_SherlockSquares {

	// Complete the squares function below.
	static int squares(int a, int b) {
		int total = 0;
		int lowest = (int) Math.sqrt(a);
		if (lowest * lowest == a) {
			total++;
		}
		while ((++lowest * lowest) <= b)
			total++;
		return total;
	}

	static int squares2(int a, int b) {
		int total = 0;
		int x = (int) Math.ceil(Math.sqrt(a));
		int y = (int) Math.floor(Math.sqrt(b));
		int square_count = y - x + 1;
		System.out.println(square_count);
		return total;
	}

	public static void main(String[] args) {
		System.out.println(squares(4, 25));
	}

}
