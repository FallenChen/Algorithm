package leetcode.hash_table.four_sum_ii;

import java.util.HashMap;
import java.util.Map;

public class Solution 
{
	/**
	 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
	 * 0 <= i, j, k, l < n
	 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
	 * 
	 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
	 * Output: 2
	 * Explanation:
	 * The two tuples are:
	 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
	 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
	 * 
	 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
	 * Output: 1
	 * 
	 * @param nums1
	 * @param nums2
	 * @param nums3
	 * @param nums4
	 * @return
	 */
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) 
	{
		Map<Integer, Integer> map = new HashMap<>();
    
		//统计两个数组中的元素之和，同时统计出现的次数，放入map
		for(int i=0; i<nums3.length; i++) {
		    for(int j=0; j<nums4.length; j++) {
			int sum = nums3[i] + nums4[j];
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		    }
		}
		
		int res=0;
		//统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
		for(int i=0; i<nums1.length; i++) {
		    for(int j=0; j<nums2.length; j++) {
			res += map.getOrDefault(-1 * (nums1[i]+nums2[j]), 0);
		    }
		}
		
		return res;
	}	
}
