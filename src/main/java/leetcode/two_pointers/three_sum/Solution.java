package leetcode.two_pointers.three_sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/4 15:32
 */
public class Solution {

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     *
     * Input: nums = []
     * Output: []
     *
     * Input: nums = [0]
     * Output: []
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
         * For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
         * Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
         */
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0; i< nums.length-2; i++)
        {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1]))
            {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi)
                {
                    if(nums[lo] + nums[hi] == sum)
                    {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo+1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi-1])
                            hi--;
                        lo++;
                        hi--;
                    }
                    else if (nums[lo] + nums[hi] < sum)
                    {
                        lo++;
                    }
                    else
                    {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
