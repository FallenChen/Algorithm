package leetcode.greedy.longest_palindrome;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/16 19:37
 */
public class Solution {

    /**
     * Given a string s which consists of lowercase or uppercase letters,
     * return the length of the longest palindrome that can be built with those letters.
     *
     * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
     *
     * Input: s = "abccccdd"
     * Output: 7
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     *
     * Input: s = "a"
     * Output: 1
     *
     * Input: s = "bb"
     * Output: 2
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        /**
         * For each letter, say it occurs v times.
         * We know we have v // 2 * 2 letters that can be partnered for sure.
         * For example, if we have 'aaaaa', then we could have 'aaaa' partnered,
         * which is 5 // 2 * 2 = 4 letters partnered.
         *
         * At the end, if there was any v % 2 == 1,
         * then that letter could have been a unique center.
         * Otherwise, every letter was partnered.
         * To perform this check, we will check for v % 2 == 1 and ans % 2 == 0,
         * the latter meaning we haven't yet added a unique center to the answer.
         */
        int[] count = new int[128];
        for(char c: s.toCharArray())
        {
            count[c]++;
        }

        int ans = 0;
        for(int v: count)
        {
            ans += v / 2 * 2;
            if(ans % 2 == 0 && v % 2 == 1)
            {
                ans++;
            }
        }
        return ans;
    }
}
