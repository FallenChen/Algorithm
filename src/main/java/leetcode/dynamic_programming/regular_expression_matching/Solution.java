package leetcode.dynamic_programming.regular_expression_matching;

/**
 * @ClassName Solution
 * @Description
 * @Author cy
 * @Date 2021/5/7 16:30
 */
public class Solution {

    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
     *
     *     '.' Matches any single character.
     *     '*' Matches zero or more of the preceding element.
     *
     * The matching should cover the entire input string (not partial).
     * @link https://leetcode.com/problems/regular-expression-matching/
     * @param text
     * @param pattern
     * @return
     */
    public static boolean isMatch(String text, String pattern) {

        // Recursion
//        if(pattern.isEmpty())
//        {
//            return text.isEmpty();
//        }
//        // case for '.'
//        boolean firstMatch = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//        // case for '*','*' can't be the first
//        if(pattern.length() >= 2 && pattern.charAt(1) == '*')
//        {
//            // aa , a*
//            boolean firstCase = firstMatch && isMatch(text.substring(1), pattern);
//            // ab, .* match any string
//            boolean secondCase = isMatch(text,pattern.substring(2));
//            return firstCase || secondCase;
//
//        }
//        else
//        {
//            return firstMatch && isMatch(text.substring(1),pattern.substring(1));
//        }

        // DP
        if(text == null || pattern == null)
        {
            return false;
        }

        int m = text.length();
        int n = pattern.length();

        // M[i][j] represents if the 1st i characters in text can match the 1st j characters in pattern
        boolean[][] M = new boolean[m+1][n+1];

        // initialization
        // 1. M[0][0] = true, since empty string matched empty pattern
        M[0][0] = true;

        // 2.M[i][0] = false(which is default value of the boolean array) since empty pattern cannot match non-empty string
        // 3.M[0][j]:
        for(int j=2; j< n+1; j+=2)
        {
            if (pattern.charAt(j-1) == '*' && M[0][j-2])
            {
                M[0][j] = true;
            }
        }

        for(int i=1; i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                char curTex = text.charAt(i - 1);
                char curPat = pattern.charAt(j - 1);
                if(curTex == curPat || curPat == '.')
                {
                    M[i][j] = M[i-1][j-1];
                }else if(curPat == '*')
                {
                    char preCurPat = pattern.charAt(j-2);
                    if(preCurPat != '.' && preCurPat != curTex)
                    {
                        M[i][j] = M[i][j-2];
                    }else
                    {
                        M[i][j] = (M[i][j-2] || M[i-1][j-2] || M[i-1][j]);
                    }
                }
            }
        }
        return M[m][n];
    }

    public static void main(String[] args) {
//        boolean match = isMatch("aa", "a");
//        boolean match = isMatch("aa", "a*");
//        boolean match = isMatch("ab", ".*");
//        boolean match = isMatch("aab", "c*a*b");
        boolean match = isMatch("mississippi", "mis*is*p*.");
        System.out.println(match);
    }
}
