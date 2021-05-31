package com.spacey.ps.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 2:
 * 
 * Input: l1 = [0], l2 = [0] Output: [0]
 * 
 * Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 
 * 0 <= Node.val <= 9
 * 
 * It is guaranteed that the list represents a number that does not have leading
 * zeros.
 * 
 * 
 * @author Spacey4uq
 *
 */
public class _007_AddTwoNumbersFromLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	static void printList(ListNode l) {
		while (l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9, new ListNode(0, new ListNode(3)));
		ListNode l2 = new ListNode(3, new ListNode(5, new ListNode(4)));
		printList(addTwoNumbers(l1, l2));
	}

}
