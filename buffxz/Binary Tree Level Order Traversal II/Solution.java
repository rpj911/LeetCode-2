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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        boolean flag = false;
        
        result.add(0, new ArrayList<Integer>());
        
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                if (flag) break;
                queue.offer(null);
                result.add(0, new ArrayList<Integer>());
                flag = true;
            } else {
                flag = false;
                result.get(0).add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        result.remove(0);
        
        return result;
    }
}