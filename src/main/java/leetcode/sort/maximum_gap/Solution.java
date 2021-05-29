package leetcode.sort.maximum_gap;

import java.util.Arrays;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/5/29 20:07
 */
public class Solution {

    /**
     * Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
     * If the array contains less than two elements, return 0.
     * You must write an algorithm that runs in linear time and uses linear extra space.
     *
     * Input: nums = [3,6,9,1]
     * Output: 3
     * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
     *
     * Input: nums = [10]
     * Output: 0
     * Explanation: The array contains less than 2 elements, therefore return 0.
     *
     * @param nums
     * @return
     */
    public int maxiumGap(int[] nums)
    {
        if(nums == null || nums.length < 2)
        {
            return 0;
        }

        // get the max and min value of the array
        int min = nums[0];
        int max = nums[0];
        for (int i : nums)
        {
            min = Math.min(min,i);
            max = Math.max(max,i);
        }

        // the minimum possible gap, ceiling of the integer division
        int gap = (int) Math.ceil((double) (max - min)/(nums.length - 1));
        int[] bucketsMIN = new int[nums.length - 1];
        int[] bucketsMAX = new int[nums.length - 1];
        Arrays.fill(bucketsMIN,Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX,Integer.MIN_VALUE);
        // put numbers into buckets
        for(int i: nums)
        {
            if (i == min || i == max)
                continue;
            int idx = (i-min)/gap;// index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.min(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i=0; i<nums.length;i++)
        {
            if(bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE )
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous);//update the final max value gap
        return maxGap;
    }
}
