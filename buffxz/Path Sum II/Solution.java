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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> temp = new ArrayList<Integer>(list);
            temp.add(root.val);
            res.add(temp);
            return;
        }
        
        List<Integer> leftList = new ArrayList<Integer>(list);
        leftList.add(root.val);
        helper(root.left, sum - root.val, leftList, res);
        
        List<Integer> rightList = new ArrayList<Integer>(list);
        rightList.add(root.val);
        helper(root.right, sum - root.val, rightList, res);
        
    }
}