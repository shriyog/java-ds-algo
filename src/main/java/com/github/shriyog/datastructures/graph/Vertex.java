package com.github.shriyog.datastructures.graph;

/**
 * @author Shriyog Ingale 19-Jan-2019
 */
public class Vertex {

	private String element;

	public Vertex(String element) {
		this.element = element;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		Vertex otherVertex;
		if (other instanceof Vertex) {
			otherVertex = (Vertex) other;
			return this.getElement().equalsIgnoreCase(otherVertex.getElement());
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
