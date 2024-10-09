import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node() {
        data = 0;
        next = null;
    }
}

class Queue {
    Node frnt;
    Node rear;

    public Queue() {
        frnt = rear = null;
    }

    public boolean isEmpty() {
        return frnt == null;
    }

    public void enqueue(int item) {
        Node newnode = new Node();
        newnode.data = item;
        if (isEmpty()) {
            rear = frnt = newnode;
        } else {
            rear.next = newnode;
            rear = newnode;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (frnt == rear) {
            frnt = rear = null;
        } else {
            Node delptr = frnt;
            frnt = frnt.next;
            delptr = null;
        }
    }

    public void getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Front Element is: " + frnt.data);
        }
    }

    public void getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Rear Element is: " + rear.data);
        }
    }

    public int count() {
        int counter = 0;
        Node tmp = frnt;
        while (tmp != null) {
            counter++;
            tmp = tmp.next;
        }
        return counter;
    }

    public boolean isFound(int item) {
        Node tmp = frnt;
        while (tmp != null) {
            if (item == tmp.data) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node tmp = frnt;
            System.out.print("Queue items: ");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue q = new Queue();
        int item;

        // Enqueue items
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter item to Enqueue: ");
            item = scanner.nextInt();
            q.enqueue(item);
        }

        q.display();

        // Dequeue items
        q.dequeue();
        q.display();

        q.dequeue();
        q.display();

        // Enqueue more items
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter item to Enqueue: ");
            item = scanner.nextInt();
            q.enqueue(item);
        }

        q.display();

        // Search for an item in the queue
        System.out.print("Enter item to search: ");
        item = scanner.nextInt();
        if (q.isFound(item)) {
            System.out.println("Item found!!");
        } else {
            System.out.println("Item not found!!");
        }

        // Display number of items, front and rear elements
        System.out.println("Number of items in queue: " + q.count());
        q.getFront();
        q.getRear();

        // Clear the queue and display it
        q.clear();
        q.display();

        scanner.close();
    }
}

