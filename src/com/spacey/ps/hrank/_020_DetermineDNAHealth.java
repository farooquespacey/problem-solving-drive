package com.spacey.ps.hrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.sun.xml.internal.ws.util.StringUtils;

public class _020_DetermineDNAHealth {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] genes = new String[n];

		String[] genesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String genesItem = genesItems[i];
			genes[i] = genesItem;
		}

		int[] health = new int[n];

		String[] healthItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int healthItem = Integer.parseInt(healthItems[i]);
			health[i] = healthItem;
		}

		int s = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int sItr = 0; sItr < s; sItr++) {
			String[] firstLastd = scanner.nextLine().split(" ");

			int first = Integer.parseInt(firstLastd[0]);

			int last = Integer.parseInt(firstLastd[1]);

			String d = firstLastd[2];
			int totalHealth = getTotalHealth(genes, health, first, last, d);
			max = (max < totalHealth) ? totalHealth : max;
			min = (min > totalHealth) ? totalHealth : min;
		}
		System.out.println(min + " " + max);
		scanner.close();
	}

	private static int getTotalHealth(String[] genes, int[] health, int first, int last, String d) {

		int totalHealth = 0;
		for (int i = first; i <= last && genes.length == health.length; i++) {
			String tmp = d;
			while (tmp.contains(genes[i])) {
				tmp = tmp.substring(tmp.indexOf(genes[i]) + 1);
				totalHealth += health[i];
			}
		}
		return totalHealth;
	}

}
