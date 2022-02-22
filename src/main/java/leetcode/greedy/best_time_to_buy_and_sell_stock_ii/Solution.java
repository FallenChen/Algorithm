package leetcode.greedy.best_time_to_buy_and_sell_stock_ii;

public class Solution {
	
	public int maxProfit(int[] prices) {
		int result = 0;
		for(int i=1; i<prices.length; i++)
		{
			result += Math.max(prices[i] - prices[i-1], 0);
		}
		return result;
	}
}
