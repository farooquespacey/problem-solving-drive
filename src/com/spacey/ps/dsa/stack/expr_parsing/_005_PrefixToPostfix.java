package com.spacey.ps.dsa.stack.expr_parsing;

import java.util.Stack;

/**
 * 
 * @author Spacey4uq
 *
 */
public class _005_PrefixToPostfix {

	static String prefixToPostfix(String expr) {
		Stack<String> stack = new Stack<>();
		for (int i = expr.length() - 1; i >= 0; i--) {
			char c = expr.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				stack.push(c + "");
			} else {
				String exp1 = stack.pop();
				String exp2 = stack.pop();
				stack.push(exp1 + exp2 + c);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(prefixToPostfix("*+AB-CD"));
		System.out.println(prefixToPostfix("*-A/BC-/AKL"));
	}

}
