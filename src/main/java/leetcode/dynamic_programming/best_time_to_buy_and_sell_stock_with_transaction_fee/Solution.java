package leetcode.dynamic_programming.best_time_to_buy_and_sell_stock_with_transaction_fee;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/2 15:30
 */
public class Solution {

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day,
     * and an integer fee representing a transaction fee.
     *
     * Find the maximum profit you can achieve. You may complete as many transactions as you like,
     * but you need to pay the transaction fee for each transaction.
     *
     * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
     *
     * Input: prices = [1,3,2,8,4,9], fee = 2
     * Output: 8
     * Explanation: The maximum profit can be achieved by:
     * - Buying at prices[0] = 1
     * - Selling at prices[3] = 8
     * - Buying at prices[4] = 4
     * - Selling at prices[5] = 9
     * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     *
     * Input: prices = [1,3,7,5,10,3], fee = 3
     * Output: 6
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for(int i=1; i<prices.length; i++)
        {
            // If I am not holding a share after today, then either I did not hold a share yesterday,
            // or that I held a share yesterday but I decided to sell it out today
            cash = Math.max(cash, hold + prices[i] - fee);
            // If I am holding a share after today, then either I am just continuing holding the share I had yesterday,
            // or that I held no share yesterday, but bought in one share today
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
