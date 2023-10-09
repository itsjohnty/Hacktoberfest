#include <bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
private:
    ListNode* mergeList(ListNode* node1, ListNode* node2){
        ListNode* fh = NULL, *ft = NULL;
        while(node1 and node2){
            if(!fh and !ft){
                if(node1 -> val > node2 -> val){
                    fh = node2;
                    ft = node2;
                    node2 = node2 -> next;
                }
                else{
                    fh = node1;
                    ft = node1;
                    node1 = node1 -> next;
                }
            }
            if(node1 and node2){
                if(node1 -> val < node2 -> val){
                    ft -> next = node1;
                    ft = ft -> next;
                    node1 = node1 -> next;
                }
                else{
                    ft -> next = node2;
                    ft = ft -> next;
                    node2 = node2 -> next;
                }
            }
        }
        if(node1){
            ft -> next = node1;
        }
        if(node2){
            ft -> next = node2;
        }

        return fh;
    }
public:
    ListNode* sortList(ListNode* head) {
        if(!head || !head -> next) return head;

        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* temp = new ListNode();

        while(fast && fast -> next){
            temp = slow;
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        temp -> next = nullptr;

        ListNode* l1 = sortList(head);
        ListNode* l2 = sortList(slow);

        return mergeList(l1, l2);
    }
};

int main()
{
    cout<<"Code in the backend of compiler\n";

    return 0;
}
