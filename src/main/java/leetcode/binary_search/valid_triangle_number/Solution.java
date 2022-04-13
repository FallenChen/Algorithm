package leetcode.binary_search.valid_triangle_number;

import java.util.Arrays;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/29 19:19
 */
public class Solution {

    /**
     * Given an integer array nums, return the number of triplets chosen from the array that can
     * make triangles if we take them as side lengths of a triangle.
     *
     * Input: nums = [2,2,3,4]
     * Output: 3
     * Explanation: Valid combinations are:
     * 2,3,4 (using the first 2)
     * 2,3,4 (using the second 2)
     * 2,2,3
     *
     * Input: nums = [4,2,3,4]
     * Output: 4
     *
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {

        //  Brute Force
//        int count = 0;
//
//        for(int i=0; i<nums.length - 2; i++)
//        {
//            for(int j = i+1; j<nums.length - 1; j++)
//            {
//                for(int k = j + 1; k<nums.length; k++)
//                {
//                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i])
//                    {
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;

        // Binary Search

        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++)
        {
            int k = i+2;
            for(int j = i+1; j<nums.length - 1 && nums[i] != 0; j++)
            {
                k = binarySearch(nums,k,nums.length-1,nums[i] + nums[j]);
                count += (k-1) - (j+1) + 1;
            }
        }
        return count;
    }

    int binarySearch(int nums[], int l, int r, int x) {
        while (r >= l && r < nums.length)
        {
            int mid = (l+r)/2;
            if(nums[mid] >= x)
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }

        return l;
    }
}
