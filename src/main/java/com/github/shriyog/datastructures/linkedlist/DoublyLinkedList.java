package com.github.shriyog.datastructures.linkedlist;

/**
 * @author Shriyog Ingale 06-Feb-2018
 */
public class DoublyLinkedList implements List {

	private DNode head;

	// Zero based indexing. [10, 20] add(30, 2) doesn't add at end
	public void add(int element, int index) {
		if (head == null) {
			head = new DNode(element);
		} else {
			if (index == 0)
				addFirst(element);
			else {
				DNode current = head, previous = head;
				int count = 0;
				while (count < index && current != null) {
					previous = current;
					current = current.getNext();
					count++;
				}
				if (current != null) {
					DNode node = new DNode(element);
					node.setNext(current);
					node.setPrevious(previous);
					previous.setNext(node);
					current.setPrevious(node);
				}
			}
		}
	}

	public void addFirst(int element) {
		if (head == null) {
			head = new DNode(element);
		} else {
			DNode node = new DNode(element);
			node.setNext(head);
			head.setPrevious(node);
			head = node;
		}
	}

	public void addLast(int element) {
		if (head == null) {
			head = new DNode(element);
		} else {
			DNode current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			if (current != null) {
				DNode node = new DNode(element);
				node.setPrevious(current);
				current.setNext(node);
			}
		}
	}

	public int remove(int index) {
		int element = -1;
		if (head != null) {
			if (index == 0)
				return removeFirst();
			else {
				DNode current = head, previous = head;
				int count = 0;
				while (count < index && current != null) {
					previous = current;
					current = current.getNext();
					count++;
				}
				if (current != null) {
					element = current.getElement();
					previous.setNext(current.getNext());
					if (current.getNext() != null)
						current.getNext().setPrevious(previous);
				}
			}
		}
		return element;
	}

	public int removeFirst() {
		int element = -1;
		if (head != null) {
			element = head.getElement();
			head = head.getNext();
			if (head != null)
				head.setPrevious(null);
		}
		return element;
	}

	public int removeLast() {
		int element = -1;
		if (head != null) {
			DNode current = head, previous = null;
			while (current.getNext() != null) {
				previous = current;
				current = current.getNext();
			}
			element = current.getElement();
			// Single element
			if (previous == null)
				head = null;
			else
				previous.setNext(null);
		}
		return element;
	}

	public int size() {
		int size = 0;
		DNode current = head;
		while (current != null) {
			current = current.getNext();
			size++;
		}
		return size;
	}

	public void printList() {
		DNode current = head;
		System.out.print("[ ");
		while (current != null) {
			System.out.print(current.getElement() + " ");
			current = current.getNext();
		}
		System.out.print("]\n");
	}

	public int get(int index) {
		int value = -1;
		if (head != null) {
			DNode current = head;
			int count = 0;
			while (count < index && current != null) {
				current = current.getNext();
				count++;
			}
			if (current != null)
				value = current.getElement();
		}
		return value;
	}

	public void emptyList() {
		head = null;
	}

}
