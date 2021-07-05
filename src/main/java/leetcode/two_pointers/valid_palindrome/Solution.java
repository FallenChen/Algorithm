package leetcode.two_pointers.valid_palindrome;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/5 17:26
 */
public class Solution {

    /**
     * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * <p>
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * <p>
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0;
        int tail = s.length() - 1;
        char cHead, cTail;
        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead))
            {
                head++;
            }
            else if (!Character.isLetterOrDigit(cTail))
            {
                tail--;
            }
            else
            {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail))
                {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

}
