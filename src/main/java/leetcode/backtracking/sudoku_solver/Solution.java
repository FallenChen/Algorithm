package leetcode.backtracking.sudoku_solver;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/23 19:51
 */
public class Solution {

    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     *
     * A sudoku solution must satisfy all of the following rules:
     *
     *     Each of the digits 1-9 must occur exactly once in each row.
     *     Each of the digits 1-9 must occur exactly once in each column.
     *     Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     *
     * The '.' character indicates empty cells.
     *
     * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
     * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
     * Explanation: The input board is shown above and the only valid solution is shown below:
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        doSolver(board,0,0);
    }

    private boolean doSolver(char[][] board, int row, int col) {
        for(int i=row; i<9; i++, col = 0)
        {
            for(int j=col; j<9; j++)
            {
                if(board[i][j] != '.')
                {
                    continue;
                }
                for (char num = '1'; num <= '9'; num++)
                {
                    if(isValid(board,i,j,num))
                    {
                        board[i][j] = num;
                        if(doSolver(board,i,j+1))
                        {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num)
    {
        int blkrow = (row/3)*3, blkcol = (col/3)*3;
        for(int i=0; i<9; i++)
        {
            if(board[i][col] == num || board[row][i] == num ||
            board[blkrow + i/3][blkcol + i%3] == num)
            {
                return false;
            }
        }
        return true;
    }
}
