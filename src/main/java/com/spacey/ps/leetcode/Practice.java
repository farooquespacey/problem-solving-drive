package com.spacey.ps.leetcode;

import java.util.Arrays;
import java.util.List;

public class Practice {

    public static void main(String[] args) {
        System.out.println("001. Merge Sorted Array");
        int[] nums1 = new int[] {1,2,3,0,0,0};
        mergeSortedArray_001(nums1, new int[] {2,5,6}, 3, 3);
        System.out.println(asList(nums1));

        System.out.println("002. Remove Element");
        int[] nums = new int[] {3,2,2,3};
        System.out.println(removeElement_002(nums, 3));
        System.out.println(asList(nums));

        System.out.println("003. Remove Duplicate from Sorted array");
        nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDupsFromSortedArray_003(nums));
        System.out.println(asList(nums));

        System.out.println("004. Remove Duplicate from Sorted array II");
        nums = new int[] {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDupsFromSortedArrayII_004(nums, 2));
        System.out.println(asList(nums));

        System.out.println("006. Rotate Array");
        nums = new int[] {1,2,3,4,5,6,7};
        rotateArray_006(nums, 3);
        System.out.println(asList(nums));

        System.out.println("014. Product of Array except Self");
        nums = new int[] {1,2,3,4};
        System.out.println(asList(productOfArrayExceptSelfOptimized_014(nums)));
    }

    // Instead of auxiliary space (excluding the final ans) of O(n), this will use O(1)
    private static int[] productOfArrayExceptSelfOptimized_014(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);
        int curr = 1;
        for (int i=0; i<nums.length;i++) {
            answer[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i=nums.length-1; i>=0;i--) {
            answer[i] *= curr;
            curr *= nums[i];
        }
        return answer;
    }

    private static int[] productOfArrayExceptSelf_014(int[] nums) {
        int[] prefixes = new int[nums.length];
        int[] suffixes = new int[nums.length];
        int pre = 1, suf = 1;
        for (int i=0; i<nums.length;i++) {
            prefixes[i] = pre;
            pre *= nums[i];
        }
        for (int i=nums.length-1; i>=0;i--) {
            suffixes[i] = suf;
            suf *= nums[i];
        }
        int[] answer = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            answer[i] = prefixes[i] * suffixes[i];
        }
        return answer;
    }

    private static void rotateArray_006(int[] nums, int by) {
        int len = nums.length;
        by %= len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, by-1);
        reverse(nums, by, len-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    private static int removeDupsFromSortedArrayII_004(int[] nums, int atmostDupsAllowed) {
        // 0,0,1,1,1,1,2,3,3
        int k=2;
        for (int i=2; i<nums.length; i++) {
            if (nums[i] != nums[k-atmostDupsAllowed]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    private static void mergeSortedArray_001(int[] nums1, int[] nums2, int m, int n) {
        int i=m-1, j=n-1, k=nums1.length-1;
        while (i>=0 && j>=0) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
    }

    private static int removeElement_002(int[] nums, int e) {
        // 3,2,2,3
        int k=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != e) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    private static int removeDupsFromSortedArray_003(int[] nums) {
        // 0,0,1,1,1,2,2,3,3,4
        // o/p: 5
        int k=0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }

    private static List<Integer> asList(int[] nums) {
        return Arrays.stream(nums).boxed().toList();
    }

}
