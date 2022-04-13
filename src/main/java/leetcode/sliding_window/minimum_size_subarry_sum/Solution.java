package leetcode.sliding_window.minimum_size_subarry_sum;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/7 15:02
 */
public class Solution {

    /**
     * Given an array of positive integers nums and a positive integer target, return the minimal length of
     * a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     *
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     *
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     *
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {

        if(nums == null || nums.length == 0)
        {
            return 0;
        }

        int i=0, j=0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length)
        {
            sum += nums[j++];

            while (sum >= target)
            {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
