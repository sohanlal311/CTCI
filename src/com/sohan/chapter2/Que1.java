package com.sohan.chapter2;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * <p>
 * FOLLOW UP
 * <p>
 * How would you solve this problem if a temporary buffer is not allowed.
 */
public class Que1 {
	public static void main(String[] args) {
		Node head = Node.getLinkedList("FOLLOW UP");
		System.out.println(head);
		// System.out.println(removeDuplicateASCIICharacters(head));
		// System.out.println(removeDuplicateAlphabets(head));
		System.out.println(removeDuplicatesWithoutExtraSpace(head));
	}

	private static Node removeDuplicateASCIICharacters(Node head) {
		if (head == null) {
			return head;
		}
		boolean[] chars = new boolean[256];
		Node n = head;
		chars[n.getData()] = true;
		while (n.next() != null) {
			int nextData = n.next().getData();
			if (chars[nextData]) {
				n.setNext(n.next().next());
			} else {
				chars[nextData] = true;
				n = n.next();
			}
		}
		return head;
	}

	private static Node removeDuplicateAlphabets(Node head) {
		if (head == null) {
			return head;
		}
		int checker = 0;
		Node n = head;
		checker |= 1 << (n.getData() - 'A');
		while (n.next() != null) {
			int bit = 1 << (n.next().getData() - 'A');
			if ((checker & bit) > 0) {
				n.setNext(n.next().next());
			} else {
				checker |= bit;
				n = n.next();
			}
		}
		return head;
	}

	private static Node removeDuplicatesWithoutExtraSpace(Node head) {
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next() != null) {
				if (current.getData() == runner.next().getData()) {
					runner.setNext(runner.next().next());
				} else {
					runner = runner.next();
				}
			}
			current = current.next();
		}
		return head;
	}
}
