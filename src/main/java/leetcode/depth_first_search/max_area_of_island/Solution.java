package leetcode.depth_first_search.max_area_of_island;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/11 20:44
 */
public class Solution {

    /**
     * You are given an m x n binary matrix grid.
     * An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
     * You may assume all four edges of the grid are surrounded by water.
     *
     * The area of an island is the number of cells with a value 1 in the island.
     *
     * Return the maximum area of an island in grid. If there is no island, return 0.
     *
     * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],
     *               [0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],
     *               [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * Output: 6
     * Explanation: The answer is not 11, because the island must be connected 4-directionally.
     *
     * Input: grid = [[0,0,0,0,0,0,0,0]]
     * Output: 0
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j< grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    max_area = Math.max(max_area, areaOfIsland(grid,i,j));
                }
            }
        }
        return max_area;
    }

    public int areaOfIsland(int[][] grid, int i, int j)
    {
        if(i >=0 && i < grid.length && j >=0 && j < grid[0].length && grid[i][j] == 1)
        {
            grid[i][j] = 0;
            return 1+ areaOfIsland(grid,i+1,j) + areaOfIsland(grid, i-1, j) +
                      areaOfIsland(grid, i, j-1) + areaOfIsland(grid,i, j+1);
        }
        return 0;
    }
}
