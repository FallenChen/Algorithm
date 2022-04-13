package leetcode.heap.top_k_frequent_elements;

import java.util.*;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/9 16:11
 */
public class Solution {

    /**
     * Given an integer array nums and an integer k, return the k most frequent elements.
     * You may return the answer in any order.
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k)
    {
        if(k == nums.length)
        {
            return nums;
        }

        // build hash map: character and how often it appears
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: nums)
        {
            count.put(n, count.getOrDefault(n,0)+1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1,n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for(int n: count.keySet())
        {
            heap.add(n);
            if(heap.size() > k)
            {
                heap.poll();
            }
        }

        // build an output array
        int[] top = new int[k];
        for(int i=k-1; i>=0; --i)
        {
            top[i] = heap.poll();
        }

        return top;

//        List<Integer>[] bucket = new List[nums.length + 1];
//        Map<Integer, Integer> frequencyMap = new HashMap<>();
//
//        for(int n: nums)
//        {
//            frequencyMap.put(n, frequencyMap.getOrDefault(n,0) + 1);
//        }
//
//        for(int key: frequencyMap.keySet())
//        {
//            int frequency = frequencyMap.get(key);
//            if(bucket[frequency] == null)
//            {
//                bucket[frequency] = new ArrayList<>();
//            }
//            bucket[frequency].add(key);
//        }
//
//        List<Integer> res = new ArrayList<>();
//
//        for(int pos = bucket.length -1 ;pos >=0 && res.size()<k; pos--)
//        {
//            if(bucket[pos] != null)
//            {
//                res.addAll(bucket[pos]);
//            }
//        }
//        return res;
    }
}
