package com.spacey.ps.dsa.stack.expr_parsing;

import java.util.Stack;

public class _001_InfixToPostfix {

	static String infixToPostfix(String expr) {
		StringBuilder out = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char currChar = expr.charAt(i);
			if (Character.isLetterOrDigit(currChar)) {
				out.append(currChar);
			} else if (currChar == '(') { // operator is encountered
				stack.push(currChar);
			} else if (currChar == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					out.append(stack.pop());
				if (stack.isEmpty())
					return "Invalid Expression!";
				stack.pop(); // remove '(' from stack
			} else {
				// output as long as the scanned operator is smaller or equal to the top element
				while (!stack.isEmpty() && prec(stack.peek()) >= prec(currChar)) {
					out.append(stack.pop());
				}
				// push scanned element if it is larger than the top element in either of the
				// cases
				stack.push(currChar);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression!";
			out.append(stack.pop());
		}
		return out.toString();
	}

	private static int prec(Character c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

	public static void main(String[] args) {
		System.out.println(infixToPostfix("a+(b-c*d)/e"));
		System.out.println(infixToPostfix("(a+b*c+d)"));
	}

}
