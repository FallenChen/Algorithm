package leetcode.stack.maximal_rectangle;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/4 20:00
 */
public class Solution {

    /**
     * Given a rows x cols binary matrix filled with 0's and 1's,
     * find the largest rectangle containing only 1's and return its area.
     *
     * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * Output: 6
     * Explanation: The maximal rectangle is shown in the above picture.
     *
     * Input: matrix = []
     * Output: 0
     *
     * Input: matrix = [["0"]]
     * Output: 0
     *
     * Input: matrix = [["1"]]
     * Output: 1
     *
     * Input: matrix = [["0","0"]]
     * Output: 0
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix)
    {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
        {
            return 0;
        }

        int m = matrix.length, n=matrix[0].length, maxArea = 0;

        for(int i=0;i<m;i++)
        {

        }
    }
}
