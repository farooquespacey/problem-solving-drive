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

public class _016_NonDivisibleSubset {
	static class Result {

		/*
		 * Complete the 'nonDivisibleSubset' function below.
		 *
		 * The function is expected to return an INTEGER. The function accepts following
		 * parameters: 1. INTEGER k 2. INTEGER_ARRAY s
		 */

		/*
		 * Look for solution here or below: https://github.com/naskio/Hackerrank-Non-Divisible-Subset/blob/master/Solution.java
		 */
		public static int nonDivisibleSubsetMine(int k, List<Integer> s) {
			// Write your code here
			int max = 0;
			List<Integer> maxSubset = new ArrayList<>();
			for (int i = 0; i < s.size(); i++) {
				int curr = s.get(i);
				int otherIdx = 0;
				maxSubset.add(curr);
				while (otherIdx < s.size()) {
					if(i == otherIdx)
						continue;
					int next = s.get(otherIdx);
					boolean skipAdd = maxSubset.stream().anyMatch(e -> (e + next) % k == 0);
					if (!skipAdd)
						maxSubset.add(next);
					otherIdx++;
				}
				max = maxSubset.size() > max ? maxSubset.size() : max;
				maxSubset = new ArrayList<>();
			}
			return max;
		}
		
		static int nonDivisibleSubset(int k, List<Integer> s) {
	        int[] remains=new int[k];
	        for (int i=0;i<s.size();i++){
	            remains[s.get(i)%k]++;
	        }
	        for(int i=0;i<remains.length;i++) {
	        	System.out.print(remains[i]+ ", ");
	        }
	        System.out.println();
	        int result=0;
	        if (remains[0]>0){ // if atleast one input is completely divisible
	            result++;
	        }
	        for (int i=1;i<remains.length;i++){
	            if(i==(k-i)){
	                result++;
	            }else {
	                if (remains[i]>=remains[k-i]){
	                    result+=remains[i];
	                }else {
	                    result+=remains[k-i];
	                }
	                remains[i]=0;
	                remains[k-i]=0;
	            }
	        }
	        return result;
	    }


	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = Result.nonDivisibleSubset(k, s);

		System.out.print(String.valueOf(result));
		System.out.println();

		bufferedReader.close();
	}
}
