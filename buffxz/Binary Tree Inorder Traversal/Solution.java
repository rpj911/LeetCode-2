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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(cur);
        while (cur.left != null) {
            stack.push(cur.left);
            cur = cur.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
                cur = temp.right;
                while (cur.left != null) {
                    stack.push(cur.left);
                    cur = cur.left;
                }
            }
        }
        
        return result;
    }
}