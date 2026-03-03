# java-ds-algo

A Test-Driven Development (TDD) based implementation of fundamental Data Structures and Algorithms in Java.

## Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Data Structures](#data-structures)
  - [Linked Lists](#linked-lists)
  - [Stacks](#stacks)
  - [Queues](#queues)
  - [Trees](#trees)
  - [Graphs](#graphs)
  - [Heaps](#heaps)
- [Algorithms](#algorithms)
  - [Searching](#searching)
- [Complexity Reference](#complexity-reference)
- [Getting Started](#getting-started)
- [Running Tests](#running-tests)
- [Tech Stack](#tech-stack)

---

## Overview

This project provides clean, well-tested implementations of commonly used data structures and algorithms. Each implementation is backed by a corresponding JUnit test class, following the TDD methodology. Parameterized tests are used where multiple implementations share the same interface (e.g., `LinkedListTest` covers Singly, Doubly, and Circular variants).

---

## Project Structure

```
java-ds-algo/
├── pom.xml
└── src/
    ├── main/java/com/github/shriyog/
    │   ├── algorithms/
    │   │   └── searching/
    │   │       ├── BinarySearch.java
    │   │       ├── ExponentialSearch.java
    │   │       ├── JumpSearch.java
    │   │       └── LinearSearch.java
    │   └── datastructures/
    │       ├── graph/
    │       │   ├── Graph.java            (interface)
    │       │   ├── Vertex.java
    │       │   ├── Edge.java
    │       │   ├── AdjacencyListGraph.java
    │       │   └── AdjacencyMatrixGraph.java
    │       ├── heap/
    │       │   ├── Heap.java             (interface)
    │       │   └── ArrayHeap.java
    │       ├── linkedlist/
    │       │   ├── List.java             (interface)
    │       │   ├── Node.java
    │       │   ├── DNode.java
    │       │   ├── SinglyLinkedList.java
    │       │   ├── DoublyLinkedList.java
    │       │   └── CircularLinkedList.java
    │       ├── queue/
    │       │   ├── Queue.java            (interface)
    │       │   ├── Node.java
    │       │   ├── ArrayQueue.java
    │       │   ├── CircularQueue.java
    │       │   ├── LinkedQueue.java
    │       │   └── PriorityQueue.java
    │       ├── stack/
    │       │   ├── Stack.java            (interface)
    │       │   ├── Node.java
    │       │   ├── ArrayStack.java
    │       │   └── LinkedStack.java
    │       └── tree/
    │           ├── Tree.java             (interface)
    │           ├── TreeNode.java
    │           ├── BinaryTree.java
    │           └── BinarySearchTree.java
    └── test/java/com/github/shriyog/
        ├── algorithms/searching/
        │   └── SearchingTest.java
        └── datastructures/
            ├── graph/
            │   ├── AdjacencyListGraphTest.java
            │   └── AdjacencyMatrixGraphTest.java
            ├── heap/
            │   └── ArrayHeapTest.java
            ├── linkedlist/
            │   └── LinkedListTest.java       (parameterized)
            ├── queue/
            │   └── QueueTest.java            (parameterized)
            ├── stack/
            │   └── StackTest.java            (parameterized)
            └── tree/
                ├── BinaryTreeTest.java
                └── BinarySearchTreeTest.java
```

---

## Data Structures

### Linked Lists

All linked list implementations implement the `List` interface.

| Method | Description |
|---|---|
| `addFirst(int)` | Insert at the head |
| `addLast(int)` | Insert at the tail |
| `add(int, int)` | Insert at a given index |
| `removeFirst()` | Remove and return head element |
| `removeLast()` | Remove and return tail element |
| `remove(int)` | Remove and return element at index |
| `get(int)` | Return element at index |
| `size()` | Number of elements |
| `emptyList()` | Clear all elements |

#### SinglyLinkedList
Each node holds a value and a `next` pointer. Suitable for forward-only traversal.

#### DoublyLinkedList
Each node (`DNode`) holds `next` and `previous` pointers, enabling bidirectional traversal.

#### CircularLinkedList
The tail node's `next` points back to the head. Traversal uses `do-while` loops to handle the circular structure.

---

### Stacks

All stack implementations implement the `Stack` interface.

| Method | Description |
|---|---|
| `push(int)` | Push element onto the top; returns `false` on overflow (ArrayStack) |
| `pop()` | Remove and return top element; returns `-1` if empty |
| `peek()` | Return top element without removing |
| `isEmpty()` | Returns `true` if stack has no elements |
| `size()` | Number of elements |
| `emptyStack()` | Clear all elements |

#### ArrayStack
Fixed-capacity array with a `top` pointer. Default capacity is 5. Returns `false` on `push` when full.

#### LinkedStack
Dynamically sized using linked nodes. `push` and `pop` operate at the head in O(1).

---

### Queues

All queue implementations (except `PriorityQueue`) implement the `Queue` interface.

| Method | Description |
|---|---|
| `enqueue(int)` | Add element to the rear |
| `dequeue()` | Remove and return front element |
| `front()` | Peek at the front element |
| `rear()` | Peek at the rear element |
| `isEmpty()` | Returns `true` if queue is empty |
| `size()` | Number of elements |
| `emptyQueue()` | Clear all elements |

#### ArrayQueue
Static array-backed queue with explicit `front` and `rear` indices. Fixed capacity; prints an overflow message if full.

#### LinkedQueue
Dynamically sized using linked nodes with `front` and `rear` pointers. `enqueue` and `dequeue` are O(1).

#### CircularQueue
Linked-node queue where `rear.next` always points back to `front`, enabling circular reuse of space.

#### PriorityQueue
Linked-list based. `enqueue` appends to the rear in O(1); `dequeue` scans the entire list to find and remove the maximum-value element in O(n).

---

### Trees

All tree implementations implement the `Tree` interface.

| Method | Description |
|---|---|
| `add(int)` | Insert an element |
| `contains(int)` | Search for an element; returns `boolean` |
| `remove(int)` | Delete an element |

#### BinaryTree
A complete binary tree with level-order (BFS) insertion. Elements fill left-to-right at each level. Removal replaces the target node's value with the last node's value and deletes the last node.

Traversals supported:
- **Recursive:** Pre-order, In-order, Post-order
- **Iterative:** Pre-order, Breadth-first (level-order)

#### BinarySearchTree
Maintains the BST invariant: `left < parent < right`. Removal handles all three cases:
- Node with no children — simply delete
- Node with one child — replace with the child
- Node with two children — replace with the maximum of the left subtree

In-order iterative traversal returns elements in sorted ascending order.

---

### Graphs

#### AdjacencyListGraph
Vertices are stored as a linked list of `Vertex` objects; each `Vertex` maintains an edge list of `Edge` objects (destination + weight).

| Method | Description |
|---|---|
| `addVertex(String)` | Add a named vertex |
| `addEdge(String, String, int)` | Add a weighted directed edge |
| `getVertices()` | Return all vertices |
| `getEdges()` | Return all edges |
| `breadthFirstTraversal()` | BFS using a queue and visited set |
| `depthFirstTraversal()` | DFS using a stack and visited set |
| `deleteGraph()` | Clear all vertices and edges |

#### AdjacencyMatrixGraph
Uses a nested `HashMap<Character, HashMap<Character, Integer>>` as the matrix. Implements the `Graph` interface.

| Method | Description |
|---|---|
| `addVertex(char)` | Add a vertex (extends matrix rows/columns) |
| `addEdge(char, char)` | Set `matrix[start][end] = 1` |
| `getVertices()` | Return vertex key set |
| `getEdges()` | Return pairs where matrix value is `1` |

---

### Heaps

#### ArrayHeap
A min binary heap backed by an array. Implements the `Heap` interface.

| Method | Description |
|---|---|
| `add(int)` | Insert element and bubble up to restore heap property |
| `peek()` | Return the minimum element without removing; `-1` if empty |
| `poll()` | Remove and return the minimum; heapify down to restore order |

---

## Algorithms

### Searching

All searching methods are `static` and operate on `int[]` arrays.

#### LinearSearch
Iterates through the array sequentially.
```java
int index = LinearSearch.linearSearch(arr, key);
```

#### BinarySearch
Requires a **sorted** array. Provides both iterative and recursive variants.
```java
int index = BinarySearch.binarySearch(arr, key);
int index = BinarySearch.binarySearchRecursive(arr, key, left, right);
```

#### JumpSearch
Requires a **sorted** array. Jumps ahead by `√n` steps to find the block, then performs a linear search within the block.
```java
int index = JumpSearch.jumpSearch(arr, key);
```

#### ExponentialSearch
Requires a **sorted** array. Finds the range exponentially (doubling the index), then applies binary search within that range. Performs well for unbounded or large arrays.
```java
int index = ExponentialSearch.exponentialSearch(arr, key);
```

---

## Complexity Reference

### Searching Algorithms

| Algorithm | Time (Best) | Time (Average) | Time (Worst) | Space | Requires Sorted |
|---|---|---|---|---|---|
| Linear Search | O(1) | O(n) | O(n) | O(1) | No |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) iterative / O(log n) recursive | Yes |
| Jump Search | O(1) | O(√n) | O(√n) | O(1) | Yes |
| Exponential Search | O(1) | O(log n) | O(log n) | O(1) | Yes |

### Data Structures

| Structure | Access | Search | Insert | Delete | Space |
|---|---|---|---|---|---|
| Singly Linked List | O(n) | O(n) | O(1) head / O(n) index | O(1) head / O(n) index | O(n) |
| Doubly Linked List | O(n) | O(n) | O(1) head or tail / O(n) index | O(1) head or tail / O(n) index | O(n) |
| Circular Linked List | O(n) | O(n) | O(n) | O(n) | O(n) |
| Array Stack | O(n) | O(n) | O(1) | O(1) | O(n) |
| Linked Stack | O(n) | O(n) | O(1) | O(1) | O(n) |
| Array Queue | O(n) | O(n) | O(1) | O(1) | O(n) |
| Linked Queue | O(n) | O(n) | O(1) | O(1) | O(n) |
| Priority Queue | O(n) | O(n) | O(1) | O(n) | O(n) |
| Binary Heap (Array) | O(1) min | O(n) | O(log n) | O(log n) | O(n) |
| Binary Tree | O(n) | O(n) | O(n) | O(n) | O(n) |
| Binary Search Tree | O(log n) avg | O(log n) avg | O(log n) avg | O(log n) avg | O(n) |
| Adjacency List Graph | — | O(V) | O(1) vertex / O(1) edge | O(V+E) | O(V+E) |
| Adjacency Matrix Graph | O(1) | O(1) | O(V²) | O(V²) | O(V²) |

---

## Getting Started

### Prerequisites
- Java 8+
- Maven 3.x

### Build

```bash
mvn clean install
```

---

## Running Tests

```bash
mvn test
```

Tests are organized to mirror the source structure. Parameterized test classes (`LinkedListTest`, `QueueTest`, `StackTest`) run the same suite of assertions across all implementations of their respective interface automatically.

---

## Tech Stack

| Tool | Purpose |
|---|---|
| Java 8 | Language |
| Maven | Build & dependency management |
| JUnit 4 | Unit testing |
| Travis CI | Continuous integration |
