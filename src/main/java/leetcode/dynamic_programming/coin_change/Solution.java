package leetcode.dynamic_programming.coin_change;


/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/12/25 15:05
 */
public class Solution
{
    /**
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     *
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     *
     * You may assume that you have an infinite number of each kind of coin.
     *
     * Input: coins = [1,2,5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     *
     * Input: coins = [2], amount = 3
     * Output: -1
     *
     * Input: coins = [1], amount = 0
     * Output: 0
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount)
    {
//        if(amount < 1)
//        {
//            return 0;
//        }
//        return helper(coins, amount, new int[amount]);

        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            //正序遍历：完全背包每个硬币可以选择多次
            for (int j = coins[i]; j <= amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];

    }

    /**
     *
     * @param coins
     * @param rem remaining coins after the last step
     * @param count count[rem]: minimum number of coins to sum up to rem
     * @return
     */
    private int helper(int[] coins, int rem, int[] count)
    {
        if(rem<0) return -1; // not valid
        if(rem==0) return 0; // completed
        if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if(res>=0 && res < min)
                min = 1+res;
        }
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }
}
