package com.sohan.chapter2;

import java.util.Stack;

/** Implement a function to check if a linked list is a palindrome. */
public class Que7 {

	public static void main(String[] args) {
		Node head = Node.getLinkedList("GANAG");
		System.out.println(head);
		System.out.println(isPalindrome1(head));

		System.out.println("--------------");
		System.out.println(head);
		System.out.println(isPalindrome2(head));

		System.out.println("--------------");
		System.out.println(head);
		System.out.println(isPalindrome3(head));
	}

	private static final class IntWrapper {
		int value;
	}

	private static boolean isPalindrome1(Node head) {
		if (head == null) {
			return false;
		}
		IntWrapper i = new IntWrapper();
		Node reversedNode = reverse(head, i);
		System.out.println(i.value);
		System.out.println(reversedNode);
		for (int j = 0; j < i.value / 2; j++) {
			if (head.getData() != reversedNode.getData()) {
				return false;
			}
			head = head.next();
			reversedNode = reversedNode.next();
		}
		return true;
	}

	private static Node reverse(Node head, IntWrapper i) {
		if (head == null) {
			return null;
		}

		Node node = reverse(head.next(), i);
		if (node == null) {
			node = new Node(head.getData());
		} else {
			node.addToTrail(head.getData());
		}
		i.value++;
		return node;
	}

	private static boolean isPalindrome2(Node head) {
		if (head == null) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next() != null) {
			stack.push(slow.getData());
			slow = slow.next();
			fast = fast.next().next();
		}

		if (fast != null) {
			slow = slow.next();
		}

		while (slow != null) {
			if (slow.getData() != stack.pop()) {
				return false;
			}
			slow = slow.next();
		}
		return true;
	}

	private static final class Result {
		Node node;
		boolean isEqual;
	}

	private static int getLength(Node node) {
		int len = 0;
		while (node != null) {
			node = node.next();
			len++;
		}
		return len;
	}

	private static boolean isPalindrome3(Node head) {
		if (head == null) {
			return false;
		}
		return isPalindrome3(head, getLength(head)).isEqual;
	}

	private static Result isPalindrome3(Node head, int length) {
		if (length == 0 || length == 1) {
			Result result = new Result();
			result.node = length == 0 ? head : head.next();
			result.isEqual = true;
			return result;
		}
		Result result = isPalindrome3(head.next(), length - 2);
		if (result.isEqual) {
			result.isEqual = head.getData() == result.node.getData();
			result.node = result.node.next();
		}
		return result;
	}
}
