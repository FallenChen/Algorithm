package leetcode.dynamic_programming.best_time_to_buy_and_sell_stock;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/5/24 17:03
 */
public class Solution {

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock
     * and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //Brute Force
//        int maxProfit = 0;
//
//        for(int i=0; i<prices.length-1;i++)
//        {
//            for(int j=i+1; j<prices.length;j++)
//            {
//                int profit = prices[j] - prices[i];
//                if(profit > maxProfit)
//                {
//                    maxProfit = profit;
//                }
//            }
//        }
//        return maxProfit;

        //One pass
//        int maxProfit = 0;
//        int minPrice = Integer.MAX_VALUE;
//        for(int i=0; i<prices.length;i++)
//        {
//            if(prices[i] < minPrice)
//            {
//                minPrice = prices[i];
//            }
//            else if(prices[i]-minPrice > maxProfit)
//            {
//                maxProfit = prices[i]-minPrice;
//            }
//        }
//        return maxProfit;

        // Kadane's Algorithm
         int maxCur = 0, maxSoFar = 0;
         for(int i=1; i<prices.length;i++)
         {
             maxCur = Math.max(0,maxCur+=(prices[i]-prices[i-1]));
             maxSoFar = Math.max(maxCur,maxSoFar);
         }
         return maxSoFar;
    }
}
