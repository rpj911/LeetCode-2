/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode levelHead = root;
        levelHead.next = null;
        
        while (levelHead != null) {
            TreeLinkNode cur = levelHead;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelHead = levelHead.left;
        }
    }
}