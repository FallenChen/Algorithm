package leetcode.sliding_window.subarray_product_less_than_k;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/9 19:35
 */
public class Solution {

    /**
     * Given an array of integers nums and an integer k,
     * return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
     *
     * Input: nums = [10,5,2,6], k = 100
     * Output: 8
     * Explanation: The 8 subarrays that have product less than 100 are:
     * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
     * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
     *
     * Input: nums = [1,2,3], k = 0
     * Output: 0
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        /**
         * The idea is always keep an max-product-window less than K;
         *
         * Every time shift window by adding a new number on the right(j), if the product is greater than k,
         * then try to reduce numbers on the left(i), until the subarray product fit less than k again, (subarray could be empty);
         *
         * Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
         */
        if(k==0)
        {
            return 0;
        }

        int cnt = 0;
        int pro = 1;
        for(int i=0, j=0; j<nums.length; j++)
        {
            pro *= nums[j];
            while (i<=j && pro>=k)
            {
                pro /= nums[i++];
            }
            cnt += j-i+1;
        }
        return cnt;
    }
}
