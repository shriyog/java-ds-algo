package com.github.shriyog.datastructures.queue;

/**
 * @author Shriyog Ingale 01-May-2018
 */
public class LinkedQueue implements Queue {

	Node front, rear;

	public void enqueue(int element) {
		Node node = new Node(element);
		if (rear == null) {
			rear = front = node;
		} else {
			rear.setNext(node);
			rear = node;
		}
	}

	public int dequeue() {
		int element = -1;
		if (front == null) {
			System.out.println("Empty queue");
		} else {
			element = front.getElement();
			front = front.getNext();
		}
		if (front == null)
			rear = null;
		return element;
	}

	public int front() {
		int element = -1;
		if (front == null) {
			System.out.println("Empty queue");
		} else {
			element = front.getElement();
		}
		return element;
	}

	public int rear() {
		int element = -1;
		if (rear == null) {
			System.out.println("Empty queue");
		} else {
			element = rear.getElement();
		}
		return element;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		Node curr = front;
		int count = 0;
		while (curr != null) {
			curr = curr.getNext();
			count++;
		}
		return count;
	}

	public void printQueue() {
		System.out.print("[ ");
		Node curr = front;
		while (curr != null) {
			curr = curr.getNext();
			System.out.print(curr.getElement() + " ");
		}
		System.out.print("]");
	}

	public void emptyQueue() {
		front = rear = null;
	}

}
