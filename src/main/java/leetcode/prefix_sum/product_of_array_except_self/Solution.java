package leetcode.prefix_sum.product_of_array_except_self;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/8 20:06
 */
public class Solution {

    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     *
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     *
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     *
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     *
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        /**
         * Numbers:     2    3    4     5
         * Lefts:            2  2*3 2*3*4
         * Rights:  3*4*5  4*5    5
         *
         * Numbers:     2    3    4     5
         * Lefts:       1    2  2*3 2*3*4
         * Rights:  3*4*5  4*5    5     1
         */
        int n = nums.length;
        int[] res = new int[n];

        // Calculate lefts and store in res.
        int left = 1;
        for(int i=0; i<n; i++)
        {
            if(i>0)
            {
                left = left * nums[i-1];
            }
            res[i] = left;
        }

        // Calculate rights and the product from the end of the array.
        int right = 1;
        for(int i=n-1; i>=0; i--)
        {
            if(i<n-1)
            {
                right = right * nums[i+1];
            }
            res[i] *= right;
        }
        return res;
    }
}
