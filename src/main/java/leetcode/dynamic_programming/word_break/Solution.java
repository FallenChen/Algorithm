package leetcode.dynamic_programming.word_break;

import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/12/26 17:06
 */
public class Solution
{
    /**
     * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     *
     * Input: s = "leetcode", wordDict = ["leet","code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     *
     * Input: s = "applepenapple", wordDict = ["apple","pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     * Note that you are allowed to reuse a dictionary word.
     *
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: false
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict)
    {
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        for(int i=1; i<=s.length(); i++)
        {
            for(int j=0; j<i; j++)
            {
                if (f[j] && wordDict.contains(s.substring(j, i)))
                {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

}
