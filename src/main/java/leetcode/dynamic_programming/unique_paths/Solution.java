package leetcode.dynamic_programming.unique_paths;

/**
 * @author cy
 * @className Solution
 * @description
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
        // 1.表示从（0 ，0）出发，到(n, m) 有dp[i][j]条不同的路径
        int[][] dp = new int[m][n];

        for(int row = 0; row < m; row++)
        {
            // 3. 初始化
            dp[row][0] = 1;
        }

        for(int col = 0; col < n; col++)
        {
            // 3.初始化
            dp[0][col] = 1;
        }
        // 4.确认遍历顺序
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                // 2.dp[i][j] 只有从两个方向 dp[i-1][j],dp[i][j-1]
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        // 5.举例推导dp数组
        // m=3,n=7
        // 1  1  1  1  1  1  1
        // 1  2  3  4  5  6  7
        // 1  3  6  10 15 21 28

        return dp[m-1][n-1];
    }
}
