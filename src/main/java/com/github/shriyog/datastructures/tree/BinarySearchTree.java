package com.github.shriyog.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shriyog Ingale 15-Jan-2019
 */
public class BinarySearchTree {

	private TreeNode root;

	public void add(int element) {
		if (root == null) {
			root = new TreeNode(element);
			return;
		}
		TreeNode current = root, parent = root;
		while (current != null) {
			parent = current;
			if (element < current.getElement()) {
				current = current.getLeft();
			} else if (element > current.getElement()) {
				current = current.getRight();
			} else {
				// Element exists
				return;
			}
		}

		if (element < parent.getElement()) {
			parent.setLeft(new TreeNode(element));
		} else {
			parent.setRight(new TreeNode(element));
		}
	}

	public boolean contains(int element) {
		if (root == null) {
			return false;
		}

		TreeNode current = root;
		while (current != null) {
			if (element == current.getElement()) {
				return true;
			} else if (element < current.getElement()) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return false;
	}

	public int findMin() {
		if (root == null)
			return -1;

		TreeNode current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current.getElement();
	}

	public int findMax() {
		if (root == null)
			return -1;

		TreeNode current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current.getElement();
	}

	public void remove(int element) {
		if (root == null) {
			return;
		}

		TreeNode current = root, parent = root;
		// Find the element to be removed
		while (current != null) {
			parent = current;
			if (element == current.getElement()) {
				break;
			} else if (element < current.getElement()) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}

		if (current == null) {
			System.out.println("Element doesn't exists");
			// Element doesn't exists
			return;
		}

		if (current.getLeft() != null && current.getRight() != null) {
			// both child present
			// find max in left subtree
			TreeNode tmp = current.getLeft(), prev = current;
			while (tmp.getRight() != null) {
				prev = tmp;
				tmp = tmp.getRight();
			}
			current.setElement(tmp.getElement());
			if (tmp.getElement() > prev.getElement())
				prev.setRight(null);
			else
				prev.setLeft(null);

		} else if (current.getLeft() != null) {
			// left child present
			if (current.getElement() < parent.getElement()) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else if (current.getRight() != null) {
			// right child present
			if (current.getElement() < parent.getElement()) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else {
			// no child present
			if (current.getElement() < parent.getElement()) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(20);
		bst.add(10);
		bst.add(30);
		bst.add(5);
		bst.add(15);
		bst.add(25);
		bst.add(50);
		bst.add(15);

		System.out.println(bst.inOrderIterative());
		bst.remove(10);
		System.out.println(bst.inOrderIterative());

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

}
