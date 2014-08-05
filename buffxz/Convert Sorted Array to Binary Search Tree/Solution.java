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
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;
        return helper(num, 0, len - 1);
    }
    
    public TreeNode helper(int[] num, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(num[mid]);
        
        root.left = helper(num, left, mid - 1);
        root.right = helper(num, mid + 1, right);
        
        return root;
    }
}