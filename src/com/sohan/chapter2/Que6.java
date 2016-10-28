package com.sohan.chapter2;

/**
 * Given a circular linked list, implement an algorithm which returns the node
 * at the beginning of the loop.
 */
public class Que6 {

	public static void main(String[] args) {
		NodeInt head = NodeInt.getLinkedList("123456");
		head.next().next().next().next().next().setNext(head.next().next());
		// System.out.println(head);
		System.out.println(getBeginningNodeOfCircularLinkedList(head).getData());
	}

	private static NodeInt getBeginningNodeOfCircularLinkedList(NodeInt head) {
		if (head == null) {
			return null;
		}

		NodeInt slow = head;
		NodeInt fast = head;
		while (fast != null && fast.next() != null) {
			slow = slow.next();
			fast = fast.next().next();
			if (slow == fast) {
				break;
			}
		}

		if (fast == null || fast.next() == null) {
			return null;
		}

		slow = head;
		while (slow != fast) {
			slow = slow.next();
			fast = fast.next();
		}

		return slow;
	}
}
