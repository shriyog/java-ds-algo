package com.github.shriyog.datastructures.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shriyog Ingale 17-Jan-2019
 */
public class ArrayHeapTest {

	Heap heap;

	@Before
	public void setup() {
		heap = new ArrayHeap();
	}

	@Test
	public void testAdd() {
		heap.add(30);
		heap.add(20);
		heap.add(40);
	}

	@Test
	public void testPeek() {
		Assert.assertEquals(20, heap.peek());
	}

	@Test
	public void testPoll() {
		Assert.assertEquals(20, heap.peek());
	}

}
