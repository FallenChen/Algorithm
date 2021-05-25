package leetcode.dynamic_programming.longest_valid_parentheses;

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
        int maxlen = 0;
        for(int i=0; i<s.length();i++)
        {
            for(int j=i+2; j<=s.length();j++)
            {
                if(isValid(s.substring(i,j)))
                {
                    maxlen = Math.max(maxlen,j-i);
                }
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
}
