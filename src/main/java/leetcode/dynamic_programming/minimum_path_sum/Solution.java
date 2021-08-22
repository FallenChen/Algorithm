package leetcode.dynamic_programming.minimum_path_sum;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/21 19:21
 */
public class Solution {

    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
     * which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     *
     * Input: grid = [[1,2,3],[4,5,6]]
     * Output: 12
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {

        // Suppose the minimum path sum of arriving at point (i, j) is S[i][j],
        // then the state equation is S[i][j] = min(S[i - 1][j], S[i][j - 1]) + grid[i][j].

        // Well, some boundary conditions need to be handled.
        // The boundary conditions happen on the topmost row (S[i - 1][j] does not exist) and
        // the leftmost column (S[i][j - 1] does not exist).
        // Suppose grid is like [1, 1, 1, 1], then the minimum sum to arrive at each point is
        // simply an accumulation of previous points and the result is [1, 2, 3, 4].

        int m = grid.length;
        int n = grid[0].length;

        for(int i=1; i<n; i++)
        {
            grid[0][i] += grid[0][i-1];
        }

        for(int i=1; i<m; i++)
        {
            grid[i][0] += grid[i-1][0];
            for(int j=1; j<n; j++)
            {
                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = { {1,2,9},
                         {2,3,2},
                         {4,5,9},
                         {12,2,3}};

        int i = minPathSum(grid);
        System.out.println(i);
    }
}
