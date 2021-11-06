package leetcode.array.binary_search;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/6 19:46
 */
public class Solution {

    /**
     * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     * Explanation: 9 exists in nums and its index is 4
     *
     * Input: nums = [-1,0,3,5,9,12], target = 2
     * Output: -1
     * Explanation: 2 does not exist in nums so return -1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target)
    {
        // [left,right]
        int left = 0;
        int right = nums.length-1;
        while (left <= right)
        {
            // 等同于 (left + right)/2
            int middle = left + ((right - left)/2);
            if(nums[middle] > target)
            {
                right = middle - 1;
            }
            else if (nums[middle] < target)
            {
                left = middle + 1;
            }
            else
            {
                return middle;
            }
        }
        return -1;
    }
}
