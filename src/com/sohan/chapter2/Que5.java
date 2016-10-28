package com.sohan.chapter2;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
 * <p>
 * FOLLOW UP
 * <p>
 * Suppose the digits are stored in forward order. Repeat the above problem.
 */
public class Que5 {

	public static void main(String[] args) {
		NodeInt n1 = NodeInt.getLinkedList("716");
		System.out.println(n1);
		NodeInt n2 = NodeInt.getLinkedList("59");
		System.out.println(n2);
		System.out.println(sum(n1, n2));

		System.out.println("----------------");
		n1 = NodeInt.getLinkedList("617");
		System.out.println(n1);
		n2 = NodeInt.getLinkedList("95");
		System.out.println(n2);
		System.out.println(sumReverse(n1, n2));
	}

	private static NodeInt sum(NodeInt n1, NodeInt n2) {
		return sum1(n1, n2, 0);
	}

	private static NodeInt sum1(NodeInt n1, NodeInt n2, int carry) {
		if (n1 == null && n2 == null && carry == 0) {
			return null;
		}

		int n = carry + (n1 != null ? n1.getData() : 0) + (n2 != null ? n2.getData() : 0);
		NodeInt result = new NodeInt(n % 10);

		if (n1 != null || n2 != null || n > 9) {
			NodeInt node = sum1(n1 == null ? null : n1.next(), n2 == null ? null : n2.next(), n > 9 ? 1 : 0);
			result.setNext(node);
		}

		return result;
	}

	private static int getLength(NodeInt node) {
		int len = 0;
		while (node != null) {
			node = node.next();
			len++;
		}
		return len;
	}

	private static final class IntWrapper {
		int carry;
	}

	private static NodeInt padListWithZeros(NodeInt node, int padding) {
		NodeInt head = node;
		for (int i = 0; i < padding; i++) {
			head = new NodeInt(0);
			head.setNext(node);
		}
		return head;
	}

	private static NodeInt sumReverse(NodeInt n1, NodeInt n2) {
		if (n1 == null && n2 == null) {
			return null;
		}

		int len1 = getLength(n1);
		int len2 = getLength(n2);

		if (len1 > len2) {
			n2 = padListWithZeros(n2, len1 - len2);
		} else {
			n1 = padListWithZeros(n1, len2 - len1);
		}

		IntWrapper i = new IntWrapper();
		NodeInt result = sumReverse2(n1, n2, i);
		if (i.carry > 0) {
			NodeInt node = new NodeInt(i.carry);
			node.setNext(result);
			result = node;
		}
		return result;
	}

	private static NodeInt sumReverse2(NodeInt n1, NodeInt n2, IntWrapper i) {
		if (n1 == null && n2 == null) {
			i.carry = 0;
			return null;
		}
		NodeInt node = sumReverse2(n1.next(), n2.next(), i);
		int sum = i.carry + n1.getData() + n2.getData();
		i.carry = sum > 9 ? 1 : 0;
		NodeInt result = new NodeInt(sum % 10);
		result.setNext(node);
		return result;
	}
}
