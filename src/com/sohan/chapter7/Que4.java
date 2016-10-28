package com.sohan.chapter7;

/**
 * Write methods to implement the multiply, subtract and divide operations for
 * integers. Use only the add operation.
 */
public class Que4 {

	public static void main(String[] args) {
		System.out.println(subtract(3, -2));
		System.out.println(multiply(3, -2));
		System.out.println(divide(3, -2));
	}

	public static int subtract(int a, int b) {
		return a + negate(b);
	}

	public static int multiply(int a, int b) {
		if (a < b) {
			return multiply(b, a);
		}
		int result = 0;
		for (int i = abs(b); i > 0; i--) {
			result += a;
		}
		if (b < 0) {
			result = negate(result);
		}
		return result;
	}

	public static int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Divide by zero error.");
		}
		int sum = 0;
		int result = 0;
		int absa = abs(a);
		int absb = abs(b);
		while (sum + absb <= absa) {
			sum += absb;
			result++;
		}
		if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
			return result;
		} else {
			return negate(result);
		}
	}

	private static int negate(int num) {
		int result = 0;
		int d = num < 0 ? 1 : -1;
		while (num != 0) {
			num += d;
			result += d;
		}
		return result;
	}

	private static int abs(int num) {
		if (num < 0) {
			return negate(num);
		} else {
			return num;
		}
	}

}
