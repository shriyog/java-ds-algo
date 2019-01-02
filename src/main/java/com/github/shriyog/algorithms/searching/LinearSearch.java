package com.github.shriyog.algorithms.searching;

/**
 * @author Shriyog Ingale 16-Jan-2018
 * 
 *         https://www.geeksforgeeks.org/linear-search/
 */
public class LinearSearch {

	public static int linearSearch(int[] input, int key) {
		for (int i = 0; i < input.length; i++) {
			if (input[i] == key)
				return i;
		}
		return -1;
	}
}
