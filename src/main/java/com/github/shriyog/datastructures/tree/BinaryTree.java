package com.github.shriyog.datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Shriyog Ingale 10-Jan-2018
 */
public class BinaryTree implements Tree {

	public TreeNode root;

	public void add(int element) {
		if (root == null) {
			root = new TreeNode(element);
			return;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(this.root);
		TreeNode current;

		while (!queue.isEmpty()) {
			current = queue.remove();
			if (current.getLeft() == null) {
				current.setLeft(new TreeNode(element));
				break;
			} else {
				queue.add(current.getLeft());
			}

			if (current.getRight() == null) {
				current.setRight(new TreeNode(element));
				break;
			} else {
				queue.add(current.getRight());
			}
		}
	}

	/**
	 * Removes specified node by replacing its data with the last node's data
	 * and then deleting last node. Using BFS to find parent of last node.
	 */
	public void remove(int element) {
		TreeNode target = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(this.root);
		TreeNode current = root, previous = current, lastParent = null;

		while (!queue.isEmpty()) {
			previous = current;
			current = queue.remove();
			if (current.getElement() == element)
				target = current;
			if (current.getLeft() == null && current.getRight() == null && lastParent == null) {
				lastParent = previous;
			}
			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}
			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
		}

		if (lastParent.getRight() != null) {
			target.setElement(lastParent.getRight().getElement());
			lastParent.setRight(null);
		} else {
			target.setElement(lastParent.getLeft().getElement());
			lastParent.setLeft(null);
		}
	}

	public List<Integer> preOrderRecursive() {
		List<Integer> list = new ArrayList<Integer>();
		preOrderRecursive(this.root, list);
		return list;
	}

	private void preOrderRecursive(TreeNode root, List<Integer> list) {
		if (root != null) {
			list.add(root.getElement());
			preOrderRecursive(root.getLeft(), list);
			preOrderRecursive(root.getRight(), list);
		}
	}

	public List<Integer> inOrderRecursive() {
		List<Integer> list = new ArrayList<Integer>();
		inOrderRecursive(this.root, list);
		return list;
	}

	private void inOrderRecursive(TreeNode root, List<Integer> list) {
		if (root != null) {
			inOrderRecursive(root.getLeft(), list);
			list.add(root.getElement());
			inOrderRecursive(root.getRight(), list);
		}
	}

	public List<Integer> postOrderRecursive() {
		List<Integer> list = new ArrayList<Integer>();
		postOrderRecursive(this.root, list);
		return list;
	}

	private void postOrderRecursive(TreeNode root, List<Integer> list) {
		if (root != null) {
			postOrderRecursive(root.getLeft(), list);
			postOrderRecursive(root.getRight(), list);
			list.add(root.getElement());
		}
	}

	public List<Integer> breadthFirst() {
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode current;
		queue.add(this.root);
		while (!queue.isEmpty()) {
			current = queue.remove();
			list.add(current.getElement());

			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}
			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
		}
		return list;
	}

	public List<Integer> preOrderIterative() {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;

		while (true) {
			while (current != null) {
				list.add(current.getElement());
				stack.push(current);
				current = current.getLeft();
			}
			if (stack.isEmpty())
				break;
			current = stack.pop();
			current = current.getRight();
		}
		return list;
	}

	public List<Integer> inOrderIterative() {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;

		while (true) {
			while (current != null) {
				stack.push(current);
				current = current.getLeft();
			}
			if (stack.isEmpty())
				break;
			current = stack.pop();
			list.add(current.getElement());
			current = current.getRight();
		}
		return list;
	}

	/**
	 * TODO Implementation
	 */
	public List<Integer> postOrderIterative() {
		return null;
	}
}
