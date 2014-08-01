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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // find the m th
        ListNode cur = head;
        ListNode prev = dummy;
        
        int count = m - 1;
        while (count > 0) {
            prev = cur;
            cur = cur.next;
            count--;
        }
        
        // reverse
        int k = n - m;
        while (k > 0) {
            ListNode temp = prev.next;
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = temp;
            k--;
        }
        
        return dummy.next;
        
    }
}