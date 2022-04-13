package leetcode.string.jewels_and_stones;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/25 19:59
 */
public class Solution {

    /**
     * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
     * Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
     *
     * Letters are case sensitive, so "a" is considered a different type of stone from "A".
     *
     * Input: jewels = "aA", stones = "aAAbbbb"
     * Output: 3
     *
     * Input: jewels = "z", stones = "ZZ"
     * Output: 0
     *
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        /**
         * replaceAll(String regex, String replacement) is a method of String objects
         * that replaces any parts of the string that matches the provided regular expression (regex) with
         * a replacement. In regex, "[ ]" matches characters that in the bracket;
         * e.g. "[abc]" matches any "a", "b", or "c". "[^ ]" matches characters not in the bracket;
         * e.g. "[^ab]" will match "c" in String "abc".
         * String J was concatenated to "[^" and "]" to create the regex "[^ (all characters in J) ]" in order to
         * replace any characters of S that is not in J with a blank "".
         */
        return stones.replaceAll("[^" + jewels + "]", "").length();
    }

}
