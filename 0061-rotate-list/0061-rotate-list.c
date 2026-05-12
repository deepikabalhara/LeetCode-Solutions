/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) 
{
    if(head==NULL || head->next==NULL || k==0)
    {
        return head;

    }

    struct ListNode *cur=head;
    int length =1;

    while(cur->next!=NULL){
        cur=cur->next;
        length++;
    }

    cur->next=head;
    k=k%length;

    int stepstotail = length-k;

    struct ListNode *newtail =head;

    for(int i=1;i<stepstotail;i++){
        newtail = newtail->next;

    }
    struct ListNode *newhead = newtail->next;  //head can also be used instead of newhead
    newtail->next=NULL;   //cutting

    return newhead;
}