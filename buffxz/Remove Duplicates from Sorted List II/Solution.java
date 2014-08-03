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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-100);
        dummy.next = head;
        
        ListNode cur = head;
        ListNode prev = dummy;
        ListNode real = dummy;
        
        while (cur != null && cur.next != null) {
            if (cur.val != prev.val && cur.val != cur.next.val) {
                real.next = cur;
                real = real.next;
            }
            prev = cur;
            cur = cur.next;
        }
        
        if (cur.val != prev.val) {
            real.next = cur;
            real = real.next;
        } 
        
        real.next = null;
        return dummy.next;
        
    }
}