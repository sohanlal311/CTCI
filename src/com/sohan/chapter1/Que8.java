package com.sohan.chapter1;

public class Que8 {

	public static void main(String[] args) {
		System.out.println(isRotation(null, null));
		System.out.println(isRotation(null, "alSohan L"));
		System.out.println(isRotation("Sohan Lal", null));
		System.out.println(isRotation("", ""));
		System.out.println(isRotation("Sohan Lal", "alSohan La"));
		System.out.println(isRotation("Sohan Lal", "alSohan L"));
		System.out.println(isRotation("Sohan Lal", "alSohan l"));
	}

	private static boolean isRotation(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return false;
		}
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() != s2.length() || s1.length() == 0) {
			return false;
		}
		return isSubstring(s1 + s1, s2);
	}

	private static boolean isSubstring(String s1, String s2) {

		return s1.contains(s2);
	}
}
