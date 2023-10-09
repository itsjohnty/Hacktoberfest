#include <iostream>
using namespace std;
class Node{
   public:
      int data;
      Node* next;
      Node(int data){
        this->data=data;
        this->next=NULL;
      }
      ~Node(){
        int value=this->data;
        if(this->next!=NULL){
            delete next;
            this->next=NULL;
        }
        cout<<value<<endl;
      }
};
void insertiontop(Node* &head,int d){
    Node* temp=new Node(d);
    temp->next=head;
    head=temp;
}
void insertiontail(Node* &tail,int d){
    Node* temp=new Node(d);
    tail->next=temp;
    tail=temp;
}
void insertposition(Node* &head,Node* &tail,int position,int d){
    if(position==1){
        insertiontop(head,d);
        return;
    }
    Node* temp=head;
    int cnt=1;
    while(cnt<position-1){
        temp=temp->next;
        cnt++;
    }
    if(temp->next==NULL){
        insertiontail(tail,d);
        return;
}
    Node* Nodetoinsert=new Node(d);
    Nodetoinsert->next=temp->next;
    temp->next=Nodetoinsert;
}
void deleteposition(Node* &head,Node* &tail,int position){
    if(position==1){
        Node* temp=head;
        head=head->next;
        temp->next=NULL;
        delete temp;
    }
    else{
       Node* current=head;
       Node* previous=NULL;
       int cnt=1;
       while(cnt<position){
          previous=current;
          current=current->next;
          cnt++;
       }
       if(current->next==NULL){
          tail=previous;
       }
       Node* temp=current;
       previous->next=temp->next;
       temp->next=NULL;
       delete  temp;
    }
}
void print(Node* &head){
    Node* temp=head;
    while(temp!=NULL){
        cout<<temp->data<<" ";
        temp=temp->next;
    }
    cout<<endl;
}
int main()
{
    Node* Node1=new Node(10);
    Node* head=Node1;
    Node* tail=Node1;
    insertiontail(tail,12);
    insertiontail(tail,15);
    insertiontail(tail,20);
    //insertposition(head,tail,1,22);
     //insertposition(head,tail,3,22);   
     //insertposition(head,tail,5,22); 
     deleteposition(head,tail,4);
    print(head);
    cout<<head->data<<endl;
    cout<<tail->data<<endl;
    return 0;
}
