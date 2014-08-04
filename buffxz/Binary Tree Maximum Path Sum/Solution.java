
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
    
    public int maxPathSum(TreeNode root) {
        Data res = helper(root);
        return res.sum;
    }
    
    public Data helper(TreeNode node) {
        Data data = new Data();
        if (node == null) return data;
        
        Data left = helper(node.left);
        Data right = helper(node.right);
        
        int curPath = Math.max(node.val, Math.max(node.val + Math.max(0, left.path), node.val + Math.max(0, right.path)));
        data.path = curPath;
        
        int curSum = Math.max(Math.max(left.sum, right.sum), Math.max(0, left.path) + Math.max(0, right.path) + node.val);
        data.sum = curSum;
        
        return data;
        
    }
    
    public class Data {
    	int path = 0;
        int sum = Integer.MIN_VALUE;
    }
}