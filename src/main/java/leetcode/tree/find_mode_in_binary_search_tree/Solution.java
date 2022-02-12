package leetcode.tree.find_mode_in_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	List<Integer> resList;
	int maxCount;
	int count;
	TreeNode prev;

	public int[] findMode(TreeNode root) 
	{
		resList = new ArrayList<>();
		maxCount = 0;
		count = 0;
		prev = null;

		hasMode(root);
		int[] res = new int[resList.size()];
		for (int i = 0; i < resList.size(); i++) {
		    res[i] = resList.get(i);
		}
		return res;
	}

	private void hasMode(TreeNode root) {
		if(root == null)
			return;
		hasMode(root.left);

		int val = root.val;

		if(prev != null && prev.val == val)
		{
			count++;
		}
		else
		{
			count = 1;
		}

		if(count > maxCount)
		{
			maxCount = count;
			resList.clear();
			resList.add(val);
		}
		else if(count == maxCount)
		{
			resList.add(val);
		}
		prev = root;

		hasMode(root.right);
	}

}
