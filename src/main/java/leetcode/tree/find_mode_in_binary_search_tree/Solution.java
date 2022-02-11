package leetcode.tree.find_mode_in_binary_search_tree;


public class Solution {
	
	private int currVal;
	private int currCount = 0;
	private int maxCount = 0;
	private int modeCount = 0;

	private int[] modes;

	public int[] findMode(TreeNode root) 
	{
		inorder(root);
		modes = new int[modeCount];
		modeCount = 0;
		currCount = 0;
		inorder(root);
		return modes;
	}

	private void inorder(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		inorder(root.left);
		handleValue(root.val);
		inorder(root.right);
	}

	public void handleValue(int val)
	{
		if(val != currVal)
		{
			currVal = val;
			currCount = 0;
		}
		currCount++;
		if(currCount > maxCount)
		{
			maxCount = currCount;
			modeCount = 1;
		}
		else if (currCount == maxCount)
		{
			if(modes != null)
			{
				modes[modeCount] = currVal;
			}
			modeCount++;
		}
	}
}
