package com.github.shriyog.datastructures.queue;

/**
 * @author Shriyog Ingale 01-May-2018
 */
public class ArrayQueue implements Queue {

	int[] queue;
	int front = -1, rear = -1, size = 0;

	public ArrayQueue(int size) {
		queue = new int[size];
	}

	public void enqueue(int element) {
		if (rear == queue.length - 1) {
			System.out.println("Queue overflow");
		} else {
			queue[++rear] = element;
			size++;
		}
		if (front == -1)
			front++;
	}

	public int dequeue() {
		if (size > 0) {
			size--;
			return queue[front++];
		} else {
			System.out.println("Empty queue");
			return -1;
		}
	}

	public int front() {
		if (size > 0) {
			return queue[front];
		} else {
			System.out.println("Empty queue");
			return -1;
		}
	}

	public int rear() {
		if (size > 0) {
			return queue[rear];
		} else {
			System.out.println("Empty queue");
			return -1;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printQueue() {
		System.out.print("[ ");
		for (int i = front; i <= rear && i < queue.length; i++)
			System.out.print(queue[i] + " ");
		System.out.println("]");
	}

	public void emptyQueue() {
		front = rear = -1;
		size = 0;
	}

}
