package com.spacey.ps.test;

import java.util.*;

public class ZohoTest {
    
    static void printCharsSuffixTimes(String input) {
        StringBuilder res = new StringBuilder();
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                StringBuilder numBuilder = new StringBuilder();
                int j = i+1;
                while (j < input.length() && Character.isDigit(input.charAt(j))) {
                    numBuilder.append(input.charAt(j));
                    j++;
                }
                int dig = Integer.parseInt(numBuilder.toString());
                for (int k=0; k<dig; k++) {
                    res.append(c);
                }
                i=j-1;
            }
        }
        System.out.println(res.toString());
    }


    static void sortOddInDescAndEvenInAsc(int[] nums) {
        // extract even and odd elements in two separate arrays, sort them and put them back
    }
    
    static void printDiamond(String inp) {
        int len = inp.length();
        for (int left=0; left<len; left++) {
            int right = len-1-left;
            char[] line = new char[len];
            Arrays.fill(line, ' ');
            line[left] = inp.charAt(left);
            line[right] = inp.charAt(right);
            System.out.println(new String(line));
        }
    }

    static void mergeSortedArrayWithNoDups(int[] nums1, int[] nums2) {
        int i=0, j=0, k=0;
        int[] merged = new int[nums1.length + nums2.length]; // or better use ArrayList
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] == nums2[j]){
                merged[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i];
                i++;
            } else {
                merged[k++] = nums2[j];
                j++;
            }
        }
        while (i<nums1.length) merged[k++] = nums1[i++];
        while (j<nums2.length) merged[k++] = nums2[j++];
        System.out.println(Arrays.toString(merged));
    }

    static void reverseWithRecursion(String inp) {
        System.out.println(reverseHelper(inp, ""));
    }

    static String reverseHelper(String inp, String prev) {
        if (inp.length() == 0) return prev;
        
        int i=0;
        while (i<inp.length() && !Character.isSpaceChar(inp.charAt(i))) i++;
        return reverseHelper(i<inp.length() ? inp.substring(i+1):"", inp.substring(0, i) + " " + prev);
    }

    static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }

    // helper function checks if string s contains valid parantheses
    static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
    
    public static void main(String[] args) {
        printCharsSuffixTimes("b3c6d15"); // bbbccccccddddddddddddddd
        sortOddInDescAndEvenInAsc(new int[]{13, 2, 4, 15, 12, 10, 5}); // 13,2,12,10,5,15,4
        printDiamond("geeksforgeeks"); // input will always be in odd length
        mergeSortedArrayWithNoDups(new int[]{2, 4, 5, 6, 7, 9, 10, 13}, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 11, 15}); // 2,3,4,5,6,7,8,9,10,11,13,15 
        reverseWithRecursion("one two three"); // three two one
        System.out.println(removeInvalidParentheses("()())"));
    }

}
