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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return helper(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] preorder, int inL, int inR, int preL, int preR) {
        
        if (preL > preR) return null;
        if (preL == preR) {
            return new TreeNode(preorder[preL]);
        }
        TreeNode root = new TreeNode(preorder[preL]);
        
        int index = findIndex(inorder, preL, preorder[preL]);
        
        TreeNode left = helper(inorder, preorder, inL, index - 1, preL + 1, preL + 1 + (index - 1 - inL));
        TreeNode right = helper(inorder, preorder, index + 1, inR, preL + 1 + (index - 1 - inL) + 1, preR);
        
        root.left = left;
        root.right = right;
        return root;
    }
    
    private int findIndex(int[] array, int start, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
}