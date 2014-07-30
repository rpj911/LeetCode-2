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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        
        ListNode res = dummy;
        
        while (cur != null) {
            if (cur.next == null) {
                break;
            }
            ListNode temp = cur.next.next;
            dummy.next = cur.next;
            dummy.next.next = cur;
            dummy = cur;
            cur.next = temp;
            cur = temp;
        }
        
        return res.next;
    }
}