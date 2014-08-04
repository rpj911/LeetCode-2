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
    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<String>();
        formPath(root, new StringBuilder(), res);
        
        int sum = 0;
        for (String str : res) {
            int number = Integer.valueOf(str);
            sum += number;
        }
        return sum;
    }
    
    private void formPath(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            // found
            sb.append(root.val);
            res.add(sb.toString());
        }
        
        StringBuilder left = new StringBuilder(sb);
        left.append(root.val);
        formPath(root.left, left, res);
        
        StringBuilder right = new StringBuilder(sb);
        right.append(root.val);
        formPath(root.right, right, res);
        
    }
}