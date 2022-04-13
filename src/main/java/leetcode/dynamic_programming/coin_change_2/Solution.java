package leetcode.dynamic_programming.coin_change_2;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/12/22 21:39
 */
public class Solution
{
    /**
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     *
     * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
     *
     * You may assume that you have an infinite number of each kind of coin.
     *
     * The answer is guaranteed to fit into a signed 32-bit integer.
     *
     * Input: amount = 5, coins = [1,2,5]
     * Output: 4
     * Explanation: there are four ways to make up the amount:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     *
     * Input: amount = 3, coins = [2]
     * Output: 0
     * Explanation: the amount of 3 cannot be made up just with coins of 2.
     *
     * Input: amount = 10, coins = [10]
     * Output: 1
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
//        int[] dp = new int[amount + 1];
//        dp[0] = 1;
//        for (int coin : coins) {
//            for (int i = coin; i <= amount; i++) {
//                dp[i] += dp[i - coin];
//            }
//        }
//        return dp[amount];

        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for(int j = 1; j <= amount; j++) {
                // dp[i - 1][j]: 完全不用当前硬币组成j有多少种组合
                //dp[i][j - coins[i - 1]] :使用至少一个当前硬币（与上面一条是互斥事件）组成组成j有多少组合
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

}
