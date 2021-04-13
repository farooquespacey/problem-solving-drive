package com.spacey.ps.hrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class _003_MinSwap {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int i =0;
        int count=0;
        int temp;
        int  n = arr.length;
        while(i<n){
            if(arr[i] != i+1){
                temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1]=temp;
                count++;
            }
            else{
                i++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println(String.valueOf(res));

        scanner.close();    }
}

