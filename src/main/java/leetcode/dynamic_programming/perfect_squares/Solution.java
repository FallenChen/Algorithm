package leetcode.dynamic_programming.perfect_squares;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/20 20:38
 */
public class Solution {


    /**
     * Given an integer n, return the least number of perfect square numbers that sum to n.
     *
     * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
     * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     *
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4.
     *
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9.
     *
     * @param n
     * @return
     */

    static List<Integer> result = new ArrayList<>();

    public int numSquares(int n) {
        if(result.size() == 0)
        {
            result.add(0);
        }

        while (result.size() <= n)
        {
            int m = result.size();
            int tempMin = Integer.MAX_VALUE;
            for(int j=1; j*j <= m; j++)
            {
                tempMin = Math.min(tempMin, result.get(m-j*j) + 1);
            }
            result.add(tempMin);
        }
        return result.get(n);
    }
}
