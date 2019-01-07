package com.github.shriyog.datastructures.stack;

/**
 * @author Shriyog Ingale 25-Apr-2018
 */
public class Node {
	private int element;
	private Node next;

	public Node(int element) {
		this.element = element;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}