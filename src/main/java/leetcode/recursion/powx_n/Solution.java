package leetcode.recursion.powx_n;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/13 20:01
 */
public class Solution {

    /**
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     *
     * Input: x = 2.00000, n = 10
     * Output: 1024.00000
     *
     * Input: x = 2.10000, n = 3
     * Output: 9.26100
     *
     * Input: x = 2.00000, n = -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n)
    {
        if(n==0)
        {
            return 1;
        }
        if(n<0)
        {
            return 1/x * myPow(1/x,-(n+1));
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x,n/2);
    }
}
