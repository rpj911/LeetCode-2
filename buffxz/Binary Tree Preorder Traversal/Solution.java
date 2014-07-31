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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(cur);
        result.add(cur.val);
        while (cur.left != null) {
            stack.push(cur.left);
            result.add(cur.left.val);
            cur = cur.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                stack.push(temp.right);
                result.add(temp.right.val);
                cur = temp.right;
                while (cur.left != null) {
                    stack.push(cur.left);
                    result.add(cur.left.val);
                    cur = cur.left;
                }
            }
        }
        
        return result;
    }
}