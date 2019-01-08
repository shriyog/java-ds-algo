package com.github.shriyog.datastructures.queue;

/**
 * @author Shriyog Ingale 03-May-2018
 */
public class CircularQueue implements Queue {

	Node front, rear;

	public void enqueue(int element) {
		Node node = new Node(element);
		if (rear == null) {
			front = rear = node;
			node.setNext(node); // single element link it back to itself
		} else {
			rear.setNext(node);
			node.setNext(front);
			rear = node;
		}
	}

	public int dequeue() {
		int element = -1;
		if (front != null) {
			element = front.getElement();
			if (front == rear) // single element
				front = rear = null;
			else {
				front = front.getNext();
				rear.setNext(front);
			}
		} else
			System.out.println("Empty queue");
		return element;
	}

	public int front() {
		int element = -1;
		if (front != null) {
			element = front.getElement();
		} else
			System.out.println("Empty queue");
		return element;
	}

	public int rear() {
		int element = -1;
		if (rear != null) {
			element = rear.getElement();
		} else
			System.out.println("Empty queue");
		return element;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		int size = 0;
		if (front != null) {
			Node curr = front;
			do {
				size++;
				curr = curr.getNext();
			} while (curr != front);
		}
		return size;
	}

	public void printQueue() {
		Node curr = front;
		System.out.print("[ ");
		if (front != null) {
			do {
				System.out.print(curr.getElement() + " ");
				curr = curr.getNext();
			} while (curr != front);
		}
		System.out.println("]");
	}

	public void emptyQueue() {
		front = rear = null;
	}

}
