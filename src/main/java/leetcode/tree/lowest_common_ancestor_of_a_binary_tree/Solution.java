package leetcode.tree.lowest_common_ancestor_of_a_binary_tree;

public class Solution {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if(root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left == null && right == null)
		{
			return null;
		}
		else if(left !=null && right == null)
		{
			return left;
		}
		else if(right != null && left == null)
		{
			return right;
		}
		else
		{
			return root;
		}
	}
}
