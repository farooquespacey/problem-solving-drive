package com.spacey.ps.test;

import java.util.Arrays;

public class MinNbPlatformsRequiredForRailway {
	
	// Returns minimum number of platforms required
	public static int findPlatform(int arr[], int dep[], int n) {
		// plat_needed indicates number of platforms
		// needed at a time
		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		// run a nested loop to find overlap
		for (i = 0; i < n; i++) {
			// minimum platform
			plat_needed = 1;

			for (j = i + 1; j < n; j++) {
				// check for overlap
				if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i]))
					plat_needed++;
			}
			// update result
			result = Math.max(result, plat_needed);
			System.out.println(plat_needed + ","  + result);
		}

		return result;
	}
	
	// Returns minimum number of platforms required
	// 
    static int findPlatformEfficient(int arr[], int dep[], int n)
    {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
 
        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
 
        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n) {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }
 
            // Else decrement count of platforms needed
            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
 
            // Update result if needed
            if (plat_needed > result)
                result = plat_needed;
        }
 
        return result;
    }

	public static void main(String[] args) {
//        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
//        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int arr[] = { 1, 4 };
        int dep[] = { 3, 5 };
        int n = 2;
		System.out.println(findPlatformEfficient(arr, dep, n));
	}

}
