package com.spacey.ps.test;

import java.util.HashSet;
import java.util.Set;

/**
 * PPL
 * @author Night King
 *
 */
public class BeautifulNumbers {

	public static void main(String[] args) {
		System.out.println(solve(33,33));
	}

    static long solve(int l, int r){
        // Your code goes here
        long sum = 0;
        for(int start=l; start<=r; start++){
            long curr = start;
            if(becomesOne(curr, new HashSet<>())){
                sum += curr;
            }
        }
         return sum;
     }
	
	static boolean becomesOne(long curr, Set<Long> triedSoFar){
        long digit;
        long num = curr;
        long sumOfSquares = 0;
        while(num > 0){
            digit = num % 10;
            sumOfSquares += (digit*digit);
            num = num / 10;
        }
        System.out.println(sumOfSquares);
        if(sumOfSquares == 1) {
            return true;
        } else if(triedSoFar.contains(sumOfSquares)){
        	return false;
        }  else {
        	triedSoFar.add(sumOfSquares);
            return becomesOne(sumOfSquares, triedSoFar);
        }
    }
}
