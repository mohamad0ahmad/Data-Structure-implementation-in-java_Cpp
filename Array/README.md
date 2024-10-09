# Array Implementation in C++

This repository contains an implementation of a dynamic array in C++. The `Array` class provides methods for array manipulation, including filling the array, displaying elements, searching for values, appending new elements, inserting at specific indices, deleting elements, enlarging the array, and merging with another array.

## Features

The following operations are supported in the array implementation:

1. **Fill**
   - Prompts the user to input values to populate the array.

2. **Display**
   - Prints the current elements in the array.

3. **Search**
   - Searches for a specific value in the array and returns its index if found.

4. **Append**
   - Adds a new element to the end of the array.

5. **Insert**
   - Inserts a new element at a specified index.

6. **Delete**
   - Removes an element from a specified index.

7. **Enlarge**
   - Increases the size of the array to accommodate more elements.

8. **Merge**
   - Merges another array into the current array.

## Class Structure

### `Array` Class

The `Array` class includes:
- **Private Members:**
  - `size`: Total allocated size of the array.
  - `AllocatedItems`: Current count of items in the array.
  - `items`: Pointer to dynamically allocated memory for storing array elements.

- **Public Methods:**
  - `Array(int arrSize)`: Constructor to initialize the array with a specified size.
  - `~Array()`: Destructor to free allocated memory.
  - `Fill()`: Fills the array with user-provided values.
  - `Display()`: Outputs the contents of the array.
  - `getSize()`: Returns the total size of the array.
  - `getAllocatedItems()`: Returns the number of currently allocated items.
  - `Search(int Key)`: Searches for a key in the array and returns its index.
  - `Append(int newitem)`: Appends a new item to the end of the array.
  - `Insert(int index, int newitem)`: Inserts a new item at a specified index.
  - `Delete(int index)`: Deletes an item at a specified index.
  - `Enlarge(int newsize)`: Increases the array size.
  - `Merge(Array other)`: Merges another `Array` instance into the current one.

## How to Use

1. Clone this repository.
2. Compile the C++ code.
3. Run the program to interactively manipulate the array and perform various operations.
