class Node {
    int data;
    Node next;

    public Node() {
        data = 0;
        next = null;
    }
}

class Stack {
    Node top;

    public Stack() {
        top = null;
    }

    // Method to push an item to the stack
    public void push(int item) {
        Node newnode = new Node();
        newnode.data = item;

        if (isEmpty()) {
            newnode.next = null;
            top = newnode;
        } else {
            newnode.next = top;
            top = newnode;
        }
    }

    // Method to pop an item from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop.");
            return Integer.MIN_VALUE;  // Special value to signify an empty stack
        }

        int value = top.data;
        top = top.next;
        return value;
    }

    // Method to display all elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        Node temp = top;
        System.out.print("Stack elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to peek at the top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, nothing to peek.");
            return Integer.MIN_VALUE;  // Special value to signify an empty stack
        }
        return top.data;
    }

    // Method to count the number of elements in the stack
    public int count() {
        int counter = 0;
        Node temp = top;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    // Method to check if an item exists in the stack
    public boolean isFound(int item) {
        Node temp = top;
        while (temp != null) {
            if (temp.data == item) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Method to check if the stack is full (based on memory allocation)
    public boolean isFull() {
        Node ptr = new Node();
        if (ptr == null) {
            System.out.println("Stack is Full");
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Push items to the stack
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter item to push: "+(i + 1));
            stack.push(i + 1);
        }

        stack.display();

        // Pop two items from the stack
        System.out.println("This item popped from stack -> " + stack.pop());
        stack.display();

        System.out.println("This item popped from stack -> " + stack.pop());
        stack.display();

        // Attempt to pop more items and peek
        stack.pop();
        stack.peek();
    }
}