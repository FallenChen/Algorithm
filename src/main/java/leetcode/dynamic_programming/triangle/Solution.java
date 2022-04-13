package leetcode.dynamic_programming.triangle;

import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/29 20:41
 */
public class Solution {

    /**
     * Given a triangle array, return the minimum path sum from top to bottom.
     *
     * For each step, you may move to an adjacent number of the row below.
     * More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
     *
     * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * Output: 11
     * Explanation: The triangle looks like:
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
     *
     * Input: triangle = [[-10]]
     * Output: -10
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle == null || triangle.size() == 0)
        {
            return 0;
        }

        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[] M = new int[n];
        M[0] = triangle.get(0).get(0);

        // M[j] = min(M[j-1], M[j]) + curVal
        for(int i=1; i<m; i++)
        {
            List<Integer> cur = triangle.get(i);
            for(int j= cur.size() - 1; j>=0; j--)
            {
                if(j == 0)
                {
                    M[0] = M[0] + cur.get(j);
                }
                else if(j == cur.size() - 1)
                {
                    M[j] = M[j-1] + cur.get(j);
                }
                else
                {
                    M[j] = Math.min(M[j-1], M[j]) + cur.get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            min = Math.min(min, M[i]);
        }

        return min;
    }
}
