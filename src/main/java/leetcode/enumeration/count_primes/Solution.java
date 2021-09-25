package leetcode.enumeration.count_primes;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/25 19:22
 */
public class Solution {

    /**
     * Given an integer n, return the number of prime numbers that are strictly less than n.
     *
     * Input: n = 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     *
     * Input: n = 0
     * Output: 0
     *
     * Input: n = 1
     * Output: 0
     *
     * @param n
     * @return
     */
    public int countPrimes(int n)
    {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i=2; i<n; i++)
        {
            if(notPrime[i] == false)
            {
                count++;
                for (int j=2; i*j < n; j++)
                {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}
