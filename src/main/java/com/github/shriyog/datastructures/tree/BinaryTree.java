package com.github.shriyog.datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	public List<Integer> inOrder() {
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

	public List<Integer> preOrder() {
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

	public List<Integer> postOrder() {
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
}