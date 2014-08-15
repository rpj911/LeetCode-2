import java.util.ArrayList;

public class Solution {
	ArrayList<TreeNode> getPath(TreeNode root, TreeNode n1, TreeNode n2) {
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		return helper(path, root, n1, n2);
	}
	
	ArrayList<TreeNode> helper(ArrayList<TreeNode> path, TreeNode root, TreeNode n1, TreeNode n2) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		
		if (root == null) {
			return null;
		}
		
		if (root.equals(n1) || root.equals(n2)) {
			ArrayList<TreeNode> mid = new ArrayList<TreeNode>(path);
			mid.add(root);
			
			ArrayList<TreeNode> otherOne = null;
			ArrayList<TreeNode> leftPath = new ArrayList<TreeNode>(path);
			leftPath.add(root.left);
			otherOne = helper(leftPath, root, n1, n2);
			
			if (otherOne == null) {
				ArrayList<TreeNode> rightPath = new ArrayList<TreeNode>(path);
				rightPath.add(root.right);
				otherOne = helper(rightPath, root, n1, n2);
			}
			
			if (otherOne == null) {
				return mid;
			} else {
				//merge
				formRes(res, mid, otherOne);
				return res;
			}
		} else {
			ArrayList<TreeNode> leftPath = new ArrayList<TreeNode>(path);
			leftPath.add(root.left);
			ArrayList<TreeNode> left = helper(leftPath, root, n1, n2);
			
			ArrayList<TreeNode> rightPath = new ArrayList<TreeNode>(path);
			rightPath.add(root.right);
			ArrayList<TreeNode> right = helper(rightPath, root, n1, n2);
			
			if (left == null && right == null) {
				return null;
			}
			
			//merge
			formRes(res, left, right);
			return res;
		}
	}
	
	/** Merge */
	void formRes(ArrayList<TreeNode> res, ArrayList<TreeNode> left, ArrayList<TreeNode> right) {
		int i = 0;
		while (i < left.size() && i < right.size()) {
			if (!left.get(i).equals(right.get(i))) {
				break;
			}
			i++;
		}
		int index = i - 1;
		for (int j = left.size() - 1; j >= index; j--) {
			res.add(left.get(j));
		}
		
		for (int j = index + 1; j < right.size(); j++) {
			res.add(right.get(j));
		}
	}
}