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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode front = new ListNode(-1);
        ListNode dummy = new ListNode(-1);
        ListNode prev = new ListNode(-1);
        dummy.next = head;
        front = dummy;
        
        while (front != null) {
            // Set the starting point of the reversing
            prev = front;
            
            // Test whether there are enough K nodes in front
            int count = k;
            while (count > 0) {
                front = front.next;
                if (front == null) {
                    return dummy.next;
                }
                count--;
            }
            
            // Reverse these K nodes
            ListNode cur = prev.next;
            count = k - 1;
            while (count > 0) {
                ListNode temp = prev.next;
                prev.next = cur.next;
                cur.next = cur.next.next;
                prev.next.next = temp;
                count--;
            }
            front = cur;
        }
        return dummy.next;
    }
}