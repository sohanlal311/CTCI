package com.sohan.chapter2;

/**
 * Implement an algorithm to find the kth to last element of a singly linked
 * list.
 */
public class Que2 {

	public static void main(String[] args) {
		Node head = Node.getLinkedList("FOLLOW UP");
		System.out.println(head);
		System.out.println(kthToLastRecursively(head, 4, new IntWrapper()).getData());
		System.out.println(kthToLastIteratively(head, 4).getData());
	}

	private static Node kthToLastRecursively(Node head, int k, IntWrapper i) {
		if (head == null) {
			return null;
		}
		Node node = kthToLastRecursively(head.next(), k, i);
		i.value = i.value + 1;
		if (i.value == k) {
			return head;
		}
		return node;
	}

	private static class IntWrapper {
		public int value = 0;
	}

	private static Node kthToLastIteratively(Node head, int k) {
		if (head == null || k <= 0) {
			return head;
		}

		Node p1 = head;
		Node p2 = p1;
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null)
				return null;
			p2 = p2.next();
		}

		if (p2 == null)
			return p1;

		while (p2.next() != null) {
			p1 = p1.next();
			p2 = p2.next();
		}
		return p1;
	}
}
