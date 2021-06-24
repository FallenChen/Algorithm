package leetcode.dynamic_programming.min_cost_climbing_stairs;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/24 20:28
 */
public class Solution {

    /**
     * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
     *
     * You can either start from the step with index 0, or the step with index 1.
     *
     * Return the minimum cost to reach the top of the floor.
     *
     * Input: cost = [10,15,20]
     * Output: 15
     * Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
     *
     * Input: cost = [1,100,1,1,1,100,1,1,100,1]
     * Output: 6
     * Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
     * @param cost
     * @return
     */

    int[] dp;

    public int minCostClimbingStairs(int[] cost)
//    {
//        int n = cost.length;
//
//        return Math.min(minCost(cost,n-1),minCost(cost,n-2));
//    }
//
//    private int minCost(int[] cost, int n)
//    {
//        if(n < 0)
//        {
//            return 0;
//        }
//        if(n == 0 || n == 1)
//        {
//            return cost[n];
//        }
//        return cost[n] + Math.min(minCost(cost, n-1),minCost(cost,n-2));
//    }

    // dp

//    {
//        int n = cost.length;
//        dp = new int[n];
//        return Math.min(minCost(cost,n-1),minCost(cost,n-2));
//    }
//
//    private int minCost(int[] cost, int n)
//    {
//        if(n < 0)
//            return 0;
//        if(n==0 || n==1)
//        {
//            return cost[n];
//        }
//        if(dp[n] != 0)
//        {
//            return dp[n];
//        }
//        dp[n] = cost[n] + Math.min(minCost(cost,n-1), minCost(cost,n-2));
//        return dp[n];
//    }

    // bottom up
    {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if(n<=2)
        {
            return Math.min(first,second);
        }
        for(int i=2; i<n; i++)
        {
            int curr = cost[i] + Math.min(first,second);
            first = second;
            second = curr;
        }
        return Math.min(first,second);
    }
}
