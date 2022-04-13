package leetcode.dynamic_programming.best_time_to_buy_and_sell_stock_with_cooldown;

public class Solution {

	public int maxProfit(int[] prices) 
	{
		int n = prices.length;
		if (n == 0) return 0;

		// i day and j staus
		int[][] dp = new int[n][4];

		dp[0][0] -= prices[0];
		// 0: buy , 1: hold, 2: sell, 3: cooldown

		for(int i=1; i<n; i++)
		{
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][3], dp[i-1][1]) - prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
			dp[i][2] = dp[i-1][0] + prices[i];
			dp[i][3] = dp[i-1][2];
		}

		return Math.max(dp[n - 1][3],Math.max(dp[n - 1][1], dp[n - 1][2]));
	}
}
