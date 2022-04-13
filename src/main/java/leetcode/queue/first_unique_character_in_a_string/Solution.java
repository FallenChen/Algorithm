package leetcode.queue.first_unique_character_in_a_string;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/3 17:23
 */
public class Solution {

    /**
     * Given a string s, find the first non-repeating character in it and return its index.
     * If it does not exist, return -1.
     *
     * Input: s = "leetcode"
     * Output: 0
     *
     * Input: s = "loveleetcode"
     * Output: 2
     *
     * Input: s = "aabb"
     * Output: -1
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {

        int freq[] = new int[26];
        for(int i=0; i<s.length();i++)
        {
            freq[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<s.length(); i++)
        {
            if(freq[s.charAt(i) - 'a'] == 1)
            {
                return i;
            }
        }

        return -1;
    }
}
