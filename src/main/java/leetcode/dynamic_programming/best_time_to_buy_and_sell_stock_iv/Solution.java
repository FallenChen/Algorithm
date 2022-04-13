package leetcode.dynamic_programming.best_time_to_buy_and_sell_stock_iv;

public class Solution {
	
	/**
	 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
	 * Find the maximum profit you can achieve. You may complete at most k transactions.
	 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
	 * 
	 * Input: k = 2, prices = [2,4,1]
	 * Output: 2
	 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
	 * 
	 * Input: k = 2, prices = [3,2,6,5,0,3]
	 * Output: 7
	 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. 
	 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

	 * @param k
	 * @param prices
	 * @return
	 */
	public int maxProfit(int k, int[] prices) 
	{
		int len = prices.length;
		if(k >= len / 2)
		{
			int maxProfit = 0;
			for(int i = 1; i < len; i++)
			{
				if(prices[i] > prices[i - 1])
				{
					maxProfit += prices[i] - prices[i - 1];
				}
			}
			return maxProfit;
		}

		int[][] dp = new int[k + 1][len];
		for(int i=1; i <= k; i++)
		{
			int maxDiff = - prices[0];
			for(int j = 1; j < len; j++)
			{
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, dp[i - 1][j-1] - prices[j]);
			}
		}
		return dp[k][len - 1];
	}

	// dp[i][j] = maximum profit from at most i transactions using prices[0...j]
	// A transaction is defined as one buy + sell.
	// Now on day j, we have two options
	// 1.Do nothing (or buy) which doesn't change the acquired profit : dp[i][j] = dp[i][j-1]
	// 2.Sell the stock: In order to sell the stock, you must've bought it on a day t=[0..j-1]. 
	// Maximum profit that can be attained is t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1]) where 
	// prices[j]-prices[t] is the profit from buying on day t and selling on day j. 
	// dp[i-1][t-1] is the maximum profit that can be made with at most i-1 transactions with prices prices[0..t-1].

	// Time complexity of this approach is O(n2k).
	// In order to reduce it to O(nk), we must find t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1]) this expression in constant time. 
	// If you see carefully,t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1]) is same as
	// prices[j] + t:0->j-1 max(dp[i-1][t-1]-prices[t])

	// Second part of the above expression maxTemp = t:0->j-1 max(dp[i-1][t-1]-prices[t]) 
	// can be included in the dp loop by keeping track of the maximum value till j-1.
}
