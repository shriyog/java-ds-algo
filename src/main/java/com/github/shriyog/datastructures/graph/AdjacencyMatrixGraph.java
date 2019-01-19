package com.github.shriyog.datastructures.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Adjacency Matrix representation of Graph. Dynamic vertex addition is
 * supported. Creates a matrix with edge represented by 1 else 0.
 * 
 * @author Shriyog Ingale 19-Jan-2019
 */
public class AdjacencyMatrixGraph implements Graph {

	private Map<Character, Map<Character, Integer>> matrix = new HashMap<>();

	public void addVertex(char vertex) {
		Map<Character, Integer> elements = new HashMap<Character, Integer>();
		for (Character key : matrix.keySet()) {
			elements.put(key, 0);
		}
		matrix.put(vertex, elements);
		for (Character key : matrix.keySet()) {
			matrix.get(key).put(vertex, 0);
		}
	}

	public void addEdge(char start, char end) {
		matrix.get(start).put(end, 1);
	}

	public void printGraph() {
		matrix.entrySet().stream().forEach(start -> {
			start.getValue().entrySet().stream().filter(edge -> edge.getValue() > 0)
					.forEach(end -> System.out.println(start.getKey() + " -> " + end.getKey()));
		});
	}

	public Set<Character> getVertices() {
		return matrix.keySet();
	}

	public Set<Entry<Character, Character>> getEdges() {
		return matrix.entrySet().stream().map(start -> {
			return start.getValue().entrySet().stream().filter(edge -> edge.getValue() == 1).map(end -> {
				return new SimpleEntry<>(start.getKey(), end.getKey());
			}).collect(Collectors.toSet());
		}).flatMap(Set::stream).collect(Collectors.toSet());
	}
}