package leetcode.backtracking.permutations_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new LinkedList<>();

        boolean[] used = new boolean[nums.length];

        Arrays.fill(used, false);

        Arrays.sort(nums);

        backTrack(nums, used, path, result);

        return result;
        
    }

    private void backTrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {

        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++)
        {
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false)
            {
                continue;
            }

            if(used[i] == false)
            {
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, used, path, result);
                path.remove(path.size()-1);
                used[i] = false;
            }
        }
    }



}
