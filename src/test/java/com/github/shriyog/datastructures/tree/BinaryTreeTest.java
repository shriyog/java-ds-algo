package com.github.shriyog.datastructures.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shriyog Ingale 09-Jan-2019
 */
public class BinaryTreeTest {

	private BinaryTree tree = new BinaryTree();

	@Before
	public void setup() {
		// ______1
		// ___ 2 __3
		// __ 4_5
		tree = new BinaryTree();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
	}

	@Test
	public void testAdd() {
		Integer[] expected = { 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals(expected, tree.breadthFirst().toArray());
	}

	@Test
	public void testContains() {
		Assert.assertTrue(tree.contains(5));
		Assert.assertFalse(tree.contains(100));
	}

	@Test
	public void testRemove() {
		tree.remove(2);
		Integer[] expected = { 1, 5, 3, 4 };
		Assert.assertArrayEquals(expected, tree.breadthFirst().toArray());

		tree.remove(3);
		Integer[] expected2 = { 1, 5, 4 };
		Assert.assertArrayEquals(expected2, tree.breadthFirst().toArray());

		tree.remove(1);
		Integer[] expected3 = { 4, 5 };
		Assert.assertArrayEquals(expected3, tree.breadthFirst().toArray());
	}

	// Recursive depth first traversals
	@Test
	public void testPreOrderRecursiveTraversal() {
		Integer[] expected = { 1, 2, 4, 5, 3 };
		System.out.println("PreOrder: " + tree.preOrderRecursive());
		Assert.assertArrayEquals(expected, tree.preOrderRecursive().toArray());
	}

	@Test
	public void testInOrderRecursiveTraversal() {
		Integer[] expected = { 4, 2, 5, 1, 3 };
		System.out.println("InOrder: " + tree.inOrderRecursive());
		Assert.assertArrayEquals(expected, tree.inOrderRecursive().toArray());
	}

	@Test
	public void testPostOrderRecursiveTraversal() {
		Integer[] expected = { 4, 5, 2, 3, 1 };
		System.out.println("PostOrder: " + tree.postOrderRecursive());
		Assert.assertArrayEquals(expected, tree.postOrderRecursive().toArray());
	}

	// Iterative depth first traversals
	@Test
	public void testPreOrderIterativeTraversal() {
		Integer[] expected = { 1, 2, 4, 5, 3 };
		System.out.println("PreOrder: " + tree.preOrderIterative());
		Assert.assertArrayEquals(expected, tree.preOrderIterative().toArray());
	}

	@Test
	public void testInOrderIterativeTraversal() {
		Integer[] expected = { 4, 2, 5, 1, 3 };
		System.out.println("InOrder: " + tree.inOrderIterative());
		Assert.assertArrayEquals(expected, tree.inOrderIterative().toArray());
	}

	// Breadth first traversal
	@Test
	public void testBreadthFirstTraversal() {
		Integer[] expected = { 1, 2, 3, 4, 5 };
		System.out.println("LevelOrder: " + tree.breadthFirst());
		Assert.assertArrayEquals(expected, tree.breadthFirst().toArray());
	}
}
