package com.github.shriyog.datastructures.graph;

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
		System.out.println();

		graph.getEdges().stream().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
	}
}
