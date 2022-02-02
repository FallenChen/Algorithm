package leetcode.two_pointers.four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	/**
	 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
	 * 0 <= a, b, c, d < n
	 * a, b, c, and d are distinct.
	 * nums[a] + nums[b] + nums[c] + nums[d] == target
	 * You may return the answer in any order.
	 * 
	 * Input: nums = [1,0,-1,0,-2,2], target = 0
	 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
	 * 
	 * Input: nums = [2,2,2,2,2], target = 8
	 * Output: [[2,2,2,2]]
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);

		for(int i = 0; i<nums.length; i++)
		{
			if(i>0 && nums[i] == nums[i-1])
				continue;
			for(int j = i+1; j<nums.length; j++)
			{
				if(j>i+1 && nums[j] == nums[j-1])
					continue;
				int left = j+1;
				int right = nums.length-1;
				while(left < right)
				{
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if(sum == target)
					{
						result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						while(left < right && nums[left] == nums[left+1])
							left++;
						while(left < right && nums[right] == nums[right-1])
							right--;
						left++;
						right--;
					}
					else if(sum < target)
						left++;
					else
						right--;
				}
			}
		}

		return result;
	}
}
