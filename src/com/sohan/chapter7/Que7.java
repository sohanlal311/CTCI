package com.sohan.chapter7;

import java.util.LinkedList;

/**
 * Design an algorithm to find the kth number such that the only prime factors
 * are 3, 5, 7.
 */
public class Que7 {

	public static void main(String[] args) {
		System.out.println(getKthMagicNumber(4));
	}

	public static int getKthMagicNumber(int k) {
		if (k < 0) {
			return 0;
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		addProducts(queue, 1);
		int val = 1;
		for (int i = 0; i < k; i++) {
			val = removeMin(queue);
			addProducts(queue, val);
		}
		return val;
	}

	private static void addProducts(LinkedList<Integer> queue, int v) {
		queue.add(v * 3);
		queue.add(v * 5);
		queue.add(v * 7);
	}

	private static int removeMin(LinkedList<Integer> queue) {
		Integer min = queue.peek();
		for (Integer v : queue) {
			if (v < min) {
				min = v;
			}
		}
		while (queue.contains(min)) {
			queue.remove(min);
		}
		return min;
	}
}
