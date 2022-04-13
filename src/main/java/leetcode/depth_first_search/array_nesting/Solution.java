package leetcode.depth_first_search.array_nesting;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/9 20:10
 */
public class Solution {

    /**
     * You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].
     *
     * You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
     *
     *     The first element in s[k] starts with the selection of the element nums[k] of index = k.
     *     The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
     *     We stop adding right before a duplicate element occurs in s[k].
     *
     * Return the longest length of a set s[k].
     *
     * Input: nums = [5,4,0,3,1,6,2]
     * Output: 4
     * Explanation:
     * nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
     * One of the longest sets s[k]:
     * s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
     *
     * Input: nums = [0,1,2]
     * Output: 1
     *
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {

        int maxsize = 0;

        for(int i=0; i<nums.length; i++)
        {
            int size = 0;
            for(int k=i; nums[k]>=0; size++)
            {
                int ak = nums[k];
                nums[k]= -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize,size);
        }

        return maxsize;
    }
}
