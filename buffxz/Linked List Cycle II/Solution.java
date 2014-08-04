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
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head, fast = head;
        while (slow != null) {
            fast = fast.next;
            if (fast == null) return null;
            
            slow = slow.next;
            
            fast = fast.next;
            if (fast == null) return null;
            if (fast.equals(slow)) break;
        }
        
        ListNode cur = head;
        while (!cur.equals(slow)) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
        
        
    }
}