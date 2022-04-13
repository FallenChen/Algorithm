package leetcode.backtracking.subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/8 19:57
 */
public class Solution {

    /**
     * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *

     Input: nums = [1,2,2]
     Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]


     Input: nums = [0]
     Output: [[],[0]]

     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0,false);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos, boolean choosePre) {

        if(pos == nums.length)
        {
            res.add(new ArrayList<>(ls));
            return;
        }
        helper(res, ls, nums, pos+1, false);
        if(pos >= 1 && nums[pos] == nums[pos-1] && !choosePre)
        {
            return;
        }
        ls.add(nums[pos]);
        helper(res,ls,nums,pos+1,true);
        ls.remove(ls.size() - 1);
    }


}
