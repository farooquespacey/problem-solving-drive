package com.spacey.ps.hrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class _019_MorganAndString {

	static int compare(String first, String second, int fP, int sP) {
		char fChar = first.charAt(fP);
		char sChar = second.charAt(sP);
		if (fChar == 'z') return 1;
		if (sChar == 'z') return -1;
		int comparison = Character.compare(fChar, sChar);
		return (comparison != 0) ? comparison : compare(first, second, fP + 1, sP + 1);
	}

	// Complete the morganAndString function below.
	static String morganAndString(String a, String b) {
		String first = a + "z";
		String second = b + "z";
		int fP = 0, sP = 0;
		StringBuilder finalOut = new StringBuilder();
		while (first.length() > fP && second.length() > sP) { // when either of the string ends
			char fChar = first.charAt(fP);
			char sChar = second.charAt(sP);
			int comp = compare(first, second, fP, sP);
			if (comp < 0) {
				finalOut.append(fChar); fP++;
			} else {
				finalOut.append(sChar); sP++;
			}
		}
		String output = finalOut.toString();
		if (fP == first.length()) {
			output += second.substring(sP);
		} else if (sP == second.length()) {
			output += first.substring(fP);
		}
		return output.replaceAll("z", "");
	}
//	static String morganAndString(String a, String b) {
//		String first = a + "z";
//		String second = b + "z";
//		StringBuilder sb = new StringBuilder();
//		int aPointer = 0;
//		int bPointer = 0;
//		boolean neighbourComparisonEnds = false;
//		while (first.length() > aPointer && second.length() > bPointer) {
//			char aChar = first.charAt(aPointer);
//			char bChar = second.charAt(bPointer);
//			int comparison = Character.compare(aChar, bChar);
//			if (comparison > 0) {
//				System.out.println("b wins: " + bChar);
//				sb.append(bChar);
//				bPointer++;
//			} else if (comparison < 0) {
//				System.out.println("a wins: " + aChar);
//				sb.append(aChar);
//				aPointer++;
//			} else {
//				System.out.println("both equals");
//				int tempAPointer = aPointer + 1;
//				int tempBPointer = bPointer + 1;
//				System.out.println(first.length() + "-" + second.length() + "----" + tempAPointer + "-" + tempBPointer);
//				System.out.println(aPointer + "-" + bPointer);
//				while (!neighbourComparisonEnds && first.length() > tempAPointer && second.length() > tempBPointer) {
//					char tempAChar = first.charAt(tempAPointer);
//					char tempBChar = second.charAt(tempBPointer);
//					int neighbourComparison = Character.compare(tempAChar, tempBChar);
//					if (neighbourComparison > 0) {
//						System.out.println("b wins with neighbour support: " + bChar);
//						sb.append(bChar);
//						bPointer++;
//						neighbourComparisonEnds = true;
//						break;
//					} else if (neighbourComparison > 0) {
//						System.out.println("a wins with neighbour support: " + aChar);
//						sb.append(aChar);
//						aPointer++;
//						neighbourComparisonEnds = true;
//						break;
//					} else {
//						tempAPointer++;
//						tempBPointer++;
//						System.out.println("checking another neighbour (" + tempAPointer + "," + tempBPointer + ")");
//						neighbourComparisonEnds = false;
//					}
//				}
//				if (!neighbourComparisonEnds || (a.length()==aPointer) || (b.length()==bPointer)) {
//					System.out.println("big tie");
//					sb.append(aChar);
//					aPointer++;
//				}
//			}
//		}
//		if (aPointer == first.length() && bPointer == second.length()) {
//			System.out.println("len: a==b");
//			return sb.toString().replaceAll("z", "");
//		} else if (aPointer == first.length()) {
//			System.out.println("len: a<b");
//			return (sb.toString() + second.substring(bPointer)).replaceAll("z", "");
//		} else {
//			System.out.println("len: a>b");
//			return (sb.toString() + first.substring(aPointer)).replaceAll("z", "");
//		}
//	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String a = scanner.nextLine();

			String b = scanner.nextLine();

			String result = morganAndString(a, b);
			System.out.println(result);
		}

		scanner.close();
	}
}
