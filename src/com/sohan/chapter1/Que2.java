package com.sohan.chapter1;

/**
 * Implement a function void reverse(char* str) in C or C++ which reverses a
 * null-terminates string.
 */
public class Que2 {

	public static void main(String args[]) {
		System.out.println(reverse("sohan"));
	}

	private static String reverse(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}

		char[] chars = s.toCharArray();
		char temp;
		for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
			temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
		}
		return new String(chars);
	}

}
