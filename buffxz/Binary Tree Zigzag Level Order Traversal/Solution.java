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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        boolean oddLevel = false;
        
        while (!stack.isEmpty()) {
            List<Integer> tempList = new ArrayList<Integer>();
            Stack<TreeNode> stackTemp = new Stack<TreeNode>();
            
            while (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                tempList.add(temp.val);
                if (oddLevel) {
                    if (temp.right != null) stackTemp.push(temp.right);
                    if (temp.left != null) stackTemp.push(temp.left);
                } else {
                    if (temp.left != null) stackTemp.push(temp.left);
                    if (temp.right != null) stackTemp.push(temp.right);
                }
            }
            
            stack = stackTemp;
            oddLevel = !oddLevel;
            result.add(tempList);
        }
        return result;
    }
}