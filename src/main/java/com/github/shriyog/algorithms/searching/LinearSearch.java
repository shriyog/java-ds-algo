package com.github.shriyog.algorithms.searching;

/**
 * @author Shriyog Ingale 16-Jan-2018
 * 
 *         https://www.geeksforgeeks.org/linear-search/
 */
public class LinearSearch {

	public static void main(String[] args) {
		int[] input = { 2, 4, 5, 7, 8, 9, 10 };
		System.out.println(linearSearch(input, 0));
	}

	public static int linearSearch(int[] input, int key) {
		for (int i = 0; i < input.length; i++) {
			if (input[i] == key)
				return i;
		}
		return -1;
	}
}
