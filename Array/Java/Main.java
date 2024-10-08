import java.util.Scanner;

class Array {
    private int size;
    private int allocatedItems = 0;
    private int[] items;

    public Array(int arrSize) {
        size = arrSize;
        items = new int[arrSize];
    }

    // Fill the array with items entered by the user
    public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many items do you want to fill?");
        int noOfItems = scanner.nextInt();
        
        if (noOfItems > size || noOfItems < 0) {
            System.out.println("Invalid number of items. Please enter a number between 0 and " + size + ".");
        } else {
            for (int i = 0; i < noOfItems; i++) {
                System.out.println("Enter item num " + i);
                items[i] = scanner.nextInt();
                allocatedItems++;
            }
        }
    }

    // Display the elements in the array
    public void display() {
        System.out.print("Array elements: ");
        for (int i = 0; i < allocatedItems; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public int getAllocatedItems() {
        return allocatedItems;
    }

    // Search for an item and return its index, or -1 if not found
    public int search(int key) {
        int index = -1;
        for (int i = 0; i < allocatedItems; i++) {
            if (items[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }

    // Append a new item to the array
    public void append(int newItem) {
        if (allocatedItems < size) {
            items[allocatedItems] = newItem;
            allocatedItems++;
        } else {
            System.out.println("Array is full");
        }
    }

    // Insert a new item at a specific index
    public void insert(int index, int newItem) {
        if (allocatedItems >= size) {
            System.out.println("Array is full, cannot insert new item.");
            return;
        }

        if (index >= 0 && index < allocatedItems) {
            for (int i = allocatedItems; i > index; i--) {
                items[i] = items[i - 1];
            }
            items[index] = newItem;
            allocatedItems++;
        } else {
            System.out.println("Index out of range");
        }
    }

    // Delete an item at a specific index
    public void delete(int index) {
        if (allocatedItems > 0 && index >= 0 && index < allocatedItems) {
            for (int i = index; i < allocatedItems - 1; i++) {
                items[i] = items[i + 1];
            }
            allocatedItems--;
        } else {
            System.out.println("Index out of array elements or array is empty");
        }
    }

    // Enlarge the array to a new size
    public void enlarge(int newSize) {
        if (newSize <= size) {
            System.out.println("New size must be larger than the old size");
            return;
        } else {
            size = newSize;
            int[] old = items;
            items = new int[newSize];
            for (int i = 0; i < allocatedItems; i++) {
                items[i] = old[i];
            }
        }
    }

    // Merge two arrays
    public void merge(Array other) {
        int newSize = size + other.getSize();
        size = newSize;
        int[] old = items;
        items = new int[newSize];
        int i;
        for (i = 0; i < allocatedItems; i++) {
            items[i] = old[i];
        }

        int j = i;
        for (i = 0; i < other.getAllocatedItems(); i++) {
            items[j++] = other.items[i];
            allocatedItems++;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Array size:");
        int arrSize = scanner.nextInt();
        Array myArray = new Array(arrSize);

        myArray.fill();
        myArray.display();

        System.out.println("Enter the value to search:");
        int key = scanner.nextInt();
        int index = myArray.search(key);
        if (index == -1) {
            System.out.println("Item not found");
        } else {
            System.out.println("Item found at index " + index);
        }

        System.out.println("Enter new item to append:");
        int newItem = scanner.nextInt();
        myArray.append(newItem);

        System.out.println("Enter index and new item to insert:");
        index = scanner.nextInt();
        newItem = scanner.nextInt();
        myArray.insert(index, newItem);
        myArray.display();

        System.out.println("Enter index to delete:");
        int item = scanner.nextInt();
        myArray.delete(item);

        System.out.println("Enter new size to enlarge:");
        int newSize = scanner.nextInt();
        myArray.enlarge(newSize);
        myArray.display();

        Array other = new Array(3);
        other.fill();
        myArray.merge(other);
        myArray.display();
    }
}
