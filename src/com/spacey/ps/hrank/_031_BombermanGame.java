//package com.spacey.ps.hrank;
//
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;
//
//public class _031_BombermanGame {
//
//	// Complete the bomberMan function below.
////	static String[] bomberMan(int n, String[] grid) {
////		int iterFor = (n - 1) / 2;
////		String[] currentState = grid;
////		while (iterFor != 0) {
////			String[] newState = new String[grid.length];
////			for (int i = 0; i < grid.length; i++) {
////				String row = grid[0];
////				StringBuilder sb = new StringBuilder(row.length());
////				for (int j = 0; j < row.length(); j++) {
////					if(currentState[i].charAt(j) == 'O') {
////						sb.setCharAt(index, ch);
////					}
////				}
////			}
////			iterFor--;
////		}
////	}
//
//	private static final Scanner scanner = new Scanner(System.in);
//
//	public static void main(String[] args) throws IOException {
//		String[] rcn = scanner.nextLine().split(" ");
//
//		int r = Integer.parseInt(rcn[0]);
//
//		int c = Integer.parseInt(rcn[1]);
//
//		int n = Integer.parseInt(rcn[2]);
//
//		String[] grid = new String[r];
//
//		for (int i = 0; i < r; i++) {
//			String gridItem = scanner.nextLine();
//			grid[i] = gridItem;
//		}
//
//		String[] result = bomberMan(n, grid);
//
//		for (int i = 0; i < result.length; i++) {
//			System.out.print(result[i]);
//
//			if (i != result.length - 1) {
//				System.out.println();
//			}
//		}
//
//		System.out.println();
//		scanner.close();
//	}
//}
