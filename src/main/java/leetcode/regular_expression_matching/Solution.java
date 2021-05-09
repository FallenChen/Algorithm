package leetcode.regular_expression_matching;

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

        if(pattern.isEmpty())
        {
            return text.isEmpty();
        }
        // case for '.'
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        // case for '*','*' can't be the first
        if(pattern.length() >= 2 && pattern.charAt(1) == '*')
        {
            // aa , a*
            boolean firstCase = firstMatch && isMatch(text.substring(1), pattern);
            // ab, .* match any string
            boolean secondCase = isMatch(text,pattern.substring(2));
            return firstCase || secondCase;

        }
        else
        {
            return firstMatch && isMatch(text.substring(1),pattern.substring(1));
        }

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
