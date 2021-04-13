package com.spacey.ps.hrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class _002_LeftRotation {

	
/*
Input
5 4
1 2 3 4 5
*/
	// Complete the rotLeft function below.
//	static int[] rotLeft(int[] a, int d) {
//		int[] newArr = new int[a.length];
//		if(d > a.length) return new int[0];
//		for (int i = 0; i < a.length; i++) {
//			int newIx = (i+(a.length-d)) % a.length;
//			System.out.println("Moving " + i + " value into " + newIx);
//			newArr[newIx] = a[i];
//		}
//		return newArr;
//	}

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    // Write your code here
    	int[] a = arr.stream().mapToInt(i->i).toArray();
        Integer[] newArr = new Integer[a.length];
        if(d > a.length) return Arrays.asList();
        for (int i = 0; i < a.length; i++) {
            int newIx = (i+(a.length-d)) % a.length;
            System.out.println("Moving " + i + " value into " + newIx);
            newArr[newIx] = a[i];
        }
        return Arrays.asList(newArr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = _002_LeftRotation.rotateLeft(d, arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
