package com.github.shriyog.algorithms.searching;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchingTest {

	int[] input = { 2, 4, 5, 7, 8, 9, 10 };
	int targetKey = 8;
	int expected = 4;

	@Test
	public void testLinearSearch() {
		assertEquals(expected, LinearSearch.linearSearch(input, targetKey));
		assertEquals(-1, LinearSearch.linearSearch(input, 1000));
	}

	@Test
	public void testBinarySearch() {
		assertEquals(expected, BinarySearch.binarySearch(input, targetKey));
		assertEquals(-1, BinarySearch.binarySearch(input, 1000));
	}

	@Test
	public void testBinarySearchRecursive() {
		assertEquals(expected, BinarySearch.binarySearchRecursive(input, targetKey, 0, input.length - 1));
		assertEquals(-1, BinarySearch.binarySearchRecursive(input, 1000, 0, input.length - 1));
	}

	@Test
	public void testExponentialSearch() {
		assertEquals(expected, ExponentialSearch.exponentialSearch(input, targetKey));
		assertEquals(-1, ExponentialSearch.exponentialSearch(input, 1000));
	}

	@Test
	public void testJumpSearch() {
		assertEquals(expected, JumpSearch.jumpSearch(input, targetKey));
		assertEquals(-1, JumpSearch.jumpSearch(input, 1000));
	}

}
