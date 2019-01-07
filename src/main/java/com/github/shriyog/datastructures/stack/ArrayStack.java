package com.github.shriyog.datastructures.stack;

/**
 * @author Shriyog Ingale 25-Apr-2018
 */
public class ArrayStack implements Stack {

	int[] stack;
	int top = -1;

	public ArrayStack() {
		stack = new int[5];
	}

	public ArrayStack(int size) {
		stack = new int[size];
	}

	public boolean push(int element) {
		if (top == stack.length - 1) {
			System.out.println("Stack overflow");
			return false;
		}
		stack[++top] = element;
		return true;
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return stack[top--];
	}

	public int peek() {
		if (top == -1) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return stack[top];
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public int size() {
		return top + 1;
	}

	public void printStack() {
		System.out.print("[ ");
		for (int i = top; i >= 0; i--) {
			System.out.print(stack[i] + " ");
		}
		System.out.println("]");
	}

	public void emptyStack() {
		top = -1;
	}

}
