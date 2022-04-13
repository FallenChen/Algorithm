package leetcode.breadth_first_search.perfect_squares;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/26 19:51
 */
public class Solution {

    /**
     * Given an integer n, return the least number of perfect square numbers that sum to n.
     *
     * A perfect square is an integer that is the square of an integer; in other words,
     * it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     *
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4.
     *
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9.
     *
     * @param n
     * @return
     */
    public int numSquares(int n)
    {
        // Start from node 0 in queue, and keep pushing in perfect square number + curr value,
        // once we reach number n, we found the solution
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        int depth = 0;

        while (!q.isEmpty())
        {
            int size = q.size();
            depth++;
            while (size-- > 0)
            {
                int u = q.poll();
                for(int i=1; i*i <= n; i++)
                {
                    int v = u + i*i;
                    if(v == n)
                    {
                        return depth;
                    }
                    if(v > n)
                    {
                        break;
                    }
                    if(!visited.contains(v))
                    {
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }
        }
        return depth;
    }
}
