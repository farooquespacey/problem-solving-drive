package com.spacey.ps.hrank;

import java.util.*;
import java.util.Scanner;

class Parser {

	public boolean isBalanced(String next) {
		Stack<Character> symbols = new Stack<>();
		for (int i = 0; i < next.length(); i++) {
			char presentChar = next.charAt(i);
//			symbols.add(next.charAt(i));
			switch (presentChar) {
				case '{':
					symbols.add(presentChar);
					break;
				case '}':
					if(symbols.empty() || symbols.pop() != '{') {
						return false;
					}
					break;
				case '(':
					symbols.add(presentChar);
					break;
				case ')':
					if(symbols.empty() || symbols.pop() != '(') {
						return false;
					}
					break;
			}
		}
		return symbols.empty();
	}

}

// Write your code here. DO NOT use an access modifier in your class declaration.
class _024_UnbalancedSymbolCheck {

	public static void main(String[] args) {
		Parser parser = new Parser();

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			System.out.println(parser.isBalanced(in.next()));
		}

		in.close();
	}
}
