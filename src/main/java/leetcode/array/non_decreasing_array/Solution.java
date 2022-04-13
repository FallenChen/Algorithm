package leetcode.array.non_decreasing_array;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/1 14:34
 */
public class Solution {

    /**
     * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
     *
     * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
     *
     * Input: nums = [4,2,3]
     * Output: true
     * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
     *
     * Input: nums = [4,2,1]
     * Output: false
     * Explanation: You can't get a non-decreasing array by modify at most one element.
     *
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {

        int cnt = 0; // the number of changes

        for(int i=1; i<nums.length && cnt <=1; i++)
        {

            // The problem requires that every number has to be equal or greater than previous number.
            // Make the previous number smaller or equal to current number
            // Make the current number equal to previous number

            if(nums[i-1] > nums[i])
            {
                cnt++;
                if(i-2 < 0 || nums[i-2] <= nums[i])
                {
                    nums[i-1] = nums[i]; // modify nums[i-1] of a priority
                }
                else
                {
                    nums[i] = nums[i-1]; // have to modify nums[i]
                }
            }
        }
        return cnt <= 1;
    }
}
