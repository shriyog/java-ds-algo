package com.github.shriyog.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shriyog Ingale 19-Jan-2019
 */
public class AdjacencyListGraph {

	Map<Vertex, List<Edge>> vertices;

	public AdjacencyListGraph() {
		vertices = new HashMap<>();
	}

	void addVertex(String element) {
		Vertex vertex = new Vertex(element);
		vertices.put(vertex, new ArrayList<>());
	}

	void addEdge(String start, String end, int weight) {
		List<Edge> edges = vertices.get(new Vertex(start));
		edges.add(new Edge(weight, new Vertex(end)));
	}

	void printGraph() {
		vertices.entrySet().stream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		AdjacencyListGraph graph = new AdjacencyListGraph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "D", 1);
		graph.addEdge("B", "C", 1);
		graph.addEdge("C", "D", 1);
		graph.addEdge("C", "A", 1);

		graph.printGraph();
	}
}
