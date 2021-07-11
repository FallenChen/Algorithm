package leetcode.heap.super_ugly_number;

import java.util.Arrays;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/10 19:36
 */
public class Solution {

    /**
     * A super ugly number is a positive integer whose prime factors are in the array primes.
     *
     * Given an integer n and an array of integers primes, return the nth super ugly number.
     *
     * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
     *
     * Input: n = 12, primes = [2,7,13,19]
     * Output: 32
     * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].
     *
     * Input: n = 1, primes = [2,3,5]
     * Output: 1
     * Explanation: 1 has no prime factors, therefore all of its prime factors are in the array primes = [2,3,5].
     *
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
//        int[] ugly = new int[n];
//        int[] idx = new int[primes.length];
//
//        ugly[0] = 1;
//
//        for(int i=1; i<n; i++)
//        {
//            // find next
//            ugly[i] = Integer.MAX_VALUE;
//            for(int j=0; j<primes.length;j++)
//            {
//                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
//            }
//            // slip duplicate
//            for(int j=0; j<primes.length; j++)
//            {
//                while (primes[j] * ugly[idx[j]] <= ugly[i])
//                {
//                    idx[j]++;
//                }
//            }
//        }
//        return ugly[n-1];

        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val,1);

        int next = 1;
        for(int i=0; i<n; i++)
        {
            ugly[i] = next;

            next = Integer.MAX_VALUE;
            for(int j=0; j<primes.length; j++)
            {
                // skip duplicate and avoid extra multiplication
                if(val[j] == ugly[i])
                {
                    val[j] = ugly[idx[j]++] * primes[j];
                }
                // find next ugly number
                next = Math.min(next, val[j]);
            }
        }
        return ugly[n-1];
    }
}
