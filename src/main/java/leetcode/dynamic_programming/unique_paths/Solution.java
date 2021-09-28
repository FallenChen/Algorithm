package leetcode.dynamic_programming.unique_paths;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/28 19:35
 */
public class Solution {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     *
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     *
     * How many possible unique paths are there?
     *
     * Input: m = 3, n = 7
     * Output: 28
     *
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Down -> Down
     * 2. Down -> Down -> Right
     * 3. Down -> Right -> Down
     *
     * Input: m = 7, n = 3
     * Output: 28
     *
     * Input: m = 3, n = 3
     * Output: 6
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n)
    {
        int[][] dp = new int[n][m];

        for(int row = 0; row < n; row++)
        {
            dp[row][0] = 1;
        }

        for(int col = 0; col < m; col++)
        {
            dp[0][col] = 1;
        }
        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[n-1][m-1];
    }
}
