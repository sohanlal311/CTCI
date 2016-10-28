package com.sohan.chapter3;

/**
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in O(1) time.
 */
public class Que2 {

	public static void main(String[] args) {
		StackWithMin2 stack = new StackWithMin2();
		stack.push(5);
		System.out.println("Min after push(5): " + stack.min());
		stack.push(6);
		System.out.println("Min after push(6): " + stack.min());
		stack.push(3);
		System.out.println("Min after push(3): " + stack.min());
		stack.push(3);
		System.out.println("Min after push(3): " + stack.min());
		stack.push(7);
		System.out.println("Min after push(7): " + stack.min());
		stack.pop();
		System.out.println("Min after pop(): " + stack.min());
		stack.pop();
		System.out.println("Min after pop(): " + stack.min());
		stack.pop();
		System.out.println("Min after pop(): " + stack.min());
	}

}

class StackWithMin extends Stack<NodeWithMin> {

	public void push(int data) {
		int min = Math.min(data, min());
		super.push(new NodeWithMin(data, min));
	}

	public int min() {
		if (isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}
}

class NodeWithMin {
	int data;
	NodeWithMin next;
	int min;

	NodeWithMin(int data, int min) {
		this.data = data;
		this.min = min;
	}
}

class StackWithMin2 extends Stack<Integer> {

	Stack<Integer> s2;

	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}

	public void push(int data) {
		if (data <= min()) {
			s2.push(data);
		}
		super.push(data);
	}

	public Integer pop() {
		Integer data = super.pop();
		if (data == min()) {
			s2.pop();
		}
		return data;
	}

	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}

}