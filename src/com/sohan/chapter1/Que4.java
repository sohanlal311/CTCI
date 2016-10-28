package com.sohan.chapter1;

public class Que4 {

	public static void main(String[] args) {
		System.out.println(replaceSpaces(
				new char[] { 's', ' ', 'o', 'h', 'a', ' ', 'n', '\0', '\0', '\0', '\0', '\0' }, 7));
	}

	private static char[] replaceSpaces(char[] chars, int length) {
		if (chars == null || chars.length == 0) {
			return chars;
		}

		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (chars[i] == ' ') {
				spaceCount++;
			}
		}

		int newLength = length + spaceCount * 2;
		chars[newLength] = '\0';
		for (int end1 = length - 1, end2 = newLength - 1; end1 >= 0; end1--) {
			if (chars[end1] == ' ') {
				chars[end2--] = '0';
				chars[end2--] = '2';
				chars[end2--] = '%';
			} else {
				chars[end2--] = chars[end1];
			}
		}
		return chars;
	}

}
