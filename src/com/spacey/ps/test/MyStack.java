package com.spacey.ps.test;

import java.util.LinkedList;

class MineStack{
	LinkedList<Integer> lis = new LinkedList<Integer>();
	
	private void printTop() {
		if(lis.isEmpty()) System.out.println("EMPTY");
		else System.out.println(lis.getLast());
	}
	
	public void push(int val) {
		lis.addLast(val);
		printTop();
	}
	
	public void pop() {
		lis.removeLast();
		printTop();
	}
	
	public void inc(int i, int v) {
		for(int from = 0; from < i; from++) {
			lis.set(from, lis.get(from) + v);
		}
		printTop();
	}
}


public class MyStack {
	
	

	public static void main(String[] args) {
		MineStack stack = new MineStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.pop();
		stack.pop();
		
	}

}
