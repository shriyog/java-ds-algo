package com.github.shriyog.datastructures.stack;

/**
 * @author Shriyog Ingale 25-Apr-2018
 */
public interface Stack {

	boolean push(int element);

	int pop();

	int peek();

	boolean isEmpty();

	int size();

	void printStack();

	void emptyStack();

}
