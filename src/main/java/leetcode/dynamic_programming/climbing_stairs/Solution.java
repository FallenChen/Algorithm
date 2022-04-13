package leetcode.dynamic_programming.climbing_stairs;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/9/24 20:42
 */
public class Solution {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     *
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if(n <= 2)
        {
            return n;
        }
        // 1. dp数组及下标定义
        int[] dp = new int[n+1];
        // 3.dp数组初始化
        dp[1] = 1;
        dp[2] = 2;
        // 4.遍历顺序
        for(int i=3; i<=n; i++)
        {
            // 2.递推公式
            dp[i] = dp[i-1] + dp[i-2];
        }
        // 5.举例推到dp数组  1，2，3，5，8
        return dp[n];
    }
}
