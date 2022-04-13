package leetcode.string.longest_valid_parentheses;

import java.util.Stack;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/5/25 17:02
 */
public class Solution {

    /**
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.
     *
     * Input: s = "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()".
     *
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
     *
     * Input: s = ""
     * Output: 0
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        // Brute Force
//        int maxlen = 0;
//        for(int i=0; i<s.length();i++)
//        {
//            for(int j=i+2; j<=s.length();j+=2)
//            {
//                if(isValid(s.substring(i,j)))
//                {
//                    maxlen = Math.max(maxlen,j-i);
//                }
//            }
//        }
//        return maxlen;

        // Using Dynamic Programming
        int maxlen = 0;
        int dp[] = new int[s.length()];
        for(int i=1; i<s.length();i++)
        {
            if(s.charAt(i) == ')')
            {

                if(s.charAt(i-1) == '(')
                {
                    int count = i>=2 ? dp[i-2] : 0;
                    dp[i] = count + 2;
                }


                else if((i-dp[i-1] > 0) && (s.charAt(i-dp[i-1]-1) == '('))
                {
                    int count = (i-dp[i-1]) >= 2? dp[i - dp[i - 1] - 2] : 0;
                    dp[i] = dp[i-1] + count + 2;
                }
                maxlen = Math.max(maxlen,dp[i]);
            }
        }
        return maxlen;
    }

    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length();i++)
        {
            if (s.charAt(i) == '(')
            {
                stack.push('(');
            }else if(!stack.empty() && stack.peek() == '(')
            {
                stack.pop();
            }else
            {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int i = solution.longestValidParentheses("(()");
//        int i = solution.longestValidParentheses("())((()())");
        int i = solution.longestValidParentheses("(()())");
        System.out.println(i);
    }
}
