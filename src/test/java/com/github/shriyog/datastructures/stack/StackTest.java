package com.github.shriyog.datastructures.stack;

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

import com.github.shriyog.datastructures.stack.ArrayStack;
import com.github.shriyog.datastructures.stack.LinkedStack;
import com.github.shriyog.datastructures.stack.Stack;

/**
 * @author Shriyog Ingale 25-Apr-2018
 */
@RunWith(Parameterized.class)
public class StackTest {

	private Stack stack;

	public StackTest(Stack stack) {
		this.stack = stack;
	}

	@Parameters
	public static Collection<Stack> testClasses() {
		Stack[] stacks = { new ArrayStack(), new LinkedStack() };
		return Arrays.asList(stacks);
	}

	@Before
	public void setup() {
		stack.emptyStack();
	}

	@Test
	public void testPush() {
		int x = stack.size();
		assertTrue(stack.push(5));
		int y = stack.size();
		assertEquals(++x, y);
		assertEquals(5, stack.peek());
	}

	@Test
	public void testPop() {
		assertEquals(-1, stack.pop());

		stack.push(5);
		int x = stack.size();
		int element = stack.pop();
		int y = stack.size();
		assertEquals(--x, y);
		assertEquals(5, element);
	}

	@Test
	public void testPeek() {
		assertEquals(-1, stack.peek());

		stack.push(5);
		stack.push(10);
		stack.printStack();
		int x = stack.size();
		assertEquals(10, stack.peek());
		int y = stack.size();
		assertEquals(x, y);
	}

	@Test
	public void testSize() {
		assertEquals(0, stack.size());
		stack.push(5);
		stack.push(10);
		assertEquals(2, stack.size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push(5);
		assertFalse(stack.isEmpty());
	}
}
