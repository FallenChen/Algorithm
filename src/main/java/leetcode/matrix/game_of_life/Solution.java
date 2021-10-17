package leetcode.matrix.game_of_life;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/17 19:36
 */
public class Solution {

    /**
     * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised
     * by the British mathematician John Horton Conway in 1970."
     *
     * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1)
     * or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
     *
     *     Any live cell with fewer than two live neighbors dies as if caused by under-population.
     *     Any live cell with two or three live neighbors lives on to the next generation.
     *     Any live cell with more than three live neighbors dies, as if by over-population.
     *     Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     *
     * The next state is created by applying the above rules simultaneously to every cell in the current state,
     * where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
     *
     * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
     * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
     *
     * Input: board = [[1,1],[1,0]]
     * Output: [[1,1],[1,1]]
     *
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {

        int m = board.length, n = board[0].length;

        for(int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
            {
                int count = 0;
                for(int I= Math.max(0,i-1); I<Math.min(i+2,m); I++)
                {
                    for(int J=Math.max(0,j-1); J<Math.min(j+2,n); J++)
                    {
                        count += board[I][J] > 1 ? board[I][J] - 2 : board[I][J];
                    }
                }
                if(count == 3 || count - board[i][j] == 3)
                {
                    board[i][j] += 2;
                }
            }
        }
        for (int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                board[i][j] = board[i][j] > 1 ? 1 : 0;
            }
        }
    }
}
