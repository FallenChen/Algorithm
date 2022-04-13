package leetcode.dynamic_programming.best_time_to_buy_and_sell_stock;

/**
 * @author cy
 * @className Solution
 * @description
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
        // 粗暴的高级解决方案
         int maxCur = 0, maxSoFar = 0;
         for(int i=1; i<prices.length;i++)
         {
             // 累减累加起来等于减 a3 - a2 + a2 - a1 = a3 - a1
             maxCur = Math.max(0,maxCur+=(prices[i]-prices[i-1]));
             maxSoFar = Math.max(maxCur,maxSoFar);
         }
         return maxSoFar;
    }

    /**
     * A more clear explanation on why sum of subarray works.:
     *
     * Suppose we have original array:
     * [a0, a1, a2, a3, a4, a5, a6]
     *
     * what we are given here(or we calculate ourselves) is:
     * [b0, b1, b2, b3, b4, b5, b6]
     *
     * where,
     * b[i] = 0, when i == 0
     * b[i] = a[i] - a[i - 1], when i != 0
     *
     * suppose if a2 and a6 are the points that give us the max difference (a2 < a6)
     * then in our given array, we need to find the sum of sub array from b3 to b6.
     *
     * b3 = a3 - a2
     * b4 = a4 - a3
     * b5 = a5 - a4
     * b6 = a6 - a5
     *
     * adding all these, all the middle terms will cancel out except two
     * i.e.
     *
     * b3 + b4 + b5 + b6 = a6 - a2
     *
     * a6 - a2 is the required solution.
     *
     * so we need to find the largest sub array sum to get the most profit
     */
}
