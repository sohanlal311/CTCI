package com.sohan.chapter2;

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x.
 */
public class Que4 {

	public static void main(String[] args) {
		Node head = Node.getLinkedList("FOLLOW UP");
		System.out.println(head);
		System.out.println(arrangeLinkedListWithOrder(head, 'O'));

		System.out.println("----------------");
		head = Node.getLinkedList("FOLLOW UP");
		System.out.println(head);
		System.out.println(arrangeLinkedListWithoutOrder(head, 'O'));

		System.out.println("----------------");
		head = Node.getLinkedList("FOLLOW UP");
		System.out.println(head);
		System.out.println(arrangeLinkedListWithoutOrder2(head, 'O'));
	}

	private static Node arrangeLinkedListWithOrder(Node head, int x) {
		if (head == null || head.next() == null) {
			return head;
		}

		Node curr = head;
		Node prev = null;
		Node pointer = null;
		while (curr != null) {
			if (curr.getData() < x) {
				if (prev != null) {
					prev.setNext(curr.next());
					if (pointer == null) {
						curr.setNext(head);
						head = curr;
					} else {
						curr.setNext(pointer.next());
						pointer.setNext(curr);
					}
				} else {
					prev = curr;
				}
				pointer = curr;
			} else {
				prev = curr;
			}
			curr = prev.next();
		}

		return head;
	}

	private static Node arrangeLinkedListWithoutOrder(Node head, int x) {
		if (head == null || head.next() == null) {
			return head;
		}

		Node curr = head;
		Node prev = null;
		while (curr != null) {
			if (curr.getData() < x && prev != null) {
				prev.setNext(curr.next());
				curr.setNext(head);
				head = curr;
				curr = prev.next();
			} else {
				prev = curr;
				curr = curr.next();
			}
		}

		return head;
	}

	private static Node arrangeLinkedListWithoutOrder2(Node head, int x) {
		if (head == null || head.next() == null) {
			return head;
		}

		Node beforeStart = null;
		Node afterStart = null;
		while (head != null) {
			Node next = head.next();
			if (head.getData() < x) {
				head.setNext(beforeStart);
				beforeStart = head;
			} else {
				head.setNext(afterStart);
				afterStart = head;
			}
			head = next;
		}

		if (beforeStart == null) {
			return afterStart;
		}

		head = beforeStart;
		while (head.next() != null) {
			head = head.next();
		}
		head.setNext(afterStart);

		return beforeStart;
	}
}
