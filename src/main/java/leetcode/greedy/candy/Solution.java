package leetcode.greedy.candy;

import java.util.Arrays;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/1 21:30
 */
public class Solution {

    /**
     * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
     *
     * You are giving candies to these children subjected to the following requirements:
     *
     *     Each child must have at least one candy.
     *     Children with a higher rating get more candies than their neighbors.
     *
     * Return the minimum number of candies you need to have to distribute the candies to the children.
     *
     * Input: ratings = [1,0,2]
     * Output: 5
     * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
     *
     * Input: ratings = [1,2,2]
     * Output: 4
     * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
     * The third child gets 1 candy because it satisfies the above two conditions.
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings)
    {
        // Brute Force
//        int[] candies = new int[ratings.length];
//        Arrays.fill(candies,1);
//        boolean hasChanged = true;
//        while (hasChanged)
//        {
//            hasChanged = false;
//            for(int i=0; i< ratings.length; i++)
//            {
//                if(i != ratings.length-1 && ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]) {
//                    candies[i] = candies[i+1] + 1;
//                    hasChanged = true;
//                }
//                if(i > 0 && ratings[i] > ratings[i-1] && candies[i]<=candies[i-1])
//                {
//                    candies[i] = candies[i -1 ] + 1;
//                    hasChanged = true;
//                }
//            }
//        }
//        int sum = 0;
//        for(int candy: candies)
//        {
//            sum += candy;
//        }
//        return sum;

        // two loop
        // 1. Do it in two directions
        // 2. The first loop makes sure children with a higher rating get more candy than its left neighbor
        // 3. The second loop makes sure children with a higher rating get more candy than its right neighbor
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res,1);
        for(int i=1; i< n; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                res[i] = res[i-1] + 1;
            }
        }

        for(int i= n-1; i>0; i--)
        {
            if(ratings[i-1] > ratings[i])
            {
                res[i-1] = Math.max(res[i] + 1, res[i-1]);
            }
        }
        int sum = 0;
        for(int r: res)
        {
            sum += r;
        }
        return sum;
    }
}
