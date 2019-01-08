package com.github.shriyog.datastructures.queue;

/**
 * @author Shriyog Ingale 01-May-2018
 */
public interface Queue {

	void enqueue(int element);

	int dequeue();

	int front();

	int rear();

	boolean isEmpty();

	int size();

	void printQueue();

	void emptyQueue();

}
