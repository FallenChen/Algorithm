package leetcode.recursion.power_of_two;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/4 17:13
 */
public class Solution {

    /**
     * Given an integer n, return true if it is a power of two. Otherwise, return false.
     *
     * An integer n is a power of two, if there exists an integer x such that n == 2x.
     *
     * Input: n = 1
     * Output: true
     * Explanation: 20 = 1
     *
     * Input: n = 16
     * Output: true
     * Explanation: 24 = 16
     *
     * Input: n = 3
     * Output: false
     *
     * Input: n = 4
     * Output: true
     *
     * Input: n = 5
     * Output: false
     *
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n)
    {
        return (n>0&&((n&(n-1))==0));
    }
}
