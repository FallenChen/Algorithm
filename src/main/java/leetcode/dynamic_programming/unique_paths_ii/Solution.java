package leetcode.dynamic_programming.unique_paths_ii;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/3 20:35
 */
public class Solution {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     *
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     *
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     *
     * An obstacle and space is marked as 1 and 0 respectively in the grid.
     *
     * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * Output: 2
     * Explanation: There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     *
     * Input: obstacleGrid = [[0,1],[0,0]]
     * Output: 1
     *
     * @param obstacleGrid
     * @return
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 1.表示从（0 ，0）出发，到(n, m) 有dp[i][j]条不同的路径
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int row = 0; row < m && obstacleGrid[row][0] == 0  ; row++) {
            // 3. 初始化 不能等于障碍物，障碍是1，障碍物后的都是0，见66行
            dp[row][0] = 1;
        }

        for (int col = 0; col < n && obstacleGrid[0][col] == 0; col++) {
            // 3.初始化
            dp[0][col] = 1;
        }
        // 4.确认遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 2.dp[i][j] 只有从两个方向 dp[i-1][j],dp[i][j-1]
                if(obstacleGrid[i][j] == 1)
                {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 5.举例推导dp数组
        // obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        // 1  1  1
        // 1  0  1
        // 1  1  2
        // 如果没有障碍物，[1][2]和[2][1]都是2
        return dp[m - 1][n - 1];
    }
}
