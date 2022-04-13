package leetcode.stack.maximal_rectangle;

import java.util.Arrays;

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
    public static int maximalRectangle(char[][] matrix)
    {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
        {
            return 0;
        }

        int m = matrix.length, n=matrix[0].length, maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right,n-1);

        for(int i=0;i<m;i++)
        {
            int rb = n-1;
            for(int j = n-1; j>=0; j--)
            {
                if(matrix[i][j] == '1')
                {
                    right[j] = Math.min(right[j],rb);
                }else
                {
                    right[j] = n - 1;
                    rb = j - 1;
                }
            }
            int lb = 0;
            for(int j=0; j<n;j++)
            {
                if(matrix[i][j] == '1')
                {
                    left[j] = Math.max(left[j],lb);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                }else
                {
                    height[j] = 0;
                    left[j] = 0;
                    lb = j + 1;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        int i = maximalRectangle(matrix);
        System.out.println(i);
    }
}
