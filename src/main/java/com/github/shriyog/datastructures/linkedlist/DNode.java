package com.github.shriyog.datastructures.linkedlist;

/**
 * @author Shriyog Ingale 06-Feb-2018
 */
public class DNode {

	private int element;
	private DNode next;
	private DNode previous;

	public DNode(int element) {
		this.element = element;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public DNode getPrevious() {
		return previous;
	}

	public void setPrevious(DNode previous) {
		this.previous = previous;
	}

}
