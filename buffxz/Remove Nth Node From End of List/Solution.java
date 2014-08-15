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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        
        ListNode cur = dummy;
        int k = n;
        while (k > 0) {
            cur = cur.next;
            if (cur == null) return null;
            k--;
        }
        
        while (cur.next != null) {
            cur = cur.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}