package com.github.shriyog.datastructures.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * Adjacency List representation of Graph. All the vertices are stored in a list
 * made of Vertex nodes where each vertex has a ArrayList of Edge. Edge nodes
 * maintain weight and reference to destination Vertex for that edge.
 * 
 * This implementation has no duplicate vertices.
 * 
 * @author Shriyog Ingale 19-Jan-2019
 */
public class AdjacencyListGraph {

	private Vertex root, last;

	void addVertex(String element) {
		Vertex vertex = new Vertex(element);
		if (root == null) {
			root = vertex;
		} else {
			last.setNext(vertex);
		}
		last = vertex;
	}

	void addEdge(String start, String end, int weight) {
		Vertex startVertex = new Vertex(start);
		Vertex endVertex = new Vertex(end);
		// Search for matching nodes in Vertex list.
		for (Vertex current = root; current != null; current = current.getNext()) {
			if (current.equals(startVertex))
				startVertex = current;
			if (current.equals(endVertex))
				endVertex = current;
		}
		// Add an edge to the Edge list of that Vertex.
		startVertex.addEdge(endVertex, weight);
	}

	Set<Vertex> getVertices() {
		Set<Vertex> vertices = new HashSet<>();
		for (Vertex current = root; current != null; current = current.getNext()) {
			vertices.add(current);
		}
		return vertices;
	}

	Set<Entry<Vertex, Vertex>> getEdges() {
		Set<Entry<Vertex, Vertex>> edgeSet = new HashSet<>();
		for (Vertex current = root; current != null; current = current.getNext()) {
			for (Edge edge : current.getEdges()) {
				edgeSet.add(new SimpleEntry<>(current, edge.getDestination()));
			}
		}
		return edgeSet;
	}

	void printGraph() {
		for (Vertex current = root; current != null; current = current.getNext()) {
			for (Edge edge : current.getEdges()) {
				System.out.println(current + " -> " + edge.getDestination());
			}
		}
	}

	List<Vertex> breadthFirstTraversal() {
		List<Vertex> result = new ArrayList<>();
		Queue<Vertex> queue = new LinkedList<>();
		root.setChecked();
		queue.add(root);
		Vertex current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			result.add(current);
			for (Edge edge : current.getEdges()) {
				Vertex vertex = edge.getDestination();
				if (!vertex.isChecked()) {
					vertex.setChecked();
					queue.add(vertex);
				}
			}
		}
		return result;
	}

	List<Vertex> depthFirstTraversal() {
		List<Vertex> result = new ArrayList<>();
		Deque<Vertex> stack = new ArrayDeque<>();
		root.setChecked();
		stack.push(root);
		Vertex current;
		while (!stack.isEmpty()) {
			current = stack.pop();
			result.add(current);
			for (Edge edge : current.getEdges()) {
				Vertex vertex = edge.getDestination();
				if (!vertex.isChecked()) {
					vertex.setChecked();
					stack.push(vertex);
				}
			}
		}
		return result;
	}

	void deleteGraph() {
		this.root = this.last = null;
	}
}
