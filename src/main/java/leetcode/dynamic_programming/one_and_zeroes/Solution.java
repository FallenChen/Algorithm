package leetcode.dynamic_programming.one_and_zeroes;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/12/21 20:06
 */
public class Solution
{
    /**
     * You are given an array of binary strings strs and two integers m and n.
     *
     * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
     *
     * A set x is a subset of a set y if all elements of x are also elements of y.
     *
     * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
     * Output: 4
     * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
     * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
     * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
     *
     * Input: strs = ["10","0","1"], m = 1, n = 1
     * Output: 2
     * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n)
    {
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for(String str : strs)
        {
            oneNum = 0;
            zeroNum = 0;
            for(char ch : str.toCharArray())
            {
                if (ch == '1')
                {
                    oneNum++;
                }else
                {
                    zeroNum++;
                }
            }
            for(int i=m; i>=zeroNum; i--)
            {
                for (int j=n; j>=oneNum; j--)
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
