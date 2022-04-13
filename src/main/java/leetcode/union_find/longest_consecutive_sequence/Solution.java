package leetcode.union_find.longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/11 20:14
 */
public class Solution {

    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     *
     * You must write an algorithm that runs in O(n) time.
     *
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        for(int n: nums)
        {
            set.add(n);
        }

        int best = 0;
        for (int n : set)
        {
            // only check for one direction
            if(!set.contains(n-1))
            {
                int m = n + 1;
                while (set.contains(m))
                {
                    m++;
                }
                best = Math.max(best, m-n);
            }
        }
        return best;
    }
}
