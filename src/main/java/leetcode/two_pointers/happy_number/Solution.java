package leetcode.two_pointers.happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/3 14:17
 */
public class Solution {

    /**
     * Write an algorithm to determine if a number n is happy.
     *
     * A happy number is a number defined by the following process:
     *
     *     Starting with any positive integer, replace the number by the sum of the squares of its digits.
     *     Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     *     Those numbers for which this process ends in 1 are happy.
     *
     * Return true if n is a happy number, and false if not.
     *
     * Input: n = 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     *
     * Input: n = 2
     * Output: false
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n)
    {
//        Set<Integer> seen = new HashSet<>();
//        while (n != 1 && !seen.contains(n))
//        {
//            seen.add(n);
//            n = getNext(n);
//        }
//        return n == 1;

        // check if a linked list is circular
        // Floyd Cycle detection algorithm
        int slowRunner = n;
        int fastRunner = getNext(n);

        while (fastRunner != 1 && slowRunner != fastRunner)
        {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    /**
     * 1.最终会得到1 7 -> 1
     * 2.最终会进入循环 116 -> 58
     * 3.值会越来越大，最后接近无穷大
     * @param n
     * @return
     */
    private int getNext(int n)
    {
        int totalSum = 0;
        while (n > 0)
        {
            int d = n %10;
            n = n /10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
