package com.github.shriyog.datastructures.queue;

/**
 * This implementation is based on Linked List and it's not an ideal thing to
 * use. As the operations will be of O(N).
 * 
 * @author Shriyog Ingale 01-May-2018
 */
public class PriorityQueue {

	Node front, rear;

	public void enqueue(int element) {
		Node node = new Node(element);
		if (front == null) {
			front = node;
			rear = front;
		} else {
			rear.setNext(node);
			rear = node;
		}
	}

	public int dequeue() {
		int element = -1;
		if (front != null) {
			Node curr = front, prev = curr, maxNode = curr, maxNodePrev = null;
			while (curr != null) {
				if (curr.getElement() > maxNode.getElement()) {
					maxNode = curr;
					maxNodePrev = prev;
				}
				prev = curr;
				curr = curr.getNext();
			}
			element = maxNode.getElement();
			if (maxNode == front)
				front = front.getNext();
			else
				maxNodePrev.setNext(maxNode.getNext());
		}
		return element;
	}
}