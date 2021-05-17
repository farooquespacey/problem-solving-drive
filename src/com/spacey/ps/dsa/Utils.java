package com.spacey.ps.dsa;

import java.util.Arrays;

/**
 * Common utils
 * 
 * @author Spacey4uq
 *
 */
public class Utils {
	public static void printArray(int[] inp) {
		Arrays.stream(inp).boxed().forEach(e -> System.out.print(e + ", "));
	}
}
