package com.sohan.chapter2;

public class Node {

	private char data;
	private Node next;

	Node(char data) {
		this.data = data;
	}

	public char getData() {
		return this.data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node next() {
		return this.next;
	}

	public boolean setNext(Node next) {
		this.next = next;
		return true;
	}

	public Node addToTrail(char data) {
		Node nodeToBeAdded = new Node(data);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = nodeToBeAdded;
		return this;
	}

	@Override
	public String toString() {
		return "[" + data + "] -> " + next;
	}

	public static Node getLinkedList(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] chars = str.toCharArray();
		Node node = new Node(chars[0]);
		for (int i = 1; i < chars.length; i++) {
			node.addToTrail(chars[i]);
		}
		return node;
	}

}
