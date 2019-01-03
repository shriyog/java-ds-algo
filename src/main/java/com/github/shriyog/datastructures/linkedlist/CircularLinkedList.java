package com.github.shriyog.datastructures.linkedlist;

/**
 * @author Shriyog Ingale 06-Feb-2018
 */
public class CircularLinkedList implements List {

	private Node head;

	// Zero based indexing. [10, 20] add(30, 2) doesn't add at end
	public void add(int element, int index) {
		if (head == null) {
			head = new Node(element);
			head.setNext(head);
		} else {
			if (index == 0)
				addFirst(element);
			else {
				int count = 0;
				Node current = head, previous = head;
				do {
					previous = current;
					current = current.getNext();
					count++;
				} while (count < index && current != head);
				if (current != head) {
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
			head.setNext(head);
		} else {
			Node current = head, previous = head;
			do {
				previous = current;
				current = current.getNext();
			} while (current != head);
			Node node = new Node(element);
			previous.setNext(node);
			node.setNext(head);
			head = node;
		}
	}

	public void addLast(int element) {
		if (head == null) {
			head = new Node(element);
			head.setNext(head);
		} else {
			Node current = head, previous = head;
			do {
				previous = current;
				current = current.getNext();
			} while (current != head);
			Node node = new Node(element);
			previous.setNext(node);
			node.setNext(head);
		}
	}

	public int remove(int index) {
		int element = -1;
		if (head != null) {
			if (index == 0)
				return removeFirst();
			else {
				Node current = head, previous = head;
				int count = 0;
				do {
					previous = current;
					current = current.getNext();
					count++;
				} while (count < index && current != head);
				if (current != head) {
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
			Node current = head, previous = head;
			do {
				previous = current;
				current = current.getNext();
			} while (current != head);
			element = head.getElement();
			if (previous == head) // single element
				head = null;
			else {
				previous.setNext(head.getNext());
				head = head.getNext();
			}
		}
		return element;
	}

	public int removeLast() {
		int element = -1;
		if (head != null) {
			Node current = head, previous = head, prePrevious;
			do {
				prePrevious = previous;
				previous = current;
				current = current.getNext();
			} while (current != head);
			element = previous.getElement();
			if (previous == head)
				head = null;
			else {
				prePrevious.setNext(head);
			}
		}
		return element;
	}

	public int size() {
		int count = 0;
		if (head != null) {
			Node current = head;
			do {
				current = current.getNext();
				count++;
			} while (current != head);
		}
		return count;
	}

	public void printList() {
		if (head != null) {
			Node current = head;
			System.out.print("[ ");
			do {
				System.out.print(current.getElement() + " ");
				current = current.getNext();
			} while (current != head);
			System.out.print("]\n");
		} else
			System.out.println("List is empty");
	}

	public void emptyList() {
		head = null;
	}

	public int get(int index) {
		int count = 0, value = -1;
		if (head != null) {
			Node current = head;
			do {
				if (count == index) {
					value = current.getElement();
					break;
				}
				current = current.getNext();
				count++;
			} while (current != head);
		}
		return value;
	}

}
