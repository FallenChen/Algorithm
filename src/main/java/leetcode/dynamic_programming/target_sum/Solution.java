package leetcode.dynamic_programming.target_sum;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/12/20 20:18
 */
public class Solution
{
    /**
     * You are given an integer array nums and an integer target.
     *
     * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
     *
     *     For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
     *
     * Return the number of different expressions that you can build, which evaluates to target.
     *
     * Input: nums = [1,1,1,1,1], target = 3
     * Output: 5
     * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     *
     * Input: nums = [1], target = 1
     * Output: 1
     *
     * @param nums
     * @param target
     * @return
     */
    int count = 0;
    public int findTargetSumWays(int[] nums, int target)
    {
        calculate(nums, 0, 0, target);
        return count;
    }

    private void calculate(int[] nums, int i, int sum, int target)
    {
        if(i == nums.length)
        {
            if (sum == target)
            {
                count++;
            }
        }
        else
        {
            calculate(nums, i + 1, sum + nums[i], target);
            calculate(nums, i + 1, sum - nums[i], target);
        }
    }


}
