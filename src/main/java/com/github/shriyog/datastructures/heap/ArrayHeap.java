package com.github.shriyog.datastructures.heap;

/**
 * Min Binary Heap implementation using array.
 * 
 * @author Shriyog Ingale 17-Jan-2019
 */
public class ArrayHeap implements Heap {

	private int[] array = new int[10];
	private int lastIndex = -1;

	public void add(int element) {
		array[++lastIndex] = element;
		int current = lastIndex, parent;
		while (current > 0) {
			parent = (current - 1) / 2;
			if (array[current] >= array[parent])
				break;
			int tmp = array[current];
			array[current] = array[parent];
			array[parent] = tmp;
			current = parent;
		}
	}

	public int peek() {
		if (lastIndex == -1)
			return -1;
		else
			return array[0];
	}

	public int poll() {
		if (lastIndex == -1)
			return -1;
		int result = array[0];
		array[0] = array[lastIndex--];
		int current = 0, minIndex, left, right;

		while (true) {
			left = 2 * current + 1;
			right = 2 * current + 2;
			minIndex = current;
			if (left <= lastIndex && array[left] < array[current]) {
				minIndex = left;
			}
			if (right <= lastIndex && array[right] < array[minIndex]) {
				minIndex = right;
			}
			if (array[current] <= array[minIndex])
				break;

			int tmp = array[minIndex];
			array[minIndex] = array[current];
			array[current] = tmp;

			current = minIndex;
		}
		return result;
	}
}
