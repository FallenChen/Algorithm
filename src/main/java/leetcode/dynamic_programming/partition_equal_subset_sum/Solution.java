package leetcode.dynamic_programming.partition_equal_subset_sum;

/**
 * @author cy
 * @className Solution
 * @description todo
 * @date 2021/12/14 20:11
 */
public class Solution
{
    /**
     * Given a non-empty array nums containing only positive integers,
     * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
     *
     * Input: nums = [1,5,11,5]
     * Output: true
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     *
     * Input: nums = [1,2,3,5]
     * Output: false
     * Explanation: The array cannot be partitioned into equal sum subsets.
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return false;
        }

        int n = nums.length;
        int sum = 0;

        for(int num : nums)
        {
            sum += num;
        }

        if(sum % 2 != 0)
        {
            return false;
        }

        int target = sum / 2;

        int[] dp = new int[target + 1];

        for(int i=0; i<n; i++)
        {
            for(int j = target; j >= nums[i]; j--)
            {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
