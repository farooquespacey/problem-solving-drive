package com.spacey.ps.leetcode;

import java.util.*;

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

        System.out.println("021. Zig Zag Conversion");
        System.out.println(zigZagConversion_021("PAYPALISHIRING", 4));

        System.out.println("042. Linked list cycle");
        Node<Integer> linkedList = new Node<>(3, new Node<>(2, new Node<>(0, new Node<>(-4))));
        linkedList.next.next.next.next = linkedList; // cyclic
        System.out.println(linkedListCycle(linkedList));

        System.out.println("043. Add Two numbers");
        Node<Integer> linkedList1 = new Node<>(9, new Node<>(9, new Node<>(9)));
        Node<Integer> linkedList2 = new Node<>(9, new Node<>(9, new Node<>(9)));
        System.out.println(addTwoNumbers_043(linkedList1, linkedList2));

        System.out.println("044. Merge Two sorted lists");
        linkedList1 = new Node<>(1, new Node<>(2, new Node<>(5)));
        linkedList2 = new Node<>(1, new Node<>(3, new Node<>(4)));
        System.out.println(mergeTwoSortedLists_044(linkedList1, linkedList2));

        // TODO: more of linked list problems
        
        System.out.println("054. Kth Largest Element in an Array");
        nums = new int[] {3,2,1,5,60,4};
        System.out.println(kthLargestElemInArray_054(nums, 2));
        System.out.println(kthSmallestElemInArray_054(nums, 2));
    }

    private static int kthSmallestElemInArray_054(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pQ.add(num);
            if (pQ.size() > k) {
                pQ.poll();
            }
        }
        return pQ.peek();
    }

    private static int kthLargestElemInArray_054(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i=0; i<nums.length; i++)  {
            pQ.add(nums[i]);
            if (pQ.size() > k) {
                pQ.poll();
            }
        }
        return pQ.peek();
    }

    private static Node<Integer> mergeTwoSortedLists_044(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummyHead = new Node<>(-1);
        Node<Integer> tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummyHead.next;
    }

    private static Node<Integer> addTwoNumbers_043(Node<Integer> l1, Node<Integer> l2) {
        int carry = 0;
        Node<Integer> dummyHead = new Node<>(-1);
        Node<Integer> tail = dummyHead;
        while (l1 != null || l2 != null || carry != 0) {
            int a = (l1 != null) ? l1.data : 0;
            int b = (l2 != null) ? l2.data : 0;
            int sum = a + b + carry;
            int digit = sum % 10;
            carry = sum / 10;
            tail.next = new Node<>(digit);
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        Node<Integer> result = dummyHead.next;
        dummyHead.next = null; // good practice
        return result;
    }

    private static boolean linkedListCycle(Node<Integer> head) {
        Node<Integer> slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            List<T> o = new ArrayList<>();
            Node<T> l = this;
            while (l != null) {
                o.add(l.data);
                l = l.next;
            }
            return "" + o;
        }
    }

    private static String zigZagConversion_021(String inp, int numRows) {
        List<Character>[] rows = new ArrayList[numRows];
        for (int i=0; i<numRows; i++)
            rows[i] = new ArrayList<>();
        int idx = 0, dir = 1;
        for (char c: inp.toCharArray()) {
            rows[idx].add(c);
            if (idx == 0) dir = 1;
            else if (idx == numRows-1) dir = -1;
            idx += dir;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> lOfC: rows) {
            for (Character c: lOfC) {
                sb.append(c);
            }
        }
        return sb.toString();
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
