package leetcode.dynamic_programming.maximum_sum_of_3_non_overlapping_subarrays;

import java.util.Arrays;

public class Solution {

    /**
     * Given an integer array nums and an integer k,
     * find three non-overlapping subarrays of length k with maximum sum and return them.
     *
     * Return the result as a list of indices representing the starting position of each interval (0-indexed).
     * If there are multiple answers, return the lexicographically smallest one.
     *
     *
     * Input: nums = [1,2,1,2,6,7,5,1], k = 2
     * Output: [0,3,5]
     * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
     * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
     *
     * Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
     * Output: [0,2,4]
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length,maxsum =0;
        int[] sum = new int[n + 1],postLeft = new int[n],postRight = new int[n],ans = new int[3];
        for(int i=0; i<n;i++)
        {
            sum[i+1] = sum[i] + nums[i];
        }

        // DP for starting index of the left max sum interval
        for(int i=k, tot = sum[k] -sum[0]; i<n; i++)
        {
            if(sum[i+1]-sum[i+1-k] > tot)
            {
                postLeft[i] = i+1-k;
                tot = sum[i+1] - sum[i+1 - k];
            }
            else
            {
                postLeft[i] = postLeft[i-1];
            }

        }

        // DP for starting index of the right max sum interval
        postRight[n-k] = n-k;
        for(int i= n-k-1,tot = sum[n]-sum[n-k]; i>=0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                postRight[i] = i;
                tot = sum[i + k] - sum[i];
            } else
            {
                postRight[i] = postRight[i+1];
            }
        }

        // test all possible middle interval
        for(int i=k; i<= n-2*k;i++)
        {
            int l = postLeft[i-1], r = postRight[i+k];
            int tot = (sum[i+k]-sum[i]) + (sum[l+k] - sum[l])+(sum[r+k] - sum[r]);
            if(tot > maxsum)
            {
                maxsum = tot;
                ans[0] = l;
                ans[1]  = i;
                ans[2] = r;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        int k = 2;
        int[] ints = maxSumOfThreeSubarrays(nums, 2);
        Arrays.stream(ints)
                .forEach(num -> System.out.println(num));
    }
}
