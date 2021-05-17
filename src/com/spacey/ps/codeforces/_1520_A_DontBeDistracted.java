package com.spacey.ps.codeforces;

import java.util.HashSet;
import java.util.Set;

/**
 * For example, if Polycarp solved tasks in the following order: "DDBBCCCBBEZ",
 * then the teacher will see that on the third day Polycarp began to solve the
 * task 'B', then on the fifth day he got distracted and began to solve the task
 * 'C', on the eighth day Polycarp returned to the task 'B'. Other examples of
 * when the teacher is suspicious: "BAB", "AABBCCDDEEBZZ" and "AAAAZAAAAA".
 * 
 * If Polycarp solved the tasks as follows: "FFGZZZY", then the teacher cannot
 * have any suspicions. Please note that Polycarp is not obligated to solve all
 * tasks. Other examples of when the teacher doesn't have any suspicious: "BA",
 * "AFFFCC" and "YYYYY".
 * 
 * Help Polycarp find out if his teacher might be suspicious.
 * 
 * @author Night King
 *
 */
public class _1520_A_DontBeDistracted {

	public static void main(String[] args) {
		System.out.println(isDistracted("DDBBCCCBBEZ"));
	}

	// DDBBCCCBBEZ
	// FFGZZZY
	private static boolean isDistracted(String inp) {
		Set<Character> existingChars = new HashSet<>();
		for (int i = 0; i < inp.length(); i++) {
			char thisChar = inp.charAt(i);
			if (existingChars.isEmpty() || (!existingChars.contains(thisChar)) || (thisChar == inp.charAt(i - 1))) {
				existingChars.add(thisChar);
			} else {
				return false;
			}
		}
		return true;
	}

}
