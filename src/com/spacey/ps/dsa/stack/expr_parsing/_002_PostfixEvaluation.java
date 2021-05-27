package com.spacey.ps.dsa.stack.expr_parsing;

import java.util.Stack;

public class _002_PostfixEvaluation {
	static int evaluate(String expr) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			char currChar = expr.charAt(i);
			if (Character.isDigit(currChar)) {
				stack.push(Character.getNumericValue(currChar));
			} else {
				int opd1 = stack.pop();
				int opd2 = stack.pop();
				char opr = currChar;
				stack.push((opr == '+' ? opd2 + opd1
						: (opr == '-') ? opd2 - opd1 
								: (opr == '*') ? opd2 * opd1 
										: opd2 / opd1));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(evaluate("123*+4-"));
	}

}
