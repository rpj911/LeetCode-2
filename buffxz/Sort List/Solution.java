/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        // Break down the list, find the mid to be the new head
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
        }
        
        if (prev == null) {
            return head;  
        } else {
            prev.next = null;
        }
        ListNode newHead = slow;
        
        ListNode result = merge(sortList(head), sortList(newHead));
        return result;
    }
    
    public ListNode merge(ListNode headA, ListNode headB) {
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