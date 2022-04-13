package leetcode.dynamic_programming.longest_palindromic_substring;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/30 16:48
 */
public class Solution {

    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     * nput: s = "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     *
     * Input: s = "cbbd"
     * Output: "bb"
     *
     * Input: s = "a"
     * Output: "a"
     *
     * Input: s = "ac"
     * Output: "a"
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for(int i=n-1; i>=0; i--)
        {
            for(int j=i; j<n; j++)
            {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1]);

                if(dp[i][j] && (res == null || j - i + 1 > res.length()))
                {
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}
