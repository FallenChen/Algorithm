package leetcode.tree.search_in_a_binary_search_tree;

public class Solution {
	

	public TreeNode searchBST(TreeNode root, int val) {
		if(root == null || root.val == val) {
			return root;
		}

		if(root.val > val) 
		{
			return searchBST(root.left, val);
		}
		if(root.val < val)
		{
			return searchBST(root.right, val);
		}
		return null;
	}
}
