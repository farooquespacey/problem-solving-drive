package com.spacey.ps.dsa.algo.dp;

import java.util.Arrays;

/**
 * Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the
 * number of possible decodings of the given digit sequence.
 * 
 * Examples:
 * 
 * Input: digits[] = "121"; Output: 3
 * 
 * // The possible decodings are "ABA", "AU", "LA"
 * 
 * Input: digits[] = "1234"; Output: 3
 * 
 * // The possible decodings are "ABCD", "LCD", "AWD"
 * 
 * An empty digit sequence is considered to have one decoding. It may be assumed
 * that the input contains valid digits from 0 to 9 and there are no leading
 * 0’s, no extra trailing 0’s, and no two or more consecutive 0’s.
 * 
 * @author Spacey4uq
 *
 */
public class _015_CountPossibleDecodingsOfDigitSequence {

	// TODO: add memoization technique(DP)
	static int decodingWays(char[] digits) {
		int len = digits.length;
		if(len == 0 || len == 1) return 1;
		int count = 0;
		if(digits[len - 1] > '0') 
			count = decodingWays(Arrays.copyOfRange(digits, 0, len - 1));
		if(digits[len - 2] == '1' || (digits[len - 2] == '2' && digits[len - 1] < '7'))
			count += decodingWays(Arrays.copyOfRange(digits, 0, len - 2));
		return count;
	}

	public static void main(String[] args) {
//		System.out.println((char)65);
		System.out.println(decodingWays(new char[] { '1', '2', '3', '4' }));
		System.out.println(decodingWays(new char[] { '7', '6' }));
	}

}
