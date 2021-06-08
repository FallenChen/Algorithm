package leetcode.sliding_window.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/8 17:23
 */
public class Solution {

    /**
     * Given two strings s and t of lengths m and n respectively,
     * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
     * If there is no such substring, return the empty string "".
     *
     * The testcases will be generated such that the answer is unique.
     *
     * A substring is a contiguous sequence of characters within the string.
     *
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     *
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     *
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        if(s.length() == 0 || t.length() == 0)
        {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t
        Map<Character, Integer> dictT = new HashMap<>();
        for(int i=0; i<t.length();i++)
        {
            Integer count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i),count+1);
        }

        // Number of unique characters in t, which need to be present in the desired window
        int required = dictT.size();

        // Left and Right pointer
        int left = 0, right = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency
        // e.g. if t is "AABC" then the window must have two A's, one B and one C
        // Thus formed would be = 3 when all these conditions are met
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (right < s.length())
        {
            // Add one character from the right to the window
            char c = s.charAt(right);
            Integer count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c,count+1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1
            if(dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue())
            {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'
            while (left <= right && formed == required)
            {
                c = s.charAt(left);

                // Save the smallest window until now
                if(ans[0] == -1 || right - left + 1 < ans[0])
                {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // The character at the position pointed by the
                // 'Left' pointer is no longer a part of the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if(dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue())
                {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window
                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "": s.substring(ans[1],ans[2] + 1);

    }
}
