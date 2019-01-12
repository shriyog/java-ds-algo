package com.github.shriyog.datastructures.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shriyog Ingale 09-Jan-2019
 */
public class TreeTest {

	private BinaryTree tree = new BinaryTree();

	@Before
	public void setup() {
		// tree = new BinaryTree();
		// ______1
		// ___ 2 __3
		// __ 4_5
		// tree.add(1);
		// tree.add(2);
		// tree.add(3);
		// tree.add(4);
		tree.root = new TreeNode(1);
		tree.root.setLeft(new TreeNode(2));
		tree.root.setRight(new TreeNode(3));
		tree.root.getLeft().setLeft(new TreeNode(4));
		tree.root.getLeft().setRight(new TreeNode(5));
	}

	@Test
	public void testPreOrderTraversal() {
		Integer[] expected = { 1, 2, 4, 5, 3 };
		System.out.println("PreOrder: " + tree.preOrder());
		Assert.assertArrayEquals(expected, tree.preOrder().toArray());
	}

	@Test
	public void testInOrderTraversal() {
		Integer[] expected = { 4, 2, 5, 1, 3 };
		System.out.println("InOrder: " + tree.inOrder());
		Assert.assertArrayEquals(expected, tree.inOrder().toArray());
	}

	@Test
	public void testPostOrderTraversal() {
		Integer[] expected = { 4, 5, 2, 3, 1 };
		System.out.println("PostOrder: " + tree.postOrder());
		Assert.assertArrayEquals(expected, tree.postOrder().toArray());
	}

	@Test
	public void testBreadthFirstTraversal() {
		Integer[] expected = { 1, 2, 3, 4, 5 };
		System.out.println("LevelOrder: " + tree.breadthFirst());
		Assert.assertArrayEquals(expected, tree.breadthFirst().toArray());
	}

	@Test
	public void testAdd() {
		tree = new BinaryTree();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		Integer[] expected = { 1, 2, 3, 4, 5 };
		Assert.assertArrayEquals(expected, tree.breadthFirst().toArray());
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
}
