package leetcode.backtracking.combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	/**
	 * Given a collection of candidate numbers (candidates) and a target number (target), 
	 * find all unique combinations in candidates where the candidate numbers sum to target.
	 * Each number in candidates may only be used once in the combination.
	 * Note: The solution set must not contain duplicate combinations.
	 * 
	 * Input: candidates = [10,1,2,7,6,1,5], target = 8
	 * Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
	 * 
	 * Input: candidates = [2,5,2,1,2], target = 5
	 * Output: [[1,2,2],[5]]
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) 
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return result;
		
		Arrays.sort(candidates);
		
		List<Integer> list = new ArrayList<Integer>();
		combinationSum2(candidates, target, 0, list, result);
		
		return result;
	}

	private void combinationSum2(int[] candidates, int target, int cur, List<Integer> list,
			List<List<Integer>> result) 
	{
		if(0 == target)
		{
			result.add(new ArrayList<Integer>(list));
			return;
		}

		if( 0 > target)
		{
			return;
		}

		for(int i= cur; i< candidates.length; i++)
		{
			// on the same level, we can only use the same number once
			// delete duplicate
			if(i > cur && candidates[i] == candidates[i-1])
			{
				continue;
			}
			
			list.add(candidates[i]);
			combinationSum2(candidates, target - candidates[i], i+1, list, result);
			list.remove(list.size()-1);
		}
	}	
}
