package com.github.shriyog.datastructures.tree;

/**
 * @author Shriyog Ingale 15-Jan-2019
 */
public class BinarySearchTree extends BinaryTree {

	@Override
	public void add(int element) {
		if (root == null) {
			root = new TreeNode(element);
			return;
		}
		TreeNode current = root;
		while (true) {
			if (element < current.getElement()) {
				if (current.getLeft() == null) {
					current.setLeft(new TreeNode(element));
					break;
				}
				current = current.getLeft();
			} else {
				if (current.getRight() == null) {
					current.setRight(new TreeNode(element));
					break;
				}
				current = current.getRight();
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

		System.out.println(bst.breadthFirst());
	}

}
