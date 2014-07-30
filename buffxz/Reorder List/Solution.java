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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = new ListNode(0);
        prev.next = slow;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) break;
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
        
        // reverse
        ListNode cur = slow;
        ListNode dummy = new ListNode(0);
        dummy.next = cur;
        while (cur.next != null) {
            ListNode temp = dummy.next;
            dummy.next = cur.next;
            cur.next = cur.next.next;
            dummy.next.next = temp;
        }
        
        // merge
        ListNode left = head;
        ListNode right = dummy.next;
        while (left != null && right != null) {
            ListNode temp = left.next;
            left.next = right;
            right = right.next;
            if(temp == null) {
                left.next.next = right;
            } else {
                left.next.next = temp;
            }
            left = temp;
        }
        
    }
}