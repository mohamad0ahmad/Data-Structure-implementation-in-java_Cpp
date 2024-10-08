#include <iostream>
using namespace std;

class Array
{
private:
    int size;
    int AllocatedItems = 0;
    int *items;
public:
    Array(int arrSize)
    {
        size = arrSize;
        items = new int[arrSize];
    }
    ~Array() 
    {
        delete[] items;
    }
    void Fill()
    {
        int no_of_items;
        cout << "How many items you want to fill \n";
        cin>> no_of_items;
        if(no_of_items>size || no_of_items < 0)
        {
            cout<<"Invalid number of items. Please enter a number between 0 and " << size << ".\n";
        }
        else
        {
            for(int i = 0; i<no_of_items; i++)
            {
                cout <<"Enter item num "<<i<<"\n";
                cin >>items[i];
                AllocatedItems++;
            }
        }
    }
    void Display(){
        cout << "Array elements: ";
        for (int i = 0; i < AllocatedItems; i++) {
            cout << items[i] << " ";
        }
        cout << "\n";
    }

     int getSize(){
        return size;
    }
    int getAllocatedItems(){
        return AllocatedItems;
    }
    int Search(int Key){

        int index = -1;
        for(int i = 0;i < AllocatedItems; i++){
            if(items[i] == Key){
                index = i;
                break;
            }
        }
        return index;
    }
    void Append(int newitem){
        if(AllocatedItems < size){
            items[AllocatedItems] = newitem;
            AllocatedItems++;
        }else{
            cout << "Array is full";
        }

    }
    void Insert(int index,int newitem){
        if(AllocatedItems >= size) {
        cout << "Array is full, cannot insert new item.\n";
        return;
        }
        if(index >= 0 && index < AllocatedItems){
            for(int i = AllocatedItems; i > index; i--){
                items[i]=items[i-1];
            }
            items[index]=newitem;
            AllocatedItems++;
        }else{
            cout << "index out of range";
        }
    }
    void Delete(int index){
        if(AllocatedItems > 0 && index >= 0 && index < AllocatedItems){
            for(int i = index; i < AllocatedItems-1 ; i++){
                items[i]=items[i+1];
            }

            AllocatedItems--;
        }else{
            cout << "index out of array elements or array is empty \n";
        }
    }
    void Enlarge(int newsize){
        if(newsize <= size){
            cout <<"New size must be larger than old size";
            return;
        }else{
            size = newsize;
            int* old;
            old =items;
            items = new int[newsize];
            for(int i = 0; i < AllocatedItems; i++){
                items[i]=old[i];
            }
            delete []old;
        }
    }
    void Merge(Array other){
        int newsize = size + other.getSize();
        size = newsize;
        int *old =items;
        items = new int[newsize];
        int i;
        for(i = 0 ;i < AllocatedItems; i++){
            items[i]= old[i];
        }
        delete[]old;
        int j = i;
        for(int i = 0;i < other.getAllocatedItems();i++){
            items[j++] = other.items[i];
            AllocatedItems++;
        }
    }

};
int main()
{
    int arrsize;
    cout<<"Enter Array size \n";
    cin>>arrsize;
    Array myarray(arrsize);

    myarray.Fill();

    myarray.Display();


    int Key;
    cout<<"Enter The Value to Search \n";
    cin >> Key;
    int index =myarray.Search(Key);
    if(index == -1){
        cout<<"item not found \n";
    }else{
        cout << "item found at index "<< index << endl;
    }

    int newitem;
    cout << "Enter new item to Append\n";
    cin >>newitem;
    myarray.Append(newitem);

    cout << "Enter index and new item to insert \n";
    cin>>index;
    cin>>newitem;
    myarray.Insert(index,newitem);

    myarray.Display();

    int item;
    cout << "Enter index to delete \n";
    cin>>item;
    myarray.Delete(item);

    int newsize;
    cout<<"Enter new size to enlarge \n";
    cin>>newsize;
    myarray.Enlarge(newsize);

    myarray.Display();
    Array other(3);
    other.Fill();
    myarray.Merge(other);
    myarray.Display();
    return 0;
}
