/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        
        TreeNode firstOne = null;
        TreeNode secondOne = null;
        int lastValue = Integer.MIN_VALUE;
        TreeNode prev = root;
        
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.val < lastValue) {
                if (firstOne == null) {
                    firstOne = prev;
                    secondOne = temp;
                } else {
                    secondOne = temp;
                    break;
                }
            }
            
            prev = temp;
            lastValue = temp.val;
            if (temp.right != null) {
                cur = temp.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        
        swap(firstOne, secondOne);
    }
    
    public void swap(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return;
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}