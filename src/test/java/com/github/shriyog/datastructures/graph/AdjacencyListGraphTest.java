package com.github.shriyog.datastructures.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shriyog Ingale 19-Jan-2019
 */
public class AdjacencyListGraphTest {

	AdjacencyListGraph graph;

	@Before
	public void setup() {
		// Create an undirected graph.
		graph = new AdjacencyListGraph();
		graph.addVertex("A");
		graph.addVertex("X");
		graph.addVertex("G");
		graph.addVertex("P");
		graph.addVertex("H");
		graph.addVertex("E");
		graph.addVertex("Y");
		graph.addVertex("M");
		graph.addVertex("J");

		graph.addEdge("A", "X", 1);
		graph.addEdge("X", "A", 1);
		graph.addEdge("X", "G", 1);
		graph.addEdge("G", "X", 1);
		graph.addEdge("X", "H", 1);
		graph.addEdge("H", "X", 1);
		graph.addEdge("G", "P", 1);
		graph.addEdge("P", "G", 1);
		graph.addEdge("P", "H", 1);
		graph.addEdge("H", "P", 1);
		graph.addEdge("H", "E", 1);
		graph.addEdge("E", "H", 1);
		graph.addEdge("E", "M", 1);
		graph.addEdge("M", "E", 1);
		graph.addEdge("E", "Y", 1);
		graph.addEdge("Y", "E", 1);
		graph.addEdge("M", "J", 1);
		graph.addEdge("J", "M", 1);
	}

	@Test
	public void testAddVertex() {
		graph.deleteGraph();
		Vertex[] expected = { new Vertex("A"), new Vertex("B"), new Vertex("C"), new Vertex("D") };
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		Assert.assertArrayEquals(expected, graph.getVertices().toArray());
	}

	@Test
	public void testAddEdge() {
		graph.deleteGraph();
		Set<Entry<Vertex, Vertex>> expected = new HashSet<>();
		expected.add(new SimpleEntry<>(new Vertex("A"), new Vertex("B")));
		expected.add(new SimpleEntry<>(new Vertex("A"), new Vertex("D")));
		expected.add(new SimpleEntry<>(new Vertex("C"), new Vertex("D")));
		expected.add(new SimpleEntry<>(new Vertex("C"), new Vertex("A")));
		expected.add(new SimpleEntry<>(new Vertex("B"), new Vertex("C")));
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "D", 1);
		graph.addEdge("C", "D", 1);
		graph.addEdge("C", "A", 1);
		graph.addEdge("B", "C", 1);
		// graph.printGraph();
		Assert.assertArrayEquals(expected.toArray(), graph.getEdges().toArray());
	}

	@Test
	public void testBreadthFirstTraversal() {
		// Depends upon insertion order of adjacent vertices.
		String[] expected = { "A", "X", "G", "H", "P", "E", "M", "Y", "J" };
		String[] actual = graph.breadthFirstTraversal().stream().map(Vertex::getElement).toArray(String[]::new);
		System.out.println("BFS:" + Arrays.toString(actual));
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testDepthFirstTraversal() {
		// Depends upon insertion order of adjacent vertices.
		String[] expected = { "A", "X", "H", "E", "Y", "M", "J", "P", "G" };
		String[] actual = graph.depthFirstTraversal().stream().map(Vertex::getElement).toArray(String[]::new);
		System.out.println("DFS:" + Arrays.toString(actual));
		Assert.assertArrayEquals(expected, actual);
	}

}
