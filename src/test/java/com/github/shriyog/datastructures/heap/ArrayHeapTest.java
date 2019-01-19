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
		Assert.assertEquals(-1, heap.peek());
		heap.add(30);
		Assert.assertEquals(30, heap.peek());
		heap.add(20);
		Assert.assertEquals(20, heap.peek());
		heap.add(40);
		Assert.assertEquals(20, heap.peek());
		heap.add(25);
		Assert.assertEquals(20, heap.peek());
		heap.add(10);
		heap.add(10);
		Assert.assertEquals(10, heap.peek());
	}

	@Test
	public void testPeekWhenEmpty() {
		Assert.assertEquals(-1, heap.peek());
	}

	@Test
	public void testPeek() {
		heap.add(30);
		Assert.assertEquals(30, heap.peek());
		heap.add(10);
		Assert.assertEquals(10, heap.peek());
	}

	@Test
	public void testPollWhenEmpty() {
		Assert.assertEquals(-1, heap.poll());
	}

	@Test
	public void testPoll() {
		heap.add(30);
		Assert.assertEquals(30, heap.poll());
		Assert.assertEquals(-1, heap.poll());

		heap.add(30);
		heap.add(20);
		heap.add(40);
		heap.add(25);
		heap.add(10);

		Assert.assertEquals(10, heap.poll());
		Assert.assertEquals(20, heap.peek());

		Assert.assertEquals(20, heap.poll());
		Assert.assertEquals(25, heap.peek());

		Assert.assertEquals(25, heap.poll());
		Assert.assertEquals(30, heap.peek());

		Assert.assertEquals(30, heap.poll());
		Assert.assertEquals(40, heap.peek());

		Assert.assertEquals(40, heap.poll());
		Assert.assertEquals(-1, heap.peek());
	}

}
