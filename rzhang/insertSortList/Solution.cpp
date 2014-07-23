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
    ListNode *insertionSortList(ListNode *head) {
        if (!head) {
            return head;
        }
        
        ListNode* cur = head->next;
        ListNode* fhead = new ListNode(0);
        fhead->next = head;
        head->next = NULL;
        
        ListNode* prev = fhead;
        while (cur) {
            while (prev->next != NULL && prev->next->val <= cur->val) {
                prev = prev->next;
            }
            
            ListNode* next = cur->next;
            ListNode* tmp = prev->next;
            prev->next = cur;
            cur->next = tmp;
            cur = next;
            
            prev = fhead;
        }
        
        return fhead->next;
    }
};
