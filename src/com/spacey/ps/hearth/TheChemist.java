package com.spacey.ps.hearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * PPL
 * @author Night King
 *
 */
public class TheChemist {

	// 0,1,2,2,7
	// 1,2,3,4,6
	static int solve(int desired_result, int n, int[] powers) {
		int closestDiff = Integer.MAX_VALUE;
		int sum = -1;
		Arrays.sort(powers);
		for (int i = n - 1; i > 0; i--) {
			int prev = i - 1;
			while (prev >= 0) {
				int subt = powers[i] - powers[prev];
				int addt = powers[i] + powers[prev];
				int diff = Math.abs(subt - desired_result);
				if (diff > closestDiff) {
					break;
				} else if (diff < closestDiff) {
					closestDiff = diff;
					sum = addt;
				} else if (diff == closestDiff) {
					if (sum > addt) {
						sum = addt;
					}
				}
				prev--;
			}
		}
		return sum;
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int desired_result = Integer.parseInt(br.readLine().trim());
         int n = Integer.parseInt(br.readLine().trim());
         int[] powers = new int[n];
         for(int i_powers = 0; i_powers < n; i_powers++)
         {
         	powers[i_powers] = Integer.parseInt(br.readLine());
         }

         int out_ = solve(desired_result, n, powers);
         System.out.println(out_);

         wr.close();
         br.close();
    }
	
//	public static void main(String[] args) {
//		int res = solve(5, 8, new int[] {2,1,4,2,3,2,2,6});
////		int res = solve(4, 5, new int[] { 2, 1, 0, 7, 2 });
//		System.out.println(res);
//	}

}
