package leetcode.segment_tree.minimum_number_of_increments_on_subarrays_to_form_a_target_array;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/9 19:50
 */
public class Solution {

    /**
     * Given an array of positive integers target and an array initial of same size with all zeros.
     *
     * Return the minimum number of operations to form a target array from initial if you are allowed to do the following operation:
     *
     *     Choose any subarray from initial and increment each value by one.
     *
     * The answer is guaranteed to fit within the range of a 32-bit signed integer.
     *
     * Input: target = [1,2,3,2,1]
     * Output: 3
     * Explanation: We need at least 3 operations to form the target array from the initial array.
     * [0,0,0,0,0] increment 1 from index 0 to 4 (inclusive).
     * [1,1,1,1,1] increment 1 from index 1 to 3 (inclusive).
     * [1,2,2,2,1] increment 1 at index 2.
     * [1,2,3,2,1] target array is formed.
     *
     * Input: target = [3,1,1,2]
     * Output: 4
     * Explanation: (initial)[0,0,0,0] -> [1,1,1,1] -> [1,1,1,2] -> [2,1,1,2] -> [3,1,1,2] (target).
     *
     * Input: target = [3,1,5,4,2]
     * Output: 7
     * Explanation: (initial)[0,0,0,0,0] -> [1,1,1,1,1] -> [2,1,1,1,1] -> [3,1,1,1,1]
     *                                   -> [3,1,2,2,2] -> [3,1,3,3,2] -> [3,1,4,4,2] -> [3,1,5,4,2] (target).
     *
     * Input: target = [1,1,1,1]
     * Output: 1
     *
     * @param target
     * @return
     */
    public int minNumberOperations(int[] target)
    {
        // consider a chain made up of multiple links, each with different strengths
        // by applying force f at both the ends you weaken all links in the chain by f
        // now try to destroy the chain completely
        // as soon as we apply f = 1
        int totalOperations = target[0];
        for (int i=1;i<target.length;i++)
        {
            if(target[i] > target[i-1])
            {
                totalOperations += target[i] - target[i-1];
            }
        }

        return totalOperations;
    }
}
