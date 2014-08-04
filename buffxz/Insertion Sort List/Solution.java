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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        
        ListNode cur = head.next;
        ListNode itr;
        ListNode temp;
        ListNode next;
        head.next = null;
        
        while (cur != null) {
            itr = dummy;
            while (itr.next != null && itr.next.val < cur.val) {
                itr = itr.next;
            }
            next = cur.next;
            temp = itr.next;
            itr.next = cur;
            cur.next = temp;
            cur = next;
        }
        
        return dummy.next;
        
    }
}