package leetcode.dynamic_programming.wildcard_matching;

public class Solution {

    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
     *
     *     '?' Matches any single character.
     *     '*' Matches any sequence of characters (including the empty sequence).
     *
     * The matching should cover the entire input string (not partial).
     *
     * Input: s = "aa", p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     *
     * Input: s = "aa", p = "*"
     * Output: true
     * Explanation: '*' matches any sequence.
     *
     * Input: s = "cb", p = "?a"
     * Output: false
     * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
     *
     * Input: s = "adceb", p = "*a*b"
     * Output: true
     * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
     *
     * Input: s = "acdcb", p = "a*c?b"
     * Output: false
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p)
    {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        // origin: dp[0][0]: they do match, so dp[0][0] = true
        dp[0][0] = true;
        // first col: dp[i][0]: can't match when p is empty. All false.
        for (int i=1; i<=m; i++)
        {
            dp[i][0] = false;
        }
        // first row: dp[0][j]: except for String p starts with *, otherwise all false
        for(int j=1; j<=n; j++)
        {
            if(p.charAt(j-1) == '*')
            {
                dp[0][j]= true;
            }else
            {
                break;
            }
        }

        // todo change to Recursion version
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                // dp[i][j] = true 需要满足的条件
                if(p.charAt(j-1)!='*')
                {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?');
                }else
                {
                    // dp[i-1][j], means that * acts like an empty sequence eg: ab, ab*
                    // dp[i][j-1], means that * acts like any sequences eg: abcd, ab*
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
