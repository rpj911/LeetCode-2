/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode levelHead = root;
        levelHead.next = null;
        
        while (levelHead != null) {
            TreeLinkNode firstNonNull = findFirstParent(levelHead);
            if (firstNonNull == null) return;
            TreeLinkNode cur = firstNonNull;
            while (cur != null) {
                TreeLinkNode start;
                TreeLinkNode end;
                if (cur.left != null) {
                    start = cur.left;
                    start.next = findNextChild(cur, true);
                } 
                
                if (cur.right != null) {
                    start = cur.right;
                    start.next = findNextChild(cur, false);
                }
                cur = cur.next;
            }
            //
            levelHead = firstNonNull.left == null ? firstNonNull.right : firstNonNull.left;
        }
    }
    
    public static TreeLinkNode findNextChild(TreeLinkNode cur, boolean left) {
        if (left) {
            // left
            if (cur.right != null) {
                return cur.right;
            }
            // find the next one
            TreeLinkNode next = cur.next;
            while (next != null) {
                if (next.left != null) return next.left;
                if (next.right != null) return next.right;
                next = next.next;
            }
            return null;
        } else {
            // right
            // find the next one
        	TreeLinkNode next = cur.next;
            while (next != null) {
                if (next.left != null) return next.left;
                if (next.right != null) return next.right;
                next = next.next;
            }
            return null;
        }
    }
    
    public static TreeLinkNode findFirstParent(TreeLinkNode head) {
        TreeLinkNode cur = head;
        while (cur != null) {
            if (cur.left != null) return cur;
            if (cur.right != null) return cur;
            cur = cur.next;
        }
        
        return null;
    }
    

}