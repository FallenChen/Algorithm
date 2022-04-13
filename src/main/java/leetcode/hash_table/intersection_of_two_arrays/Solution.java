package leetcode.hash_table.intersection_of_two_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/27 21:27
 */
public class Solution {

    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must be unique and you may return the result in any order.
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Explanation: [4,9] is also accepted.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2)
    {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int num : nums1)
        {
            if (binarySearch(nums2, num))
            {
                set.add(num);
            }
        }
        int i=0;
        int[] res = new int[set.size()];
        for(Integer num : set)
        {
            res[i++] = num;
        }
        return res;
    }

    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
            {
                return true;
            }
            if (nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return false;
    }
}
