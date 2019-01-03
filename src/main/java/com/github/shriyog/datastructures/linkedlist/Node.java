package com.github.shriyog.datastructures.linkedlist;

/**
 * @author Shriyog Ingale
 * 04-Feb-2018
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
