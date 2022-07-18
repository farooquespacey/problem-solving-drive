package com.spacey.ps.test;

/*
 * CB
 * Given a string s, the task is to find out the minimum no of adjacent swaps required to make string s palindrome. If it is not possible, then return -1.
	Examples:

    Input: aabcb
     
    Output: 3 
    
    Explanation: 
    
    After 1st swap: abacb 
    
    After 2nd swap: abcab 
    
    After 3rd swap: abcba
    
    
    Input: adbcdbad 
    
    Output: -1 

 */
public class MinSwapToMakePalindrome {

	// Function to Count minimum swap
	static int countSwap(String str) {
		int count = 0;
		char[] inp = str.toCharArray();
		int n=inp.length;
		
		for(int i=0; i<n/2; i++) {
			int left = i;
			int right = n-left-1;
			
			while(left < right) {
				if(inp[left]==inp[right]) {
					break;
				} else {
					right--;
				}
			}
			System.out.println(left + ":" + right);
			if(left==right) {
				return -1;
			} else {
				for(int j=right; j<n-left-1; j++) {
					char tmp = inp[j];
					inp[j] = inp[j+1];
					inp[j+1] = tmp;
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
        String s = "geefksgeeks";
        
        // Function calling
        int ans1 = countSwap(s);
       
        StringBuilder sb=new StringBuilder(s);  
        sb.reverse();  
        s = sb.toString();  
 
        int ans2 = countSwap(s);
        if(ans1 > ans2)
          System.out.println(ans1);
        else
          System.out.println(ans2);
	}

}
