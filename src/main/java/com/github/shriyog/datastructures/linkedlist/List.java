package com.github.shriyog.datastructures.linkedlist;

/**
 * @author Shriyog Ingale 04-Feb-2018
 */
public interface List {

	void add(int element, int index);

	void addFirst(int element);

	void addLast(int element);

	int remove(int index);

	int removeFirst();

	int removeLast();

	int get(int index);

	int size();

	void printList();

	void emptyList();
}
