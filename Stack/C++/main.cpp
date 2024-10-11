#include <iostream>
#include <climits> // For INT_MIN

using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node() {
        data = 0;
        next = NULL;
    }
};

class Stack {
public:
    Node* top;
    Stack() {
        top = NULL;
    }

    // Destructor to clear memory
    ~Stack() {
        while (!isEmpty()) {
            pop();
        }
    }

    void push(int item) {
        Node* newnode = new Node();
        newnode->data = item;

        if (isEmpty()) {
            newnode->next = NULL;
            top = newnode;
        } else {
            newnode->next = top;
            top = newnode;
        }
    }

    int pop() {
        if (isEmpty()) {
            cout << "Stack is empty, cannot pop.\n";
            return INT_MIN;  // Special value to signify an empty stack
        }

        int value;
        Node* delptr = top;
        value = top->data;
        top = top->next;
        delete delptr;
        return value;
    }

    void Display() {
        if (isEmpty()) {
            cout << "Stack is empty.\n";
            return;
        }

        Node* temp = top;
        while (temp != NULL) {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }

    bool isEmpty() {
        return top == NULL;
    }

    int Peek() {
        if (isEmpty()) {
            cout << "Stack is empty, nothing to peek.\n";
            return INT_MIN;  // Special value to signify an empty stack
        }
        return top->data;
    }

    int Count() {
        int counter = 0;
        Node* temp = top;
        while (temp != NULL) {
            temp = temp->next;
            counter++;
        }
        return counter;
    }

    bool isFound(int item) {
        Node* temp = top;
        while (temp != NULL) {
            if (temp->data == item) {
                return true;
            }
            temp = temp->next;
        }
        return false;
    }

    bool isFull() {
        Node* ptr = new Node();
        if (ptr == NULL) {
            cout << "Stack is Full\n";
            return true;
        } else {
            delete ptr;
            return false;
        }
    }
};

int main() {
    int item = 0;
    Stack s;
    
    for (int i = 0; i < 5; i++) {
        cout << "Enter item to push: \n";
        cin >> item;
        s.push(item);
    }
    
    s.Display();

    cout << "This item poped from stack -> " << s.pop() << endl;
    s.Display();

    cout << "This item poped from stack -> " << s.pop() << endl;
    s.Display();
    
    
    s.pop();  
    s.Peek(); 
    
    return 0;
}
