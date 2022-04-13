package leetcode.dynamic_programming.combination_sum_iv;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/12/23 21:04
 */
public class Solution
{
    /**
     * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
     *
     * The test cases are generated so that the answer can fit in a 32-bit integer.
     *
     * Input: nums = [1,2,3], target = 4
     * Output: 7
     * Explanation:
     * The possible combination ways are:
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * Note that different sequences are counted as different combinations.
     *
     * Input: nums = [9], target = 3
     * Output: 0
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target)
    {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for(int i=1; i<=comb.length; i++)
        {
            for(int j=0; j<nums.length; j++)
            {
                if (i - nums[j] >= 0)
                {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }
}
