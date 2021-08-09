package leetcode.depth_first_search.island_perimeter;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/9 19:48
 */
public class Solution {

    /**
     * You are given row x col grid representing a map where
     * grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
     *
     * Grid cells are connected horizontally/vertically (not diagonally).
     * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
     *
     * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
     * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
     * Determine the perimeter of the island.
     *
     * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
     * Output: 16
     * Explanation: The perimeter is the 16 yellow stripes in the image above.
     *
     * Input: grid = [[1]]
     * Output: 4
     *
     * Input: grid = [[1,0]]
     * Output: 4
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {

        /**
         * loop over the matrix and count the number of islands;
         * if the current dot is an island, count if it has any right neighbour or down neighbour;
         * the result is islands * 4 - neighbours * 2
         */
//        int islands = 0, neighbours = 0;
//
//        for(int i=0; i<grid.length; i++)
//        {
//            for(int j=0; j<grid[i].length; j++)
//            {
//                if(grid[i][j] == 1)
//                {
//                    islands++; // count islands
//                    if(i < grid.length - 1 && grid[i + 1][j] == 1)
//                    {
//                        neighbours++; // count down neighbours
//                    }
//
//                    if(j < grid[i].length - 1 && grid[i][j + 1] == 1)
//                    {
//                        neighbours++; // count right neighbours
//                    }
//                }
//            }
//        }
//        return islands * 4 - neighbours * 2;

        /**
         * The idea is each time, we encounter a boundary, count++
         */
        int m = grid.length;
        if(m == 0)
        {
            return 0;
        }
        int n = grid[0].length;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    return helper(grid, dir, i ,j);
                }
            }
        }

        return 0;
    }

    private int helper(int[][] grid, int[][] dir, int i, int j) {
        int m = grid.length, n = grid[0].length;
        grid[i][j] = -1;
        int count = 0;
        for(int[] d : dir)
        {
            int x = i + d[0];
            int y = j + d[1];

            if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0)
            {
                count++;
            }
            else
            {
                if(grid[x][y] == 1)
                {
                    count += helper(grid, dir, x, y);
                }
            }
        }
        return count;
    }
}
