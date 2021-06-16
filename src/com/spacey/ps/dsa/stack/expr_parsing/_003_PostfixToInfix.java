package com.spacey.ps.dsa.stack.expr_parsing;

import java.util.Stack;

/**
 * Postfix expression is efficient for computer to understand an expression but
 * for humans to understand, a conversion to infix is required.
 * 
 * This can be done by pushing the operands to the stack as scanned and popping
 * two of them when an operator is encountered and push them back in after
 * combining them with an operator
 * 
 * @author Spacey4uq
 *
 */
public class _003_PostfixToInfix {

	static String postfixToInfix(String expr) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				stack.push(c + "");
			} else {
				String exp1 = stack.pop();
				String exp2 = stack.pop();
				stack.push("(" + exp2 + c + exp1 + ")");
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(postfixToInfix("abc++")); // (a+(b+c))
		System.out.println(postfixToInfix("ab*c+")); // ((a*b)+c)
	}

}
