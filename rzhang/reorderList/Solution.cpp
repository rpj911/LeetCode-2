/**
 *  * Definition for singly-linked list.
 *   * struct ListNode {
 *    *     int val;
 *     *     ListNode *next;
 *      *     ListNode(int x) : val(x), next(NULL) {}
 *       * };
 *        */
class Solution {
public:
    void reorderList(ListNode *head) {
        ListNode* fhead = new ListNode(0);
        fhead->next = head;
        
        ListNode* slow = fhead;
        ListNode* fast = head;
        
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        ListNode* fhead2 = new ListNode(0);
        ListNode* cur = slow->next;
        fhead2->next = NULL;
        
        slow->next = NULL;
        
        while (cur) {
            ListNode* tmp = cur->next;
            cur->next = fhead2->next;
            fhead2->next = cur;
            cur = tmp;
        }
        
        ListNode* ret = new ListNode(0);
        ListNode* prev = ret;
        
        ListNode* cur1 = fhead->next;
        ListNode* cur2 = fhead2->next;
        
        while (cur1 && cur2) {
            ListNode* tmp1 = cur1->next;
            ListNode* tmp2 = cur2->next;
            
            prev->next = cur1;
            prev = prev->next;
            prev->next = cur2;
            prev = prev->next;
            
            cur1 = tmp1;
            cur2 = tmp2;
        }
        
        if (cur1) {
            prev->next = cur1;
        }
        if (cur2) {
            prev->next = cur2;
        }
        
    }
};
