package com.spacey.ps.dsa.stack.expr_parsing;

import java.util.Stack;

/**
 * 
 * @author Spacey4uq
 *
 */
public class _006_PostfixToPrefix {

	static String postfixToPrefix(String expr) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				stack.push(c + "");
			} else {
				String exp1 = stack.pop();
				String exp2 = stack.pop();
				stack.push(c + exp2 + exp1);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(postfixToPrefix("AB+CD-*"));
		System.out.println(postfixToPrefix("ABC/-AK/L-*"));
	}

}
