package leetcode.heap.ugly_number_ii;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/10 19:57
 */
public class Solution {

    /**
     * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
     *
     * Given an integer n, return the nth ugly number.
     *
     * Input: n = 10
     * Output: 12
     * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
     *
     * Input: n = 1
     * Output: 1
     * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for(int i=1; i<nums.length; i++)
        {
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if(nums[i] == nums[index2] * 2)
            {
                index2++;
            }
            if(nums[i] == nums[index3] * 3)
            {
                index3++;
            }
            if(nums[i] == nums[index5] * 5)
            {
                index5++;
            }

        }
        return nums[n - 1];
    }
}
