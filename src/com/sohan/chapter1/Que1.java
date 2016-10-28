package com.sohan.chapter1;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class Que1 {

	public static boolean hasUniqueCharacters(String s) {
		if (s == null || s.isEmpty() || s.length() == 1) {
			return true;
		}

		if (s.length() > 256) {
			return false;
		}

		boolean[] charSet = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}

	public static boolean hasUniqueAlphabets(String s) {
		if (s == null || s.isEmpty() || s.length() == 1) {
			return true;
		}

		if (s.length() > 256) {
			return false;
		}

		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int offset = 1 << (s.charAt(i) - 'a');
			if ((checker & offset) != 0) {
				return false;
			}
			checker |= offset;
		}
		return true;
	}
}
