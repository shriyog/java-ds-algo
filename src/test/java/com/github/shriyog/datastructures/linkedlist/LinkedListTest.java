package com.github.shriyog.datastructures.linkedlist;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.shriyog.datastructures.linkedlist.CircularLinkedList;
import com.github.shriyog.datastructures.linkedlist.DoublyLinkedList;
import com.github.shriyog.datastructures.linkedlist.List;
import com.github.shriyog.datastructures.linkedlist.SinglyLinkedList;

@RunWith(Parameterized.class)
public class LinkedListTest {

	private List list;

	public LinkedListTest(List list) {
		this.list = list;
	}

	@Parameters
	public static Collection<List> testClasses() {
		List[] lists = { new SinglyLinkedList(), new DoublyLinkedList(), new CircularLinkedList() };
		return Arrays.asList(lists);
	}

	@Before
	public void setup() {
		list.emptyList();
	}

	@Test
	public void testGet() {
		assertEquals(0, list.size());
		assertEquals(-1, list.get(0));

		list.addFirst(10);
		list.addLast(20);
		assertEquals(2, list.size());
		assertEquals(10, list.get(0));
		assertEquals(20, list.get(1));
	}

	@Test
	public void testSize() {
		list.addFirst(10);
		list.addFirst(20);
		assertEquals(2, list.size());
	}

	@Test
	public void testAddFirst() {
		list.addFirst(10);
		assertEquals(1, list.size());
		assertEquals(10, list.get(0));

		list.addFirst(20);
		assertEquals(2, list.size());
		assertEquals(20, list.get(0));
		assertEquals(10, list.get(1));
	}

	@Test
	public void testAddLast() {
		list.addLast(10);
		assertEquals(1, list.size());
		assertEquals(10, list.get(0));

		list.addLast(20);
		assertEquals(2, list.size());
		assertEquals(10, list.get(0));
		assertEquals(20, list.get(1));
	}

	@Test
	public void testAdd() {
		// [10, 20] add(30, 2) doesn't add at end; returns -1
		list.add(10, 0);
		assertEquals(1, list.size());
		assertEquals(10, list.get(0));

		list.add(20, 0);
		list.add(30, 1);
		assertEquals(3, list.size());
		assertEquals(20, list.get(0));
		assertEquals(-1, list.get(10));
	}

	@Test
	public void testRemoveFirst() {
		list.addFirst(10);
		list.addLast(20);
		int removed = list.removeFirst();
		assertEquals(1, list.size());
		assertEquals(10, removed);
	}

	@Test
	public void testRemoveLast() {
		list.addFirst(10);
		list.addLast(20);
		int removed = list.removeLast();
		assertEquals(1, list.size());
		assertEquals(20, removed);
	}

	@Test
	public void testRemove() {
		list.addFirst(10);
		list.addLast(20);
		list.addLast(30);

		int removed = list.remove(5);
		assertEquals(3, list.size());
		assertEquals(-1, removed);

		removed = list.remove(1);
		assertEquals(2, list.size());
		assertEquals(20, removed);
	}

	@Test
	public void testEmptyList() {
		list.addLast(10);
		list.addLast(20);
		assertEquals(2, list.size());
		list.emptyList();
		assertEquals(0, list.size());
	}
}
