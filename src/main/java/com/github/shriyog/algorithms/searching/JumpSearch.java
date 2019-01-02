package com.github.shriyog.algorithms.searching;

/**
 * @author Shriyog Ingale 17-Jan-2018
 * 
 *         https://www.geeksforgeeks.org/jump-search/
 */
public class JumpSearch {

	public static void main(String[] args) {
		int[] input = { 2, 4, 5, 7, 8, 9, 10 };
		System.out.println(jumpSearch(input, 1));
	}

	public static int jumpSearch(int[] input, int key) {

		int blockSize = (int) Math.floor(Math.sqrt(input.length));
		int i;
		for (i = 0; i < input.length; i += blockSize) {
			if (key < input[i] && i > 0) {
				for (int j = i - blockSize; j < i; j++) {
					if (input[j] == key)
						return j;
				}
			}
		}

		for (int k = i - blockSize; k < input.length; k++) {
			if (key == input[k])
				return k;
		}
		return -1;
	}
}
