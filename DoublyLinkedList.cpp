#include <bits/stdc++.h>

using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;

    Node(int data) {
        this->data = data;
        this->next = NULL;
        this->prev = NULL;
    }
};

class DoublyLinkedList {
public:
    Node* head;

    DoublyLinkedList() {
        this->head = NULL;
    }

    // Traversal function
    void printList() {
        Node* temp = head;
        while (temp != NULL) {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }

    // Insertion functions
    void insertAtBeginning(int data) {
        Node* newNode = new Node(data);
        newNode->next = head;
        if (head != NULL) {
            head->prev = newNode;
        }
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node* newNode = new Node(data);
        if (head == NULL) {
            head = newNode;
            return;
        }

        Node* temp = head;
        while (temp->next != NULL) {
            temp = temp->next;
        }

        temp->next = newNode;
        newNode->prev = temp;
    }

    void insertAfter(Node* prevNode, int data) {
        if (prevNode == NULL) {
            return;
        }

        Node* newNode = new Node(data);
        newNode->next = prevNode->next;
        if (prevNode->next != NULL) {
            prevNode->next->prev = newNode;
        }
        prevNode->next = newNode;
        newNode->prev = prevNode;
    }

    // Deletion functions
    void deleteAtBeginning() {
        if (head == NULL) {
            return;
        }

        Node* temp = head;
        head = head->next;
        if (head != NULL) {
            head->prev = NULL;
        }

        delete temp;
    }

    void deleteAtEnd() {
        if (head == NULL) {
            return;
        }

        Node* temp = head;
        while (temp->next != NULL) {
            temp = temp->next;
        }

        if (temp->prev != NULL) {
            temp->prev->next = NULL;
        } else {
            head = NULL;
        }

        delete temp;
    }

    void deleteNode(Node* delNode) {
        if (head == NULL || delNode == NULL) {
            return;
        }

        if (head == delNode) {
            deleteAtBeginning();
            return;
        }

        if (delNode->next == NULL) {
            deleteAtEnd();
            return;
        }

        delNode->prev->next = delNode->next;
        delNode->next->prev = delNode->prev;

        delete delNode;
    }
};

int main() {
    DoublyLinkedList llist;

    llist.insertAtEnd(1);
    llist.insertAtEnd(2);
    llist.insertAtEnd(3);
    llist.insertAtBeginning(0);

    cout << "Linked list: ";
    llist.printList();

    llist.deleteNode(llist.head->next);

    cout << "After deleting an element: ";
    llist.printList();

    return 0;
}
