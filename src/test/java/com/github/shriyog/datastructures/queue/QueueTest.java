package com.github.shriyog.datastructures.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Shriyog Ingale 01-May-2018
 */
@RunWith(Parameterized.class)
public class QueueTest {

	private Queue queue;

	public QueueTest(Queue queue) {
		this.queue = queue;
	}

	@Parameters
	public static Collection<Queue> testClasses() {
		Queue[] queues = { new ArrayQueue(5), new LinkedQueue(), new CircularQueue() };
		return Arrays.asList(queues);
	}

	@Before
	public void setup() {
		queue.emptyQueue();
	}

	@Test
	public void testEnqueue() {
		queue.enqueue(10);
		queue.enqueue(20);
		assertEquals(10, queue.front());
		assertEquals(20, queue.rear());
		queue.enqueue(30);
		assertEquals(10, queue.front());
		assertEquals(30, queue.rear());
	}

	@Test
	public void testDequeue() {
		queue.enqueue(10);
		queue.enqueue(20);
		assertEquals(10, queue.dequeue());
		assertEquals(20, queue.front());
		assertEquals(20, queue.rear());
		assertEquals(20, queue.dequeue());
		assertEquals(-1, queue.front());
		assertEquals(-1, queue.rear());
	}

	@Test
	public void testFront() {
		queue.enqueue(10);
		queue.enqueue(20);
		assertEquals(10, queue.front());
	}

	@Test
	public void testRear() {
		queue.enqueue(10);
		queue.enqueue(20);
		assertEquals(20, queue.rear());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.enqueue(10);
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, queue.size());
		queue.enqueue(10);
		assertEquals(1, queue.size());
	}

	@Test
	public void testEmptyQueue() {
		queue.enqueue(10);
		queue.enqueue(20);
		queue.emptyQueue();
		assertEquals(0, queue.size());
	}

	@Test
	public void testPriorityQueue() {
		PriorityQueue queue = new PriorityQueue();
		queue.enqueue(10);
		queue.enqueue(40);
		queue.enqueue(30);
		queue.enqueue(35);
		assertEquals(40, queue.dequeue());
		assertEquals(35, queue.dequeue());
		assertEquals(30, queue.dequeue());
		assertEquals(10, queue.dequeue());
		assertEquals(-1, queue.dequeue());
		queue.enqueue(50);
		queue.enqueue(100);
		assertEquals(100, queue.dequeue());

	}
}
