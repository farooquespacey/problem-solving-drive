package com.spacey.ps.hrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class _034_AlmostSorted {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
    	int n = arr.length;
    	if(n < 2 || isAsc(arr)) {
    		System.out.println("Yes");
    		return;
    	}
    	
    	int start, end;
    	for(start=0; start<arr.length-1 && arr[start]<arr[start+1]; start++);
    	for(end=n-1; end>0 && arr[end-1]<arr[end]; end--);
    	
    	// try swapping
    	swap(arr, start, end);
    	if(isAsc(arr)) {
    		System.out.println("yes\nswap " + (start+1) + " " + (end+1));
    		return;
    	}
    	
    	// try reversing
    	int x=start+1; int y=end-1;
    	while(x < y) swap(arr, x++, y--);
    	if(isAsc(arr)) {
    		System.out.println("yes\nreverse " + (start+1) + " " + (end+1));
    	} else {
    		System.out.println("no");
    	}
    }
    

    private static void swap(int[] arr, int start, int end) {
    	int tmp = arr[start];
    	arr[start] = arr[end];
    	arr[end] = tmp;
	}


	private static boolean isAsc(int[] arr) {
    	for(int i=0; i<arr.length-1; i++) {
    		if(arr[i] > arr[i+1]) {
    			return false;
    		}
    	}
    	return true;
	}


	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
