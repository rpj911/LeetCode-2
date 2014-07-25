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
    ListNode *detectCycle(ListNode *head) {
        if (!head || !head->next) {
            return NULL;
        }
        
        ListNode* slow = head;
        ListNode* fast = head->next;
        
        while (slow && fast && fast->next && slow != fast) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        if (!slow || !fast || !fast->next) {
            return NULL;
        }
        
        fast = head;
        slow = slow->next;
        while (fast != slow) {
            slow = slow->next;
            fast = fast->next;
        }
        
        return fast;
    }
};