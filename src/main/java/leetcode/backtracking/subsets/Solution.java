package leetcode.backtracking.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/21 17:43
 */
public class Solution {

    /**
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * Input: nums = [0]
     * Output: [[],[0]]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        // backtracking
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list,new ArrayList<Integer>(),nums,0);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
//        list.add(new ArrayList<>(tempList));
//        for(int i=start; i<nums.length; i++)
//        {
//            tempList.add(nums[i]);
//            backtrack(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }

        // DP
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums)
        {
            int size = result.size();
            for(int i=0; i<size; i++)
            {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}
