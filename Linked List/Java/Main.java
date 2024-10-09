package Java;

import java.util.Scanner;

class Node {
    int data;
    Node next;
}

class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertFirst(int newValue) {
        Node newNode = new Node(); // create a new node
        newNode.data = newValue; // set the data
        if (isEmpty()) {
            newNode.next = null;
            head = newNode;
        } else {
            newNode.next = head; // point new node's next to current head
            head = newNode; // update head to new node
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int count() {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    public boolean isFound(int key) {
        Node temp = head;
        while (temp != null) {
            if (key == temp.data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void insertBefore(int item, int newValue) {
        if (isEmpty()) {
            insertFirst(newValue);
            return;
        }
        if (item == head.data) {
            Node newNode = new Node();
            newNode.data = newValue;
            newNode.next = head;
            head = newNode;
            return;
        }
        if (isFound(item)) {
            Node newNode = new Node();
            newNode.data = newValue;
            Node temp = head;
            while (temp != null && temp.next.data != item) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("Item not found");
        }
    }

    public void append(int newValue) {
        if (isEmpty()) {
            insertFirst(newValue);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node newNode = new Node();
            newNode.data = newValue;
            temp.next = newNode;
            newNode.next = null;
        }
    }

    public void delete(int val) {
        if (isEmpty() || !isFound(val)) {
            System.out.println("List is empty or item not found");
        } else {
            Node delPtr = head;
            if (delPtr.data == val) {
                head = delPtr.next;
                return;
            }
            while (delPtr != null && delPtr.next != null && delPtr.next.data != val) {
                delPtr = delPtr.next;
            }
            if (delPtr == null || delPtr.next == null) {
                System.out.println("Item not found");
                return;
            }
            Node prev = delPtr;
            delPtr = delPtr.next;
            prev.next = delPtr.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        Scanner sc = new Scanner(System.in);

        if (myList.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            System.out.println("The list contains " + myList.count() + " items");
        }

        int item;
        System.out.println("Enter item to insert in the list:");
        item = sc.nextInt();
        myList.insertFirst(item);
        myList.display();

        System.out.println("The list contains " + myList.count() + " items");

        System.out.println("Enter item to search for:");
        item = sc.nextInt();
        if (myList.isFound(item)) {
            System.out.println("Item Found");
        } else {
            System.out.println("Item not found");
        }

        int newValue;
        System.out.println("Enter value to add:");
        newValue = sc.nextInt();
        System.out.println("Enter item to add before:");
        item = sc.nextInt();
        myList.insertBefore(item, newValue);
        myList.display();

        System.out.println("Enter value to append:");
        newValue = sc.nextInt();
        myList.append(newValue);
        myList.display();

        System.out.println("Enter item to delete:");
        newValue = sc.nextInt();
        myList.delete(newValue);
        myList.display();

        sc.close();
    }
}
