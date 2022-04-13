package leetcode.string.longest_substring_without_repeating_characters;

import java.util.HashMap;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/5/12 17:39
 */
public class Solution {

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * Input: s = ""
     * Output: 0
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s)
    {
        // the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values,
        // and keep two pointers which define the max substring.
        // move the right pointer to scan through the string , and meanwhile update the hashmap.
        // If the character is already in the hashmap, then move the left pointer to the right of the same character last found.
        // Note that the two pointers can only move forward.
        if(s.length() == 0)
        {
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        for (int i=0, j=0; i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                j = Math.max(j,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
