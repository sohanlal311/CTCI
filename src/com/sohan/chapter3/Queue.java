package com.sohan.chapter3;

public class Queue {
	Node first, last;

	public void enqueue(Object data) {
		if (first == null) {
			last = new Node(data);
			first = last;
		} else {
			last.next = new Node(data);
			last = last.next;
		}
	}

	public Object dequeue() {
		if (first != null) {
			Object data = first.data;
			first = first.next;
			return data;
		}
		return null;
	}

	private final class Node {
		Object data;
		Node next;

		Node(Object data) {
			this.data = data;
		}

	}
}
