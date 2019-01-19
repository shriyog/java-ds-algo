package com.github.shriyog.datastructures.graph;

import java.util.AbstractMap.SimpleEntry;
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
		graph = new AdjacencyListGraph();
	}

	@Test
	public void testAddVertex() {
		Vertex[] expected = { new Vertex("A"), new Vertex("B"), new Vertex("C"), new Vertex("D") };
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		Assert.assertArrayEquals(expected, graph.getVertices().toArray());
	}

	@Test
	public void testAddEdge() {
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
		graph.printGraph();
		Assert.assertArrayEquals(expected.toArray(), graph.getEdges().toArray());
	}
}
