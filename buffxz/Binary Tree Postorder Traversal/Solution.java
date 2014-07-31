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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(cur);
        result.add(0, cur.val);
        while (cur.right != null) {
            result.add(0, cur.right.val);
            stack.push(cur.right);
            cur = cur.right;
        }
        
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left != null) {
                stack.push(temp.left);
                result.add(0, temp.left.val);
                cur = temp.left;
                while (cur.right != null) {
                    result.add(0, cur.right.val);
                    stack.push(cur.right);
                    cur = cur.right;
                }
            } else {
                
            }
        }
        
        return result;
    }
}