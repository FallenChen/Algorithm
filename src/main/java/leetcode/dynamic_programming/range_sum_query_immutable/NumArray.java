package leetcode.dynamic_programming.range_sum_query_immutable;

public class NumArray {

    /**
     * Given an integer array nums, handle multiple queries of the following type:
     *
     *     Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
     *
     * Implement the NumArray class:
     *
     *     NumArray(int[] nums) Initializes the object with the integer array nums.
     *     int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive
     *     (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
     *
     * Input
     * ["NumArray", "sumRange", "sumRange", "sumRange"]
     * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     * Output
     * [null, 1, -1, -3]
     *
     * Explanation
     * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
     * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
     * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
     * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
     * @param nums
     */

    // Brute Force
//    private int[] data;
//
//    public NumArray(int[] nums)
//    {
//        data = nums;
//    }
//
//    public int sumRange(int left, int right)
//    {
//        int sum = 0;
//        for(int k = left; k <= right; k++)
//        {
//            sum +=data[k];
//        }
//        return sum;
//    }



    // great solution

    int[] sums;

    // pre-compute the cummulative sum from index - to k
    public NumArray(int[] nums)
    {
        sums = new int[nums.length + 1];
        for(int i=0; i< nums.length; i++)
        {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right)
    {
        return sums[right+1] - sums[left];
    }
}
