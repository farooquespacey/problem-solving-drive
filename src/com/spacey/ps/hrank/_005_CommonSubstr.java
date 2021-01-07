package com.spacey.ps.hrank;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class _005_CommonSubstr {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	String status = "NO";
    	List<String> fArr = new ArrayList(Arrays.asList(s1.split("")));
    	List<String> sArr = new ArrayList(Arrays.asList(s2.split("")));
    	List<String> lesser = fArr;
    	List<String> higher = sArr;
    	if(fArr.size() >= sArr.size()) {
    		lesser = sArr;
    		higher = fArr;
    	}
    	for(String fCurrent: higher) {
    		if(lesser.contains(fCurrent)) {
    			status = "YES";
    			break;
    		}
    	}
    	return status;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
        }


        scanner.close();
    }
}
