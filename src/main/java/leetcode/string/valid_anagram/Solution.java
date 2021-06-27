package leetcode.string.valid_anagram;

import java.util.Arrays;

public class Solution {

    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     *
     * Input: s = "rat", t = "car"
     * Output: false
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

//        if(s.length() != t.length())
//        {
//            return false;
//        }
//
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//
//        return Arrays.equals(str1,str2);

        int[] alphabet = new int[26];
        for(int i=0; i<s.length();i++)
        {
            alphabet[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<t.length();i++)
        {
            alphabet[t.charAt(i) - 'a']--;
        }
        for(int i: alphabet)
        {
            if (i != 0)
            {
                return false;
            }
        }
        return true;

    }
}
