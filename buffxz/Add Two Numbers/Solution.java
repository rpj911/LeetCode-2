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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode dummy = prev;
        
        ListNode i = l1;
        ListNode j = l2;
        int carry = 0;
        
        while ( i != null && j != null) {
            ListNode node = new ListNode((i.val + j.val + carry) % 10);
            if (i.val + j.val + carry >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            prev.next = node;
            prev = prev.next;
            i = i.next;
            j = j.next;
        }
        
        while ( j != null) {
            ListNode node = new ListNode((j.val + carry) % 10);
            if (j.val + carry >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            prev.next = node;
            prev = prev.next;
            j = j.next;
        }
        
        while ( i != null) {
            ListNode node = new ListNode((i.val + carry) % 10);
            if (i.val + carry >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            prev.next = node;
            prev = prev.next;
            i = i.next;
        }
        
        if (carry == 1) {
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        
        return dummy.next;
    }
}