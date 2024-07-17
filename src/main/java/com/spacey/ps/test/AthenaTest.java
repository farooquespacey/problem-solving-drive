package com.spacey.ps.test;

/**
 * @author Farooque
 */
public class AthenaTest {
    
    static int findMaxBalanced(String inp) {
        int traversal = 0, startAt = 0, max = 0;
        for (int i=0; i<inp.length(); i++) {
            char c = inp.charAt(i);
            if (c == '[') {
                traversal++;
            } else {
                traversal--;
            }
            if (traversal < 0) {
                traversal = 0;
                startAt = i+1;
            } else {
                max = Math.max(max, (i-startAt+1) - traversal);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxBalanced("][][[[]]]][[]]]"));
        System.out.println(findMaxBalanced("[[[]]"));
        System.out.println(findMaxBalanced("[[["));
        System.out.println(findMaxBalanced("]]]"));
    }
}
