package leetcode.tree.maximum_binary_tree;

public class Solution {
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length);
	}

	private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
		if(l == r)
		{
			return null;
		}
		int max = max(nums, l, r);
		TreeNode root = new TreeNode(nums[max]);
		root.left = constructMaximumBinaryTree(nums, l, max);
		root.right = constructMaximumBinaryTree(nums, max + 1, r);
		return root;
	}

	private int max(int[] nums, int l, int r)
	{
		int max = l;
		for (int i = l; i < r; i++)
		{
			if (nums[i] > nums[max])
			{
				max = i;
			}
		}
		return max;
	}
}
