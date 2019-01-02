package com.github.shriyog.algorithms.searching;

/**
 * @author Shriyog Ingale 16-Jan-2018
 * 
 *         https://www.geeksforgeeks.org/binary-search/
 */
public class BinarySearch {

	public static int binarySearch(int[] input, int key) {

		int left = 0, right = input.length - 1, mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			if (key < input[mid])
				right = mid - 1;
			else if (key > input[mid])
				left = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static int binarySearchRecursive(int[] input, int key, int left, int right) {

		if (left > right)
			return -1;

		int mid = (left + right) / 2;

		if (key < input[mid])
			return binarySearchRecursive(input, key, left, mid - 1);
		else if (key > input[mid])
			return binarySearchRecursive(input, key, mid + 1, right);
		else
			return mid;

	}

}
