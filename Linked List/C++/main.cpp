#include <iostream>
using namespace std;

class Node
{
public:
    int data;
    Node *next;
};

class Linkedlist
{
public:
    Node *head;
    Linkedlist()
    {
        head=NULL;
    }

    bool isEmpty()
    {
        return (head == NULL);
    }
    void InsertFirst(int newvalue)
    {
        Node *newnode = new Node(); //newnode is a pointer point to object from class Node
        newnode->data = newvalue;
        if(isEmpty())
        {
            newnode->next=NULL;
            head=newnode;
        }
        else
        {
            newnode->next=head;
            head = newnode;
        }
    }
    void Display()
    {
        Node *temp = head;
        while(temp != NULL)
        {
            cout << temp->data <<" ";
            temp = temp->next;
        }
        cout << endl;
    }
    int Count()
    {
        int counter =0;
        Node *temp = head;
        while(temp != NULL)
        {
            counter ++;
            temp = temp->next;
        }
        return counter;
    }

    bool isFound(int key)
    {

        Node *temp = head;
        while(temp != NULL)
        {
            if(key == temp->data){
                return true;
            }
            temp = temp->next;
        }
        return false;
    }

    void InsertBefore(int item, int newvalue)
    {
        if(isEmpty()){
            InsertFirst(newvalue);
            return;
        }
        if(item == head->data){
            Node *newnode = new Node();
            newnode->data = newvalue;
            newnode->next = head;
            head = newnode;
            return;
        }
        if(isFound(item))
        {
            Node *newnode = new Node();
            newnode->data = newvalue;
            Node *temp = head;
            while(temp != NULL && temp->next->data != item)
            {
                temp = temp->next;
            }
            newnode->next = temp->next;
            temp->next = newnode;
        }
        else
        {
            cout <<"item Not found \n";
        }
    }
    void Append(int newvalue)
    {
        if(isEmpty())
        {
            InsertFirst(newvalue);
        }
        else
        {
            Node *temp =head;
            while(temp->next != NULL)
            {
                temp = temp->next;
            }
            Node *newnode = new Node();
            newnode->data=newvalue;
            temp->next =newnode;
            newnode->next=NULL;
        }
    }
    void Delete(int val)
    {
        if(isEmpty() || !(isFound(val)))
        {
            cout << "List is empty or item not found\n";
        }
        else
        {
            Node *delptr=head;
            if(delptr->data == val)
            {
                head = delptr->next;
                delete delptr;
            }
            else
            {
                while(delptr != NULL && delptr->next->data != val)
                {
                    delptr= delptr->next;
                }
                if (delptr == NULL) {
                    cout << "Item not found\n";
                    return;
                }
                Node *prev =delptr;
                delptr= delptr->next;
                prev->next = delptr->next;
                delete delptr;
            }
        }
    }
};
int main()
{
    Linkedlist mylist;
    if(mylist.isEmpty())
    {
        cout << "The list is empty \n";
    }
    else
    {
        cout <<"The list contains "<< mylist.Count() << "\n";
    }

    int item;
    cout << "Enter item to insert in the list \n";
    cin >>item;
    mylist.InsertFirst(item);
    mylist.Display();

    cout <<"The list contains " << mylist.Count() << " items" <<endl;

    cout << "Enter item to search for \n";
    cin >> item;
    if(mylist.isFound(item))
    {
        cout << "Item Found\n";
    }
    else
    {
        cout << "item not found\n";
    }


    int newvalue;
    cout << "Enter Value to add \n";
    cin >> newvalue;
    cout << "Enter item to add before \n";
    cin >> item;
    mylist.InsertBefore(item,newvalue);
    mylist.Display();

    cout << "Enter Value to append \n";
    cin >> newvalue;
    mylist.Append(newvalue);
    mylist.Display();

    cout << "Enter item to delete\n";
    cin >> newvalue;
    mylist.Delete(newvalue);
    mylist.Display();
    return 0;
}
