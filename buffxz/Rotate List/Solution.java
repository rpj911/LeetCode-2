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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = head;
        int count = 1;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        cur.next = head;
        
        int k = count - n % count;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        dummy.next = cur.next;
        cur.next = null;
        
        return dummy.next;
    }
}