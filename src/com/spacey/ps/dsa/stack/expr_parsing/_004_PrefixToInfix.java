package com.spacey.ps.dsa.stack.expr_parsing;

import java.util.Stack;

/**
 * Computer can also understand prefix but for humans to understand, a
 * conversion to infix is required.
 * 
 * This is almost similar to PostToInfix conversion except you scan from right
 * to left
 * 
 * @author Spacey4uq
 *
 */
public class _004_PrefixToInfix {

	static String prefixToInfix(String expr) {
		Stack<String> stack = new Stack<>();
		for (int i = expr.length() - 1; i >= 0; i--) {
			char c = expr.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				stack.push(c + "");
			} else {
				String exp1 = stack.pop();
				String exp2 = stack.pop();
				stack.push("(" + exp1 + c + exp2 + ")");
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(prefixToInfix("*+AB-CD"));
		System.out.println(prefixToInfix("*-A/BC-/AKL"));
	}

}
