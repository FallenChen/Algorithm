package leetcode.binary_search.search_a_2d_matrix;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/15 17:37
 */
public class Solution {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     *
     *     Integers in each row are sorted from left to right.
     *     The first integer of each row is greater than the last integer of the previous row.
     *
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * Output: true
     *
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * Output: false
     *
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0)
        {
            return false;
        }

        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;

        while (start <= end)
        {
            int mid = (start + end)/2;
            if(matrix[mid/cols][mid%cols] == target)
            {
                return true;
            }
            if(matrix[mid / cols][mid % cols] < target)
            {
                start = mid + 1;
            }else
            {
                end = mid - 1;
            }
        }
        return false;
    }
}
