package com.sohan.chapter3;

public class Stack<T> {

	Node top;
	int size;
	int capacity;

	Stack() {

	}

	Stack(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		return this.size == this.capacity;
	}

	public void push(T data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
		size++;
	}

	public T pop() {
		if (top != null) {
			T data = top.data;
			top = top.next;
			size--;
			return data;
		}
		return null;
	}

	public T peek() {
		return isEmpty() ? null : top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node n = top;
		for (int i = 0; i < size; i++) {
			sb.append(n.data).append(", ");
			n = n.next;
		}
		return sb.toString();
	}

	private final class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
		}
	}
}
