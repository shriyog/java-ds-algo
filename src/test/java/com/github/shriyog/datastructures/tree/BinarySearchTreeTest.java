package com.github.shriyog.datastructures.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shriyog Ingale 17-Jan-2019
 */
public class BinarySearchTreeTest {

	BinarySearchTree bst = new BinarySearchTree();

	@Before
	public void setup() {
		// ______20
		// ___ 10 __30
		// __ 5_15_25_50
		// ____8__23_____

		bst.add(20);
		bst.add(10);
		bst.add(30);
		bst.add(5);
		bst.add(8);
		bst.add(15);
		bst.add(25);
		bst.add(23);
		bst.add(50);
		bst.add(15);
	}

	@Test
	public void testAdd() {
		Integer[] expected = { 5, 8, 10, 15, 20, 23, 25, 30, 50 };
		System.out.println("BST: " + bst.inOrderIterative());
		Assert.assertArrayEquals(expected, bst.inOrderIterative().toArray());
	}

	@Test
	public void testContains() {
		Assert.assertTrue(bst.contains(8));
		Assert.assertFalse(bst.contains(100));
	}

	@Test
	public void testRemoveWhenTargetHasNoChild() {
		bst.remove(8);
		Integer[] expected = { 5, 10, 15, 20, 23, 25, 30, 50 };
		System.out.println("BST: " + bst.inOrderIterative());
		Assert.assertArrayEquals(expected, bst.inOrderIterative().toArray());
	}

	@Test
	public void testRemoveWhenTargetHasOnlyLeftChild() {
		bst.remove(25);
		Integer[] expected = { 5, 8, 10, 15, 20, 23, 30, 50 };
		System.out.println("BST: " + bst.inOrderIterative());
		Assert.assertArrayEquals(expected, bst.inOrderIterative().toArray());
	}

	@Test
	public void testRemoveWhenTargetHasOnlyRightChild() {
		bst.remove(5);
		Integer[] expected = { 8, 10, 15, 20, 23, 25, 30, 50 };
		System.out.println("BST: " + bst.inOrderIterative());
		Assert.assertArrayEquals(expected, bst.inOrderIterative().toArray());
	}

	@Test
	public void testRemoveWhenTargetHasBothChilds() {
		bst.remove(10);
		Integer[] expected = { 5, 8, 15, 20, 23, 25, 30, 50 };
		System.out.println("BST: " + bst.inOrderIterative());
		Assert.assertArrayEquals(expected, bst.inOrderIterative().toArray());
	}
}
