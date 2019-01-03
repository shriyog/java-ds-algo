package com.github.shriyog.datastructures.linkedlist;

/**
 * @author Shriyog Ingale 04-Feb-2018
 */
public class SinglyLinkedList implements List {

	private Node head;

	// Zero based indexing. [10, 20] add(30, 2) doesn't add at end.
	public void add(int element, int index) {
		if (head == null) {
			head = new Node(element);
		} else {
			if (index == 0)
				addFirst(element);
			else {
				Node current = head, previous = head;
				int count = 0;
				while (count < index && current != null) {
					previous = current;
					current = current.getNext();
					count++;
				}
				// (index == count) check is for add at last
				if (current != null) {
					Node node = new Node(element);
					node.setNext(current);
					previous.setNext(node);
				}
			}
		}
	}

	public void addFirst(int element) {
		if (head == null) {
			head = new Node(element);
		} else {
			Node node = new Node(element);
			node.setNext(head);
			head = node;
		}
	}

	public void addLast(int element) {
		if (head == null) {
			head = new Node(element);
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			Node node = new Node(element);
			current.setNext(node);
		}
	}

	public int remove(int index) {
		int element = -1, count = 0;
		if (head != null) {
			if (index == 0)
				return removeFirst();
			else {
				Node current = head, previous = head;
				while (count < index && current != null) {
					previous = current;
					current = current.getNext();
					count++;
				}
				if (current != null) {
					element = current.getElement();
					previous.setNext(current.getNext());
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
		}
		return element;
	}

	public int removeLast() {
		int element = -1;
		if (head != null) {
			Node current = head, previous = null;
			while (current.getNext() != null) {
				previous = current;
				current = current.getNext();
			}
			element = current.getElement();
			if (previous == null) // single element
				head = null;
			else
				previous.setNext(null);
		}
		return element;
	}

	public int size() {
		int size = 0;
		Node current = head;
		while (current != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}

	public void emptyList() {
		head = null;
	}

	public void printList() {
		Node current = head;
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
			Node current = head;
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

}
