package leetcode.tree.minimum_absolute_difference_in_bst;

public class Solution {
	
	TreeNode pre = null;
	int result = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		if(root == null) return result;
		traversal(root);
		return result;
	}

	private void traversal(TreeNode root) {
		if(root == null) return;
		// left
		traversal(root.left);

		if(pre != null)
		{
			result = Math.min(result, root.val - pre.val);
		}

		pre = root;

		// right
		traversal(root.right);
	}
}
