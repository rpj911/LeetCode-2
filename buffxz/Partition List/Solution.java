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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        ListNode newDummy = new ListNode(0);
        ListNode newPrev = newDummy;
        
        ListNode cur = head;
        
        while (cur != null) {
            if (cur.val < x) {
                cur = cur.next;
                prev = prev.next;
            } else {
                prev.next = cur.next;
                newPrev.next = cur;
                newPrev = newPrev.next;
                cur = cur.next;
            }
        }
        
        prev.next = newDummy.next;
        newPrev.next = null;
        
        return dummy.next;
        
    }
}