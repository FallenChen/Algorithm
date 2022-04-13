package leetcode.array.find_all_duplicates_in_an_array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/18 19:59
 */
public class Solution {

    /**
     * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and
     * each integer appears once or twice, return an array of all the integers that appears twice.
     *
     * You must write an algorithm that runs in O(n) time and uses only constant extra space.
     *
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [2,3]
     *
     * Input: nums = [1,1,2]
     * Output: [1]
     *
     * Input: nums = [1]
     * Output: []
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; ++i)
        {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
            {
                res.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}
