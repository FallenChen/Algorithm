package leetcode.greedy.jump_game;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/17 18:56
 */
public class Solution {

    /**
     * Given an array of non-negative integers nums,
     * you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Determine if you are able to reach the last index.
     *
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     *
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums)
    {
        int dis = 0;
        for(int i=0; i<=dis; i++)
        {
            dis = Math.max(dis, i + nums[i]);
            if(dis >= nums.length - 1)
            {
                return true;
            }
        }
        return false;
    }
}
