# Linked List Implementation in C++ and Java

This repository contains implementations of a singly linked list in both C++ and Java. Each implementation defines a `Node` class to represent individual elements in the list and a `LinkedList` class to manage the overall structure and operations.

## Features

The following operations are supported in both the C++ and Java implementations:

1. **Insert First**
   - Inserts a new node with a specified value at the beginning of the list.
   
2. **Append**
   - Adds a new node with a specified value at the end of the list.
   
3. **Insert Before**
   - Inserts a new node before a specified node (identified by value) in the list.
   
4. **Delete**
   - Removes a node from the list, identified by its value.
   
5. **Display**
   - Prints the current elements of the list.
   
6. **Count**
   - Returns the number of elements currently present in the list.
   
7. **Search (isFound)**
   - Searches for an element by its value and returns whether it is found or not.

## C++ Implementation

The C++ version defines a `Node` class with two members:
- `data`: Stores the integer value of the node.
- `next`: A pointer to the next node in the list.

The `LinkedList` class has:
- A `head` pointer to the first node in the list.
- Methods to perform insertions, deletions, counting, searching, and displaying the list contents.

### Key Methods:

- `InsertFirst(int newvalue)`: Adds a new node at the beginning of the list.
- `Append(int newvalue)`: Adds a new node at the end of the list.
- `InsertBefore(int item, int newvalue)`: Inserts a new node before the node with value `item`.
- `Delete(int val)`: Removes the node with the given value from the list.
- `Display()`: Prints all the values in the list.
- `Count()`: Returns the number of nodes in the list.
- `isFound(int key)`: Returns `true` if a node with the value `key` exists.

## Java Implementation

The Java version mirrors the structure and functionality of the C++ version but utilizes Java-specific syntax and memory management.

### Key Methods:

- `insertFirst(int newValue)`: Inserts a new node at the start of the list.
- `append(int newValue)`: Adds a node to the end of the list.
- `insertBefore(int item, int newValue)`: Inserts a new node before a node containing the value `item`.
- `delete(int value)`: Deletes a node with the specified value.
- `display()`: Outputs the list contents.
- `count()`: Counts and returns the number of elements in the list.
- `isFound(int key)`: Checks if a node containing the value `key` exists in the list.

## How to Use

Clone this repository and use the `main` function in both C++ and Java files to run the linked list operations interactively.
