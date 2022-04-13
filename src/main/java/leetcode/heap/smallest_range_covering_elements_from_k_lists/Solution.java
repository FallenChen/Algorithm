package leetcode.heap.smallest_range_covering_elements_from_k_lists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/13 17:54
 */
public class Solution {

    /**
     * You have k lists of sorted integers in non-decreasing order.
     * Find the smallest range that includes at least one number from each of the k lists.
     *
     * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c
     *
     * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
     * Output: [20,24]
     * Explanation:
     * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
     * List 2: [0, 9, 12, 20], 20 is in range [20,24].
     * List 3: [5, 18, 22, 30], 22 is in range [20,24].
     *
     * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
     * Output: [1,1]
     *
     * Input: nums = [[10,10],[11,11]]
     * Output: [10,11]
     *
     * Input: nums = [[10],[11]]
     * Output: [10,11]
     *
     * Input: nums = [[1],[2],[3],[4],[5],[6],[7]]
     * Output: [1,7]
     *
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        // PriorityQueue
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));

        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            q.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (q.size() == nums.size()) {
            int e[] = q.poll(), row = e[0], col = e[1];
            if (end - start > max - nums.get(row).get(col)) {
                start = nums.get(row).get(col);
                end = max;
            }
            if (col + 1 < nums.get(row).size()) {
                q.offer(new int[]{row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }
        return new int[]{start, end};
    }
}
