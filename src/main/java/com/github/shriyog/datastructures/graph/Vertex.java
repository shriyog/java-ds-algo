package com.github.shriyog.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shriyog Ingale 19-Jan-2019
 */
public class Vertex {

	private String element;
	private Vertex next;
	private List<Edge> edges;

	public Vertex(String element) {
		this.element = element;
		this.edges = new ArrayList<>();
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public Vertex getNext() {
		return this.next;
	}

	public void setNext(Vertex next) {
		this.next = next;
	}

	public List<Edge> getEdges() {
		return this.edges;
	}

	public void addEdge(Vertex destination, int weight) {
		this.edges.add(new Edge(weight, destination));
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Vertex) {
			Vertex vertex = (Vertex) other;
			return this.element.equalsIgnoreCase(vertex.element);
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return this.getElement().toLowerCase().hashCode();
	}

	@Override
	public String toString() {
		return this.element;
	}
}
