# Stack Implementation in Java

This project contains a linked-list based Stack implementation in Java. A stack operates on the **Last In First Out (LIFO)** principle, and this implementation supports core operations such as `push`, `pop`, `peek`, and utility functions like checking if the stack is empty or full, counting elements, and searching for an item.

## Functions Summary

- **push(int item)**: Adds a new item to the top of the stack.
- **pop()**: Removes and returns the top item. Returns `INT_MIN` if the stack is empty.
- **Peek()**: Returns the value of the top item without removing it.
- **isEmpty()**: Returns `true` if the stack is empty, otherwise `false`.
- **Display()**: Prints all items in the stack.
- **Count()**: Returns the total number of items in the stack.
- **isFound(int item)**: Returns `true` if the specified item is found in the stack, otherwise `false`.
- **isFull()**: Checks if the stack is full (in case of memory issues, returns `true`).

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.Display(); // Output: 30 20 10 
    }
}
