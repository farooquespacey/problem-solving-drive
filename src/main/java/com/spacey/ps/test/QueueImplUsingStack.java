package com.spacey.ps.test;

import java.util.Stack;

/**
 * PK
 * @author Night King
 *
 */
public class QueueImplUsingStack {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	void enQueue(int x) {
		s1.push(x);
	}
	
	int deQueue() {
		if(s2.empty()) {
			while(!s1.empty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}

	public static void main(String[] args) {
		QueueImplUsingStack q = new QueueImplUsingStack();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.deQueue();
		q.deQueue();
		q.enQueue(10);
		System.out.println(q.deQueue());
	}

}
