package com.github.shriyog.datastructures.tree;

import java.util.List;

/**
 * @author Shriyog Ingale 17-Oct-2018
 */
public interface Tree {

	void add(int element);

	void remove(int element);

	List<Integer> inOrder();

	List<Integer> preOrder();

	List<Integer> postOrder();

	List<Integer> breadthFirst();

}
