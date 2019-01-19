package com.github.shriyog.datastructures.graph;

/**
 * @author Shriyog Ingale 19-Jan-2019
 */
public class Edge {

	private int weight;
	private Vertex destination;

	public Edge(int weight, Vertex destination) {
		super();
		this.weight = weight;
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return this.destination.getElement();
	}

}
