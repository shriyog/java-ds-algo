package com.github.shriyog.datastructures.tree;

import java.util.List;

/**
 * @author Shriyog Ingale 17-Oct-2018
 */
public interface Tree {

	void add(int element);

	void remove(int element);

	List<Integer> inOrderRecursive();

	List<Integer> inOrderIterative();

	List<Integer> preOrderRecursive();

	List<Integer> preOrderIterative();

	List<Integer> postOrderRecursive();

	List<Integer> postOrderIterative();

	List<Integer> breadthFirst();

}
