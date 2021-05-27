package com.spacey.ps.test;

import java.util.Stack;

public class NextGreaterNumberOfQQueries {

	// time = O(n^2), space = O(1)
	static int[] nextGreater(int[] A, int[] Q) {
		int out[] = new int[Q.length];
		for (int i = 0; i < Q.length; i++) {
			int queryIdx = Q[i];
			int queryNum = A[queryIdx];
			int nextGreater = -1;
			for (int j = queryIdx + 1; j < A.length; j++) {
				if (queryNum < A[j]) {
					nextGreater = A[j];
					break;
				}
			}
			out[i] = nextGreater;
		}
		return out;
	}

	static int[] nextGreaterUsingStack(int arr[], int query[]) {
		int ans[] = new int[arr.length];// this array contains
		// the next greatest
		// elements of all the elements
		Stack<Integer> elemsNotHavingAnyGreater = new Stack<>();
		// push the 0th index
		// to the stack
		elemsNotHavingAnyGreater.push(arr[0]);
		int j = 0;
		// traverse rest
		// of the array
		for (int i = 1; i < arr.length; i++) {
			int next = arr[i];

			if (!elemsNotHavingAnyGreater.isEmpty()) {
				// get the topmost
				// element in the stack
				int element = elemsNotHavingAnyGreater.pop();

				/*
				 * If the popped element is smaller than next, then a) store the pair b) keep
				 * popping while elements are smaller and stack is not empty
				 */
				while (next > element) {
					System.out.println("j=>" + j + " is assigned " + next);
					ans[j] = next;
					j++;
					if (elemsNotHavingAnyGreater.isEmpty())
						break;
					element = elemsNotHavingAnyGreater.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next)
					elemsNotHavingAnyGreater.push(element);
			}
			/*
			 * push next to stack so that we can find next greater for it
			 */
			elemsNotHavingAnyGreater.push(next);
		}
		/*
		 * After iterating over the loop, the remaining elements in stack do not have
		 * the next greater element, so -1 for them
		 */
		while (!elemsNotHavingAnyGreater.isEmpty()) {
			int element = elemsNotHavingAnyGreater.pop();
			ans[j] = -1;
			j++;
		}

		// return the next
		// greatest array
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
		int query[] = { 3, 6, 1 };
		int[] out = nextGreater(arr, query);
		System.out.println(out[0] + " " + out[1] + " " + out[2]);
		// OR using Stack:
//		int arr[] = {4,3,2,7};
//		int query[] = {0,1,2};
//		int[] out = nextGreaterUsingStack(arr, query);
//		System.out.println(out[query[0]] + " " + out[query[1]] + " " + out[query[2]]);
		
	}

}
