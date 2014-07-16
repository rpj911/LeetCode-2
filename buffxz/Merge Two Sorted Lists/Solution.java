/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headB;
        } else if (headB == null) {
            return headA;
        }
        
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode cur = null;
        ListNode result = null;
        
        while (curA != null && curB != null) {
            if (curA.val <= curB.val) {
                // A is smaller
                if (cur == null) {
                    result = headA;
                    cur = curA;
                    curA = curA.next;
                } else {
                    cur.next = curA;
                    curA = curA.next;
                    cur = cur.next;
                }
            } else {
                // B is smaller
                if (cur == null) {
                    result = headB;
                    cur = curB;
                    curB = curB.next;
                } else {
                    cur.next = curB;
                    curB = curB.next;
                    cur = cur.next;
                }
            }
        }
        
        if (curA == null) {
            while (curB != null) {
                cur.next = curB;
                cur = cur.next;
                curB = curB.next;
            }
        } else {
            while (curA != null) {
                cur.next = curA;
                cur = cur.next;
                curA = curA.next;
            }
        }
        
        return result;
    }
}