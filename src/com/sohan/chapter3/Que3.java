package com.sohan.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold. Implement a data structure that mimics
 * this. SetOfStacks should be composed of several stacks and should create a
 * new stack once the previous one exceeds the capacity. SetOfStacks.push() and
 * SetOfStacks.pop() should behave identically to single stack (that is, pop()
 * should return the same values as it would if there were just a single stack).
 * <p>
 * FOLLOW UP
 * <p>
 * Implement a function popAt(int index) which performs a pop operation on a
 * specific sub-stack.
 */
public class Que3 {

	public static void main(String[] args) {
		StackSet stack = new StackSet(3);
		print(stack);
		stack.push(3);
		print(stack);
		stack.push(5);
		print(stack);
		stack.push(7);
		print(stack);
		stack.push(9);
		print(stack);
		stack.push(6);
		print(stack);
		stack.popAt(0);
		print(stack);
		stack.popAt(0);
		print(stack);
		stack.pop();
		print(stack);
		stack.pop();
		print(stack);
	}

	private static void print(StackSet stackSet) {
		System.out.println(stackSet + " Size: " + stackSet.size());
	}

}

class StackSet {
	private int capacity;
	private List<Stack<Integer>> stacks;

	StackSet(int capacity) {
		this.capacity = capacity;
		this.stacks = new ArrayList<Stack<Integer>>();
	}

	public void push(Integer data) {
		Stack<Integer> last = getLastStack();
		if (last != null && !last.isFull()) {
			last.push(data);
		} else {
			Stack<Integer> stack = new Stack<Integer>(this.capacity);
			stacks.add(stack);
			stack.push(data);
		}
	}

	public Integer pop() {
		Integer data = null;
		Stack<Integer> last = getLastStack();
		if (last != null) {
			data = last.pop();
			if (last.size == 0) {
				stacks.remove(stacks.size() - 1);
			}
		}
		return data;
	}

	public Integer popAt(int index) {
		Integer data = null;
		if (index >= 0 && index < stacks.size()) {
			Stack<Integer> stack = stacks.get(index);
			data = stack.pop();
			leftShift(index);
		}
		return data;
	}

	public int size() {
		return stacks.size();
	}

	private void leftShift(int index) {
		if (index >= 0 && index < stacks.size() - 1) {
			Stack<Integer> stack = stacks.get(index);
			int diff = this.capacity - stack.size;
			if (diff > 0) {
				Stack<Integer> next = stacks.get(index + 1);
				Stack<Integer> temp = new Stack<Integer>();
				int size = next.size;
				for (int i = 0; i < size; i++) {
					temp.push(next.pop());
				}
				for (int i = 0; i < diff; i++) {
					stack.push(temp.pop());
				}
				for (int i = 0; i < size - diff; i++) {
					next.push(temp.pop());
				}
				if (next.size == 0) {
					stacks.remove(index + 1);
				}
				leftShift(index + 1);
			}
		}
	}

	public String toString() {
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (Stack<Integer> stack : stacks) {
			sb.append("Stack: " + cnt++ + " >>> " + stack);
		}
		return sb.toString();
	}

	private Stack<Integer> getLastStack() {
		if (stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}

}
