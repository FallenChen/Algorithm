package leetcode.string.reverse_string;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/11 17:21
 */
public class Solution {

    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     *
     * You must do this by modifying the input array in-place with O(1) extra memory.
     *
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     *
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     *
     *
     * @param s
     */
    public static void reverseString(char[] s) {

        for(int i=0, j = s.length-1; i<s.length/2;i++,j--)
        {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }


}
