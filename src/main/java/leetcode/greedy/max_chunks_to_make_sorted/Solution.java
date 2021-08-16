package leetcode.greedy.max_chunks_to_make_sorted;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/16 16:04
 */
public class Solution {

    /**
     * You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
     *
     * We split arr into some number of chunks (i.e., partitions),
     * and individually sort each chunk. After concatenating them, the result should equal the sorted array.
     *
     * Return the largest number of chunks we can make to sort the array.
     *
     * Input: arr = [4,3,2,1,0]
     * Output: 1
     * Explanation:
     * Splitting into two or more chunks will not return the required result.
     * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
     *
     * Input: arr = [1,0,2,3,4]
     * Output: 4
     * Explanation:
     * We can split into two chunks, such as [1, 0], [2, 3, 4].
     * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
        {
            return 0;
        }

        // The basic idea is to use max[] array to keep track of the max value until the current position,
        // and compare it to the sorted array (indexes from 0 to arr.length - 1).
        // If the max[i] equals the element at index i in the sorted array, then the final count++.

        // the numbers range from 0 to arr.length - 1. So there is no need to sort the arr,
        // we can simply use the index for comparison.
        // Now this solution is even more straightforward with O(n) time complelxity.

        // original: 0, 2, 1, 4, 3, 5, 7, 6
        // max:      0, 2, 2, 4, 4, 5, 7, 7
        // sorted:   0, 1, 2, 3, 4, 5, 6, 7
        // index:    0, 1, 2, 3, 4, 5, 6, 7
        int count = 0, max = 0;
        for(int i=0; i<arr.length; i++)
        {
            max = Math.max(max, arr[i]);
            if(max == i)
            {
                count++;
            }
        }
        return count;
    }
}
