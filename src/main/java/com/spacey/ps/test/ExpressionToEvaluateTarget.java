package com.spacey.ps.test;

import java.util.Stack;

public class ExpressionToEvaluateTarget {

	public static void main(String[] args) {
		String inp = "12";
		expressionPerm(inp);
//		System.out.println(infixToPostfix("(12)*3"));
//		System.out.println(evaluatePostfix(infixToPostfix("(12)*3")));
		
	}
	
	public static void expressionPerm(String inp) {
		if(inp.length() < 2) {
			System.out.println(inp);
		} else {
			expressionPermutation(inp.substring(1), "" + inp.charAt(0), 6);
		}
	}

	public static void expressionPermutation(String num, String expr, int target) {
		String currentVal = "" + num.charAt(0);
		String newExpr1 = expr + "+" + currentVal;
		String newExpr2 = expr + "-" + currentVal;
		String newExpr3 = expr + "*" + currentVal;
		String newExpr4 = expr + currentVal;

		if (num.length() == 1) {
//			if (evaluatesTo(newExpr1, target))
				System.out.println(newExpr1);
//			if (evaluatesTo(newExpr2, target))
				System.out.println(newExpr2);
//			if (evaluatesTo(newExpr3, target))
				System.out.println(newExpr3);
//			if (evaluatesTo(newExpr4, target))
				System.out.println(newExpr4);
		} else {
			String rightVal = num.substring(1);
			expressionPermutation(rightVal, newExpr1, target);
			expressionPermutation(rightVal, newExpr2, target);
			expressionPermutation(rightVal, newExpr3, target);
			expressionPermutation(rightVal, newExpr4, target);
		}
	}

	private static boolean evaluatesTo(String expr, int target) {
		int res = evaluatePostfix(infixToPostfix(expr));
		if(res == target) {
			System.out.println(expr+ " evaluates to " + target);
			
		}
		return res == target;
	}

	// Method to evaluate value of a postfix expression
	static int evaluatePostfix(String exp) {
		// create a stack
		Stack<Integer> stack = new Stack<>();

		// Scan all characters one by one
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			// If the scanned character is an operand (number here),
			// push it to the stack.
			if (Character.isDigit(c))
				stack.push(c - '0');

			// If the scanned character is an operator, pop two
			// elements from stack apply the operator
			else {
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (c) {
				case '+':
					stack.push(val2 + val1);
					break;

				case '-':
					stack.push(val2 - val1);
					break;

				case '/':
					stack.push(val2 / val1);
					break;

				case '*':
					stack.push(val2 * val1);
					break;
				}
			}
		}
		return stack.pop();
	}

	static String infixToPostfix(String exp) {
		// initializing empty String for result
		String result = new String("");

		// initializing empty stack
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); ++i) {
			char c = exp.charAt(i);

			// If the scanned character is an
			// operand, add it to output.
			if (Character.isLetterOrDigit(c))
				result += c;

			// If the scanned character is an '(',
			// push it to the stack.
			else if (c == '(')
				stack.push(c);

			// If the scanned character is an ')',
			// pop and output from the stack
			// until an '(' is encountered.
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				stack.pop();
			} else // an operator is encountered
			{
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {

					result += stack.pop();
				}
				stack.push(c);
			}

		}

		// pop all the operators from the stack
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}

	// A utility function to return
	// precedence of a given operator
	// Higher returned value means
	// higher precedence
	static int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

}
