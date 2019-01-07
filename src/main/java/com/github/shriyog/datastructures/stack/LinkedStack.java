package com.github.shriyog.datastructures.stack;

/**
 * @author Shriyog Ingale 25-Apr-2018
 */
public class LinkedStack implements Stack {

	private Node head;

	public boolean push(int element) {
		if (head == null) {
			head = new Node(element);
		} else {
			Node node = new Node(element);
			node.setNext(head);
			head = node;
		}
		return true;
	}

	public int pop() {
		int element = -1;
		if (head != null) {
			element = head.getElement();
			head = head.getNext();
		} else
			System.out.println("Stack is Empty");
		return element;
	}

	public int peek() {
		int element = -1;
		if (head != null) {
			element = head.getElement();
		} else
			System.out.println("Stack is Empty");
		return element;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		int count = 0;
		Node curr = head;
		while (curr != null) {
			count++;
			curr = curr.getNext();
		}
		return count;
	}

	public void printStack() {
		System.out.print("[ ");
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.getElement() + " ");
			curr = curr.getNext();
		}
		System.out.println("]");
	}

	public void emptyStack() {
		head = null;
	}

}
