package com.spacey.ps.hrank;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Input: for abccbda and burst size = 2
 * 
 * Output: ada
 * 
 * @author Spacey4uq
 *
 */
public class _036_FlatCandyCrush {

	
	static List<String> shrink(List<String> input, int burstSize) {
		Stack<Element> stack = new Stack<>();
		List<String> result = new ArrayList<>();
		stack.push(new Element(input.get(0), 1));
		for(int i=1; i<input.size(); i++) {
			pushElemCarefully(stack, input.get(i), burstSize);
		}
		stack.stream().forEach(e -> {
			for(int i = 0; i < e.times; i++) {
				result.add(e.character);
			}
		});
		return result;
	}
	
	static void pushElemCarefully(Stack<Element> stack, String el, int burstSize) {
		Element top = stack.peek();
		if(el.equals(top.character)) {
			top.times++;
		} else {
			if (top.times >= burstSize) stack.pop();
			if(stack.peek().character.equals(el))
				pushElemCarefully(stack, el, burstSize);
			else stack.push(new Element(el, 1));
		}		
	}

    static String removeDuplicates(String s, int k) {
        // ArrayDeque has better performance than Stack and LinkedList
        ArrayDeque<Adjacent> st = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peekLast().ch == c) {
                st.peekLast().freq++; // Increase the frequency
            } else {
                st.addLast(new Adjacent(c, 1));
            }
            if (st.peekLast().freq == k) // If reach enough k duplicate letters -> then remove
                st.removeLast();
        }
        StringBuilder sb = new StringBuilder();
//        for (Adjacent a : st) {
//            sb.append(String.valueOf(a.ch).repeat(a.freq));
//        }
        st.stream().forEach(e -> {
			for(int i = 0; i < e.freq; i++) {
				sb.append(e.ch);
			}
		});
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(shrink(Arrays.asList("a", "b", "c", "c", "c", "b", "d", "m"), 2));
		System.out.println(removeDuplicates("abcccbdm", 2));
	}

}
class Adjacent {
    char ch;
    int freq;
    public Adjacent(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Element{
	String character;
	int times;
	
	public Element(String c, int t) {
		character = c;
		times = t;
	}
	
}
