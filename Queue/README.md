# Queue Implementation in Java and C++

## Overview

This repository contains the implementation of a Queue data structure in both **C++** and **Java**. The queue follows a **FIFO (First In, First Out)** principle, where the element added first is the one to be removed first. The queue is implemented using a linked list, where each node holds the data and a reference to the next node.

### Features
- **Dynamic size**: The queue can grow dynamically as elements are added.
- **Efficient Enqueue and Dequeue operations**.
- **Additional functionalities**: Searching, counting, and clearing the queue.

## Functionalities

### 1. `isEmpty()`
- **Description**: Checks if the queue is empty.
- **Returns**: `true` if the queue is empty, otherwise `false`.

### 2. `Enqueue(int item)`
- **Description**: Adds a new element (item) to the rear of the queue.
- **Parameters**: 
  - `item` - The value to be added to the queue.

### 3. `Dequeue()`
- **Description**: Removes the front element from the queue.
- **Output**: If the queue is empty, a message is displayed.

### 4. `getFront()` 
- **Description**: Displays the front element of the queue.
- **Output**: Prints the front element or indicates if the queue is empty.

### 5. `getRear()` 
- **Description**: Displays the rear element of the queue.
- **Output**: Prints the rear element or indicates if the queue is empty.

### 6. `Count()`
- **Description**: Counts the total number of elements in the queue.
- **Returns**: The number of elements in the queue.

### 7. `isFound(int item)`
- **Description**: Checks if a particular item is present in the queue.
- **Parameters**: 
  - `item` - The value to search for.
- **Returns**: `true` if the item is found, otherwise `false`.

### 8. `Clear()`
- **Description**: Clears all the elements from the queue by continuously dequeuing.

### 9. `Display()`
- **Description**: Prints all the elements in the queue from front to rear. If the queue is empty, an appropriate message is shown.

---

## How to Use

### C++
1. Clone the repository.
2. Navigate to the C++ folder.
3. Compile and run the code using any C++ compiler.


