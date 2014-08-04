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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head, fast = head;
        while (slow != null) {
            fast = fast.next;
            if (fast == null) return false;
            if (fast.equals(slow)) return true;
            
            slow = slow.next;
            
            fast = fast.next;
            if (fast == null) return false;
            if (fast.equals(slow)) return true;
        }
        
        return false;
    }
}