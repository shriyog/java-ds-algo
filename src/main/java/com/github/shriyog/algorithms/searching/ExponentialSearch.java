package com.github.shriyog.algorithms.searching;

/**
 * @author Shriyog Ingale 17-Jan-2018
 * 
 *         https://www.geeksforgeeks.org/exponential-search/
 */
public class ExponentialSearch {

	public static int exponentialSearch(int[] input, int key) {

		if (input[0] == key)
			return 0;

		int i = 1;
		while (i < input.length && key > input[i]) {
			i = i * 2;
		}

		System.out.println(i);
		return BinarySearch.binarySearchRecursive(input, key, i / 2, Math.min(i, input.length - 1));
	}

}
