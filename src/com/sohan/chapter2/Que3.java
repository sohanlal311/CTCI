package com.sohan.chapter2;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked
 * list, given only access to that node.
 */
public class Que3 {
	public static void main(String[] args) {
		Node head = Node.getLinkedList("FOLLOW UP");
		System.out.println(head);
		Node node = head.next().next().next().next();
		System.out.println(node.getData());
		deleteNode(node);
		System.out.println(head);
	}

	// Last node cannot be delete by this algorithm. We can mark the last node
	// as dummy node if asked.
	private static void deleteNode(Node n) {
		if (n == null || n.next() == null) {
			return;
		}
		n.setData(n.next().getData());
		n.setNext(n.next().next());
	}
}
