package leetcode.monotonic_stack.shortest_unsorted_continuous_subarray;

import java.util.Stack;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/16 15:40
 */
public class Solution {

    /**
     * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
     * then the whole array will be sorted in ascending order.
     *
     * Return the shortest such subarray and output its length.
     *
     * Input: nums = [2,6,4,8,10,9,15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     *
     * Input: nums = [1,2,3,4]
     * Output: 0
     *
     * Input: nums = [1]
     * Output: 0
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length, r = 0;
        for(int i=0; i<nums.length; i++)
        {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
            {
                l = Math.min(l,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = nums.length-1; i>=0; i--)
        {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
            {
                r = Math.max(r,stack.pop());
            }
            stack.push(i);
        }
        return r-l > 0 ? r-l+1 : 0;
    }
}
