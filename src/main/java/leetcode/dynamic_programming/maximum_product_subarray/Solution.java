package leetcode.dynamic_programming.maximum_product_subarray;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/11 20:01
 */
public class Solution {


    /**
     * Given an integer array nums, find a contiguous non-empty subarray within
     * the array that has the largest product, and return the product.
     *
     * It is guaranteed that the answer will fit in a 32-bit integer.
     *
     * A subarray is a contiguous subsequence of the array.
     *
     * Input: nums = [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     *
     * Input: nums = [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     *
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int n = nums.length, res = nums[0], l = 0, r = 0;

        for(int i=0; i<n; i++)
        {
            l = (l==0 ? 1 : l) * nums[i];
            r = (r==0 ? 1 : r) * nums[n-1-i];
            res = Math.max(res, Math.max(l, r));
        }

        return res;
    }
}
