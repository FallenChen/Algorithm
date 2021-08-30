package leetcode.matrix.valid_sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/30 19:44
 */
public class Solution {

    /**
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     *
     *     Each row must contain the digits 1-9 without repetition.
     *     Each column must contain the digits 1-9 without repetition.
     *     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     *
     * Note:
     *
     *     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     *     Only the filled cells need to be validated according to the mentioned rules.
     *
     *     Input: board =
     * [["5","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * Output: true
     *
     * Input: board =
     * [["8","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * Output: false
     * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
     * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
     *
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board)
    {
        Set<String> seen = new HashSet<>();
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                char number = board[i][j];
                if(number != '.')
                {
                    if(!seen.add(number + " in row " + i) ||
                       !seen.add(number + " in column " + j)||
                       !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
