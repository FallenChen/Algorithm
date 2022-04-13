package leetcode.binary_search.sqrtx;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/16 14:01
 */
public class Solution {

    /**
     * Given a non-negative integer x, compute and return the square root of x.
     *
     * Since the return type is an integer, the decimal digits are truncated,
     * and only the integer part of the result is returned.
     *
     * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
     *
     * Input: x = 4
     * Output: 2
     *
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
     *
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {

        if(x == 0)
        {
            return 0;
        }
        int left = 1, right = x;

        while (left + 1 < right)
        {
            int mid = (right - left)/2 + left;
            int division = x/mid;
            if(division == mid)
            {
                return mid;
            }
            else if(division < mid)
            {
                right = mid;
            }
            else
            {
                left = mid;
            }
        }
        if(x/right >= right)
        {
            return right;
        }
        return left;
    }
}
