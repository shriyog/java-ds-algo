package com.github.shriyog.datastructures.tree;

/**
 * @author Shriyog Ingale 17-Oct-2018
 */
public class TreeNode {

	private TreeNode left, right;
	private int element;

	public TreeNode(int element) {
		left = right = null;
		this.element = element;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}
}
