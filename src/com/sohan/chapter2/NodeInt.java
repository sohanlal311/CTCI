package com.sohan.chapter2;

public class NodeInt {

	private int data;
	private NodeInt next;

	public NodeInt(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeInt next() {
		return this.next;
	}

	public boolean setNext(NodeInt next) {
		this.next = next;
		return true;
	}

	public NodeInt addToTrail(int data) {
		NodeInt nodeToBeAdded = new NodeInt(data);
		NodeInt n = this;
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

	public static NodeInt getLinkedList(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] chars = str.toCharArray();
		NodeInt node = new NodeInt(chars[0] - 48);
		for (int i = 1; i < chars.length; i++) {
			node.addToTrail(chars[i] - 48);
		}
		return node;
	}
}
