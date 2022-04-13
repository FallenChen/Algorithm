package leetcode.hash_table.two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/28 20:40
 */
public class Solution
{
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
