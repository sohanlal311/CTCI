package com.sohan.chapter1;

/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class Que3 {

	public static void main(String args[]) {
		System.out.println(permutation("Sohan", "sohan"));
		System.out.println(permutation("Sohan", "Sohan"));
		System.out.println(permutation2("Sohan", "sohan"));
		System.out.println(permutation2("Sohan", "Sohan"));
	}

	private static boolean permutation(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		return sort(s1).equals(sort(s2));
	}

	private static String sort(String s) {
		char[] chars = s.toCharArray();
		java.util.Arrays.sort(chars);
		return new String(chars);
	}

	// Assumption is that character set is ASCII
	private static boolean permutation2(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}

		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}

		int[] letters = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			letters[s1.charAt(i)]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			if (--letters[s2.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}
}
