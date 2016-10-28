package com.sohan.chapter1;

public class Que5 {

	public static void main(String[] args) {
		System.out.println(compressStringUsingStringBuilder(null));
		System.out.println(compressStringUsingStringBuilder("a"));
		System.out.println(compressStringUsingStringBuilder("aa"));
		System.out.println(compressStringUsingStringBuilder("abc"));
		System.out.println(compressStringUsingStringBuilder("aab"));
		System.out.println(compressStringUsingStringBuilder("aabcccccaaa"));
		System.out.println("==============");
		System.out.println(compressStringUsingCharArray(null));
		System.out.println(compressStringUsingCharArray("a"));
		System.out.println(compressStringUsingCharArray("aa"));
		System.out.println(compressStringUsingCharArray("abc"));
		System.out.println(compressStringUsingCharArray("aab"));
		System.out.println(compressStringUsingCharArray("aabcccccaaa"));
	}

	private static String compressStringUsingStringBuilder(String s) {
		if (s == null || s.length() < 2 || countCompression(s) > s.length()) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		char prevChar = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == prevChar) {
				count++;
			} else {
				sb.append(prevChar).append(count);
				prevChar = s.charAt(i);
				count = 1;
			}
		}
		return sb.append(prevChar).append(count).toString();
	}

	private static String compressStringUsingCharArray(String s) {
		int length;
		if (s == null || s.length() < 2 || (length = countCompression(s)) > s.length()) {
			return s;
		}

		char[] chars = new char[length];
		char prevChar = s.charAt(0);
		int idx = 0;
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == prevChar) {
				count++;
			} else {
				idx = setChar(chars, idx, prevChar, count);
				prevChar = s.charAt(i);
				count = 1;
			}
		}
		setChar(chars, idx, prevChar, count);
		return new String(chars);
	}

	private static int setChar(char[] chars, int idx, char prevChar, int count) {
		chars[idx++] = prevChar;
		char[] cnt = String.valueOf(count).toCharArray();
		for (char c : cnt) {
			chars[idx++] = c;
		}
		return idx;
	}

	private static int countCompression(String s) {
		char prevChar = s.charAt(0);
		int count = 1;
		int size = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == prevChar) {
				count++;
			} else {
				size += 1 + String.valueOf(count).length();
				prevChar = s.charAt(i);
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
}
