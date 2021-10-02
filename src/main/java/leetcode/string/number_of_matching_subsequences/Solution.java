package leetcode.string.number_of_matching_subsequences;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/2 13:52
 */
public class Solution {

    /**
     * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
     *
     * A subsequence of a string is a new string generated from the original string with some characters (can be none)
     * deleted without changing the relative order of the remaining characters.
     *
     *     For example, "ace" is a subsequence of "abcde".
     *
     * Input: s = "abcde", words = ["a","bb","acd","ace"]
     * Output: 3
     * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
     *
     * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
     * Output: 2
     *
     * @param s
     * @param words
     * @return
     */
    public int numMatchingSubseq(String s, String[] words) {

        int ans = 0;

        List<StringBuilder>[] waiting = new List[128];
        for(int c=0; c<='z'; c++)
        {
            waiting[c] = new ArrayList<>();
        }
        for(String w : words)
        {
            waiting[w.charAt(0)].add(new StringBuilder(w));
        }

        for(char c : s.toCharArray())
        {
            List<StringBuilder> advance = waiting[c];

            waiting[c] = new ArrayList<>();

            for(StringBuilder it : advance)
            {
                it.deleteCharAt(0);
                if(it.length() != 0)
                {
                    waiting[it.charAt(0)].add(it);
                }
                else
                {
                    ans++;
                }
            }
        }

        return ans;
    }
}
