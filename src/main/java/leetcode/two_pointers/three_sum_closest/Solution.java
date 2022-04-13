package leetcode.two_pointers.three_sum_closest;

import java.util.Arrays;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/31 19:50
 */
public class Solution {

    /**
     * Given an integer array nums of length n and an integer target,
     * find three integers in nums such that the sum is closest to target.
     *
     * Return the sum of the three integers.
     *
     * You may assume that each input would have exactly one solution.
     *
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     *
     * Input: nums = [0,0,0], target = 1
     * Output: 0
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for(int start = 0; start < nums.length - 2; start++)
        {
            int middle = start + 1;
            int end = nums.length - 1;

            while (middle < end)
            {
                int sum = nums[start] + nums[middle] + nums[end];
                if(sum == target)
                {
                    return target;
                }

                else if(sum > target)
                {
                    end--;
                }

                else
                {
                    middle++;
                }

                if(Math.abs(sum - target) < Math.abs(result - target))
                {
                    result = sum;
                }
            }
        }

        return result;
    }


}
