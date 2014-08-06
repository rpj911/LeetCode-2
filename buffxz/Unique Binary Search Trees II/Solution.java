/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        int[] numbers = new int[n];
        for (int i = 1; i <= n; i++) {
            numbers[i - 1] = i;
        }
        
        return helper(numbers, 0, numbers.length- 1);
    }
    
    public List<TreeNode> helper(int[] numbers, int left, int right) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (left == right) {
            res.add(new TreeNode(numbers[left]));
            return res;
        }
        
        if (left > right) {
            res.add(null);
            return res;
        }
        
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = helper(numbers, left, i - 1);
            List<TreeNode> rightTrees = helper(numbers, i + 1, right);
            
            for (TreeNode leftSubTree : leftTrees) {
                for (TreeNode rightSubTree : rightTrees) {
                    TreeNode root = new TreeNode(numbers[i]);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}