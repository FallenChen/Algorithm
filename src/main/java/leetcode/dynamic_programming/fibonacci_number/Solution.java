package leetcode.dynamic_programming.fibonacci_number;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/6/23 21:03
 */
public class Solution {

    /**
     * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
     * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
     * F(0) = 0, F(1) = 1
     * F(n) = F(n - 1) + F(n - 2), for n > 1.
     *
     * Given n, calculate F(n).
     *
     * Input: n = 2
     * Output: 1
     * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
     *
     * Input: n = 3
     * Output: 2
     * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
     *
     * Input: n = 4
     * Output: 3
     * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
     *
     * @param n
     * @return
     */

    // top-down approach using Memoization
    private Integer[] cache = new Integer[31];

    public int fib(int n) {
        // recursion
//        if(n <= 1)
//        {
//            return n;
//        }
//        return fib(n-1) + fib(n - 2);

        // bottom-up approach using memoization
//        if(n <= 1)
//        {
//            return n;
//        }
//
//        return memoize(n);
//
//    }
//
//    private int memoize(int n) {
//        int[] cache = new int[n + 1];
//        cache[1] = 1;
//
//        for (int i = 2; i<=n; i++)
//        {
//            cache[i] = cache[i-1] + cache[i - 2];
//        }
//        return cache[n];
//    }

        // top-down approach using memoization
        if (n <= 1)
        {
            return n;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize(n);
    }

    public int memoize(int n)
    {
        if(cache[n] != null)
        {
            return cache[n];
        }

        cache[n] = memoize(n-1) + memoize(n - 2);
        return memoize(n);
    }

}
