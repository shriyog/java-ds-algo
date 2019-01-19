package com.github.shriyog.datastructures.graph;

import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Shriyog Ingale 19-Jan-2019
 */
public interface Graph {

	void addVertex(char vertex);

	void addEdge(char start, char end);

	Set<Character> getVertices();

	Set<Entry<Character, Character>> getEdges();

	void printGraph();
}
