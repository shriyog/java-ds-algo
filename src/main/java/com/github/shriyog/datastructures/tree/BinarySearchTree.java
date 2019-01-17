package com.github.shriyog.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shriyog Ingale 15-Jan-2019
 */
public class BinarySearchTree implements Tree {

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
				// element already exists
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

	public void remove(int element) {
		if (root == null) {
			return;
		}
		TreeNode current = root, parent = root, childAttachment = null;
		// find the element to be removed
		while (current != null) {
			if (element == current.getElement()) {
				break;
			} else if (element < current.getElement()) {
				parent = current;
				current = current.getLeft();
			} else {
				parent = current;
				current = current.getRight();
			}
		}
		if (current == null) {
			System.out.println("Element doesn't exists");
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
			if (tmp.getElement() < prev.getElement())
				prev.setLeft(null);
			else
				prev.setRight(null);
			current.setElement(tmp.getElement());
			return;
		} else if (current.getLeft() != null) {
			// left child present
			childAttachment = current.getLeft();
		} else if (current.getRight() != null) {
			// right child present
			childAttachment = current.getRight();
		} else {
			// no child present
			childAttachment = null;
		}

		// attach childAttachment to parent
		if (current.getElement() < parent.getElement()) {
			parent.setLeft(childAttachment);
		} else {
			parent.setRight(childAttachment);
		}
	}

	/**
	 * Iterative depth first inorder traversal.
	 * 
	 * @return list of element in BST which is already sorted.
	 */
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
