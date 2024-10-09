#include <iostream>
using namespace std;

class Node{
public:
    int data;
    Node *next;
    Node(){
        data = 0;
        next = NULL;
    }
};
class Queue{
public:
    Node *frnt;
    Node *rear;
    Queue(){
        frnt = rear = NULL;
    }
    bool isEmpty(){
        if(frnt == NULL){
            return true;
        }else{
            return false;
        }
    }
    void Enqueue(int item){
        Node *newnode = new Node();
        newnode->data=item;
        if(isEmpty()){
            rear = frnt = newnode;
        }else{
            rear->next=newnode;
            rear = newnode;
        }
    }
    void Dequeue(){
        if(isEmpty()){
            cout << "Queue is empty \n";
        }else if(frnt == rear){
            delete frnt;
            frnt = rear = NULL;
        }else{
            Node *delptr =frnt;
            frnt = frnt ->next;
            delete delptr;
        }
    }
    void getFront(){
        if (isEmpty()) {
            cout << "Queue is empty.\n";
        }else{
            cout<<"Front Element is : "<<frnt->data<<endl;
        }
    }
    void getRear(){
        if (isEmpty()) {
            cout << "Queue is empty.\n";
        }else{
            cout<<"Rear Element is : "<<rear->data<<endl;
        }
    }
    int Count(){
        int counter = 0;
        Node *tmp =frnt;
        while(tmp != NULL){
            counter++;
            tmp = tmp ->next;
        }
        return counter;
    }
    bool isFound(int item){
        Node *tmp =frnt;
        while(tmp != NULL){
            if(item == tmp->data){
                return true;
            }
            tmp = tmp ->next;
        }
        return false;
    }
    void Clear(){
        while(!(isEmpty())){
            Dequeue();
        }
    }
    void Display(){
        if(isEmpty()){
            cout<<"Queue is Empty";
        }else{
        Node *tmp =frnt;
        cout << "Queue items:";
        while(tmp != NULL){
            cout << tmp ->data<<"\t";
            tmp = tmp ->next;
        }
        cout << endl;
        }
        
    }
};

int main()
{
    int item;
    Queue q;
    for(int i = 0; i < 4; i++){
        cout << "Enter item to Enqueue : ";
        cin >> item;
        q.Enqueue(item);
    }
    q.Display();

    q.Dequeue();
    q.Display();

    q.Dequeue();
    q.Display();

    for(int i = 0; i < 4; i++){
        cout << "Enter item to Enqueue : ";
        cin >> item;
        q.Enqueue(item);
    }
    q.Display();

    cout << "Enter item to search \n";
    cin >> item;
    if(q.isFound(item)){
        cout << "item found !!\n";
    }else{
        cout << "item not found !!\n";
    }
    cout << "Number of items in queue :" << q.Count() << endl;
    q.getFront();
    q.getRear();
    q.Clear();
    q.Display();

    return 0;
}
