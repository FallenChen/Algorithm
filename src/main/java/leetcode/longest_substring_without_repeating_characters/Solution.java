package leetcode.longest_substring_without_repeating_characters;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/5/12 17:39
 */
public class Solution {

    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length();

        int res = 0;

        for(int i=0; i< n;i++)
        {
            for (int j=i; j<n;j++)
            {
                if(checkRepetition(s,i,j))
                {
                    res = Math.max(res,j-i+1);
                }
            }
        }

        return res;
    }

    private boolean checkRepetition(String s, int start, int end) {

        int[] chars = new int[128];

        for(int i=start; i<=end; i++)
        {
            char c = s.charAt(i);
            // count for same value
            chars[c]++;
            if(chars[c] > 1)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("abcabcab");
        System.out.println(length);
    }
}
