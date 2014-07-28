/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cur = head;
        
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head.next;
        cur = head;
        
        while (cur != null) {
            RandomListNode copyNode = cur.next;
            // Set random
            if (cur.random == null) {
                copyNode.random = null;
            } else {
                copyNode.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        // Recover
        cur = head;
        while (cur != null) {
            RandomListNode temp = cur.next.next;
            cur.next.next = cur.next.next == null? null : cur.next.next.next;
            cur.next = temp;
            cur = cur.next;
        }
        
        return dummy.next;
    }
}