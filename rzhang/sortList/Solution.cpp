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
    ListNode *sort (ListNode *&head, int len) {
        if (len == 1) {
            ListNode *temp = head;
            head = head->next;
            temp->next = NULL;
            return temp;
        }    
        
        ListNode* left = sort(head, len/2);
        ListNode* right = sort(head, len - len/2);
        return merge(left, right);
    }
    
    ListNode *merge (ListNode *left, ListNode *right) {
        ListNode* head = new ListNode(0);
        ListNode* cur = head;
        
        while (left != NULL && right != NULL) {
            if (left->val < right->val) {
                cur->next = left;
                left = left->next;
            }
            else {
                cur->next = right;
                right = right->next;
            }
            cur = cur->next;
        }
        
        while (left != NULL) {
            cur->next = left;
            left = left->next;
            cur = cur->next;
        }
        while (right != NULL) {
            cur->next = right;
            right = right->next;
            cur = cur->next;
        }
        
        return head->next;
    }
    
    ListNode *sortList(ListNode *head) {
        if (!head)
            return NULL;
        
        int len = 0;
        ListNode* p = head;
        while (p) {
            len++;
            p = p->next;
        }
        
        if (len == 1)
            return head;
        
        return sort(head, len);
    }
};
