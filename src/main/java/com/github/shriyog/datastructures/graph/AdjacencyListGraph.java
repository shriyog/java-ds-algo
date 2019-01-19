package com.github.shriyog.datastructures.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Shriyog Ingale 19-Jan-2019
 */
public class AdjacencyListGraph {

	private Map<Vertex, List<Edge>> vertices = new HashMap<>();

	void addVertex(String element) {
		vertices.put(new Vertex(element), new ArrayList<>());
	}

	void addEdge(String start, String end, int weight) {
		List<Edge> edges = vertices.get(new Vertex(start));
		edges.add(new Edge(weight, new Vertex(end)));
	}

	Set<Vertex> getVertices() {
		return vertices.keySet();
	}

	Set<Entry<Vertex, Vertex>> getEdges() {
		Set<Entry<Vertex, Vertex>> edgeSet = new HashSet<>();
		for (Entry<Vertex, List<Edge>> entry : vertices.entrySet()) {
			for (Edge edge : entry.getValue()) {
				edgeSet.add(new SimpleEntry<>(entry.getKey(), edge.getDestination()));
			}
		}
		return edgeSet;
	}

	void printGraph() {
		for (Entry<Vertex, List<Edge>> entry : vertices.entrySet()) {
			for (Edge edge : entry.getValue()) {
				System.out.println(entry.getKey() + " -> " + edge.getDestination());
			}
		}
	}
}
