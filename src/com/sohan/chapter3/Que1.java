package com.sohan.chapter3;

/** Describe how you could use a single array to implement three stacks. */
public class Que1 {

	public static void main(String[] args) {
		FlexibleStackUsingArray stack = new FlexibleStackUsingArray(3);
		System.out.println(stack);
		stack.push(1, 11);
		System.out.println(stack);
		stack.push(1, 12);
		System.out.println(stack);
		stack.push(1, 13);
		System.out.println(stack);
		stack.pop(1);
		System.out.println(stack);
		stack.push(1, 14);
		System.out.println(stack);
		stack.push(1, 15);
		System.out.println(stack);
		stack.push(1, 16);
		System.out.println(stack);
		stack.push(1, 17);
		System.out.println(stack);
		stack.push(1, 18);
		System.out.println(stack);
	}

}

class StackUsingArray {
	int noOfStacks = 3;
	int[] stackPointer = { -1, -1, -1 };
	int size;
	int[] arr;

	StackUsingArray(int size) {
		this.size = size;
		arr = new int[size * noOfStacks];
	}

	public void push(int stackNum, int obj) {
		if (stackPointer[stackNum] + 1 >= size) {
			throw new RuntimeException("Out of space in stack " + stackNum);
		}
		stackPointer[stackNum]++;
		arr[topOfStack(stackNum)] = obj;
	}

	public int pop(int stackNum) {
		if (stackPointer[stackNum] == -1) {
			throw new RuntimeException("No elements in stack " + stackNum);
		}
		int data = arr[topOfStack(stackNum)];
		arr[topOfStack(stackNum)] = 0;
		stackPointer[stackNum]--;
		return data;
	}

	private int topOfStack(int stackNum) {
		return stackNum * size + stackPointer[stackNum];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i % size == 0) {
				sb.append(" | ");
			}
			sb.append(arr[i]).append(" ");
		}
		return sb.toString();
	}

}

class StackData {
	int size = 0;
	int pointer;
	int start;
	int capacity;

	StackData(int start, int capacity) {
		this.pointer = start - 1;
		this.start = start;
		this.capacity = capacity;
	}

	public boolean isWithInStack(int index, int totalSize) {
		return (start <= index && index < start + capacity)
				|| (start + capacity >= totalSize && index < (start + capacity) % totalSize);
	}
}

class FlexibleStackUsingArray {
	int noOfStacks = 3;
	int size;
	int[] arr;
	StackData[] stacks;

	public FlexibleStackUsingArray(int size) {
		this.size = size;
		arr = new int[size * noOfStacks];
		stacks = new StackData[] { new StackData(0, size), new StackData(size, size), new StackData(2 * size, size) };
	}

	public void push(int stackNum, int data) {
		StackData stack = stacks[stackNum];
		if (stack.size >= stack.capacity) {
			if (numberOfElements() >= arr.length) {
				throw new RuntimeException("Out of space in stack " + stackNum);
			} else {
				expand(stackNum);
			}
		}
		stack.size++;
		stack.pointer = nextElement(stack.pointer);
		arr[stack.pointer] = data;
	}

	public int pop(int stackNum) {
		StackData stack = stacks[stackNum];
		if (stack.size == 0) {
			throw new RuntimeException("No elements in stack " + stackNum);
		}
		int data = arr[stack.pointer];
		arr[stack.pointer] = 0;
		stack.pointer = prevElement(stack.pointer);
		stack.size--;
		return data;
	}

	public int peek(int stackNum) {
		StackData stack = stacks[stackNum];
		return arr[stack.pointer];
	}

	private int numberOfElements() {
		return stacks[0].size + stacks[1].size + stacks[2].size;
	}

	private int nextElement(int index) {
		return index + 1 == arr.length ? 0 : index + 1;
	}

	private int prevElement(int index) {
		return index == 0 ? arr.length - 1 : index - 1;
	}

	private void expand(int stackNum) {
		shiftElements((stackNum + 1) % noOfStacks);
		stacks[stackNum].capacity++;
	}

	private void shiftElements(int stackNum) {
		StackData stack = stacks[stackNum];
		if (stack.size >= stack.capacity) {
			int nextStack = (stackNum + 1) % noOfStacks;
			shiftElements(nextStack);
			stack.capacity++;
		}

		for (int i = (stack.start + stack.size) % arr.length; stack.isWithInStack(i, arr.length);) {
			int prevIdx = prevElement(i);
			arr[i] = arr[prevIdx];
			i = prevIdx;
		}

		arr[stack.start] = 0;
		stack.start = nextElement(stack.start);
		stack.pointer = nextElement(stack.pointer);
		stack.capacity--;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int stackNum = 1;
		StackData stack = stacks[stackNum];
		for (int i = 0; i < arr.length; i++) {
			if (stackNum < 3 && i == stack.start) {
				sb.append(" | ");
				stackNum++;
			}
			sb.append(arr[i]).append(" ");
		}
		return sb.toString();
	}
}