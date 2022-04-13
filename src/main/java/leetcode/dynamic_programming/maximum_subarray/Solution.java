package leetcode.dynamic_programming.maximum_subarray;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/22 17:44
 */
public class Solution {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Input: nums = [1]
     * Output: 1
     *
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     */
    public int maxSubArray(int[] nums) {
        // dp
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        int max = dp[0];
//
//        for(int i=1; i<n; i++)
//        {
//            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i-1]: 0);
//            max = Math.max(max, dp[i]);
//        }
//        return max;
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for(int i = 1; i<nums.length; ++i)
        {
            maxEndingHere = Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
