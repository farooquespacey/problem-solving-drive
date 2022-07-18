package com.spacey.ps.leetcode;

public class _011_ShortestPalindromeByAddingCharsToLeft {

// Approach #1 Brute force [Accepted]
//	string shortestPalindrome(string s)
//	{
//	    int n = s.size();
//	    string rev(s);
//	    reverse(rev.begin(), rev.end());
//	    int j = 0;
//	    for (int i = 0; i < n; i++) {
//	        if (s.substr(0, n - i) == rev.substr(i))
//	            return rev.substr(0, i) + s;
//	    }
//	    return "";
//	}

// Approach #2 Two pointers and recursion [Accepted]	
//	string shortestPalindrome(string s)
//	{
//	    int n = s.size();
//	    int i = 0;
//	    for (int j = n - 1; j >= 0; j--) {
//	        if (s[i] == s[j])
//	            i++;
//	    }
//	    if (i == n)
//	        return s;
//	    string remain_rev = s.substr(i, n);
//	    reverse(remain_rev.begin(), remain_rev.end());
//	    return remain_rev + shortestPalindrome(s.substr(0, i)) + s.substr(i);
//	}

// Approach #3 KMP [Accepted]
//	string shortestPalindrome(string s)
//	{
//	    int n = s.size();
//	    string rev(s);
//	    reverse(rev.begin(), rev.end());
//	    string s_new = s + "#" + rev;
//	    int n_new = s_new.size();
//	    vector<int> f(n_new, 0);
//	    for (int i = 1; i < n_new; i++) {
//	        int t = f[i - 1];
//	        while (t > 0 && s_new[i] != s_new[t])
//	            t = f[t - 1];
//	        if (s_new[i] == s_new[t])
//	            ++t;
//	        f[i] = t;
//	    }
//	    return rev.substr(0, n - f[n_new - 1]) + s;
//	}

	static String shortestPalindromeMyTry2(String s) {
		if (s.isEmpty()) return s;
		String reversed = new StringBuilder(s).reverse().toString();
		int n = 0;
		for (int i = 0; i < (n = s.length()); i++) {
			if (s.substring(0, n - i).equals(reversed.substring(i))) {
				return reversed.substring(0, i) + s;
			}
		}
		return reversed + s.substring(1);
	}

	static String shortestPalindromeMyTry(String s) {
		if (s.isEmpty())
			return s;
		int n = s.length(), start = 0, end = 0;
		for (int l = (n - 1) / 2, r = l + (n - 1) % 2; n > 0; n--, l = (n - 1) / 2, r = l + (n - 1) % 2) {
			int len = expandAroundCenter(s, l, r);
			if (len > end - start) {
				start = l - ((len - 1) / 2);
				end = l + (len / 2);
				break;
			}
		}
		return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
	}

	static int expandAroundCenter(String s, int l, int r) {
		while (l >= 0 && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		// if all the way to the 0th idx is palindromic then return the length,
		// otherwise return 0
		return (l < 0) ? (r - l - 1) : 0;
	}

	public static void main(String[] args) {
		// cbabca
		// acbabc
		System.out.println(shortestPalindromeMyTry("abcd"));
		System.out.println(shortestPalindromeMyTry("abcde"));
		System.out.println(shortestPalindromeMyTry("cbabcab"));
		System.out.println(shortestPalindromeMyTry("cbabca"));
		System.out.println(shortestPalindromeMyTry("adcbabc"));
		System.out.println(shortestPalindromeMyTry("abcbdef"));
		System.out.println(shortestPalindromeMyTry("aacecaaa"));
		System.out.println(shortestPalindromeMyTry2("abcd"));
		System.out.println(shortestPalindromeMyTry2("abcde"));
		System.out.println(shortestPalindromeMyTry2("cbabcab"));
		System.out.println(shortestPalindromeMyTry2("cbabca"));
		System.out.println(shortestPalindromeMyTry2("adcbabc"));
		System.out.println(shortestPalindromeMyTry2("abcbdef"));
		System.out.println(shortestPalindromeMyTry2("aacecaaa"));
	}

}
