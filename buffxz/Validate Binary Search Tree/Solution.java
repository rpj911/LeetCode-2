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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        int min = Integer.MIN_VALUE;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.val <= min) {
                return false;
            } else {
                min = temp.val;
            }
            
            if (temp.right != null) {
                stack.push(temp.right);
                cur = temp.right;
                while (cur.left != null) {
                    stack.push(cur.left);
                    cur = cur.left;
                }
            }
        }
        
        return true;
        
    }
}