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
public class AdjacencyMatrixGraphTest {

	AdjacencyMatrixGraph graph;

	@Before
	public void setup() {
		graph = new AdjacencyMatrixGraph();
	}

	@Test
	public void testAddVertex() {
		Character[] expectedVertices = { 'A', 'B', 'C' };
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		Assert.assertArrayEquals(expectedVertices, graph.getVertices().toArray());
	}

	@Test
	public void testAddEdge() {
		Set<Entry<Character, Character>> expectedEdges = new HashSet<>();
		expectedEdges.add(new SimpleEntry<>('A', 'B'));
		expectedEdges.add(new SimpleEntry<>('A', 'D'));
		expectedEdges.add(new SimpleEntry<>('C', 'D'));
		expectedEdges.add(new SimpleEntry<>('C', 'A'));
		expectedEdges.add(new SimpleEntry<>('B', 'C'));
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addEdge('A', 'B');
		graph.addEdge('A', 'D');
		graph.addEdge('C', 'D');
		graph.addEdge('C', 'A');
		graph.addEdge('B', 'C');
		graph.printGraph();
		Assert.assertArrayEquals(expectedEdges.toArray(), graph.getEdges().toArray());
	}
}
