package leetcode.array.spiral_matrix_ii;

public class Solution {
	
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];

		int left = 0, right = n - 1, top = 0, down = n - 1;
		int count = 1;
		while(left <= right)
		{
			// top left to right
			for(int j=left; j<=right; j++)
			{
				matrix[top][j] = count++;
			}
			top++;
			// right top to down
			for(int i=top; i<=down; i++)
			{
				matrix[i][right] = count++;
			}
			right--;
			// down right to left
			for(int j=right; j>=left; j--)
			{
				matrix[down][j] = count++;
			}
			down--;
			// left down to top
			for(int i=down; i>=top; i--)
			{
				matrix[i][left] = count++;
			}
			left++;
		}
		return matrix;
	}
}
