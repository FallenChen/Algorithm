package leetcode.divide_and_conquer.find_the_kth_largest_integer_in_the_array;

import java.util.PriorityQueue;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/18 10:39
 */
public class Solution {

    /**
     * You are given an array of strings nums and an integer k. Each string in nums represents an integer without leading zeros.
     *
     * Return the string that represents the kth largest integer in nums.
     *
     * Note: Duplicate numbers should be counted distinctly.
     * For example, if nums is ["1","2","2"], "2" is the first largest integer, "2" is the second-largest integer,
     * and "1" is the third-largest integer.
     *
     * Input: nums = ["3","6","7","10"], k = 4
     * Output: "3"
     * Explanation:
     * The numbers in nums sorted in non-decreasing order are ["3","6","7","10"].
     * The 4th largest integer in nums is "3".
     *
     * Input: nums = ["2","21","12","1"], k = 3
     * Output: "2"
     * Explanation:
     * The numbers in nums sorted in non-decreasing order are ["1","2","12","21"].
     * The 3rd largest integer in nums is "2".
     *
     * Input: nums = ["0","0"], k = 2
     * Output: "0"
     * Explanation:
     * The numbers in nums sorted in non-decreasing order are ["0","0"].
     * The 2nd largest integer in nums is "0".
     *
     * @param nums
     * @param k
     * @return
     */
    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> minHeap = new PriorityQueue<>((o1,o2) -> {
            if(o1.length() == o2.length())
            {
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(),o2.length());
        });
        for(String num : nums)
        {
            minHeap.offer(num);
            if(minHeap.size() > k)
            {
                minHeap.poll();// pop the minimum value in the heap
            }
        }
        return minHeap.poll();
    }
}
