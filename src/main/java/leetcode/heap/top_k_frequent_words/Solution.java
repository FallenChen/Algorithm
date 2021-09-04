package leetcode.heap.top_k_frequent_words;

import java.util.*;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/4 19:35
 */
public class Solution {

    /**
     * Given an array of strings words and an integer k, return the k most frequent strings.
     *
     * Return the answer sorted by the frequency from highest to lowest.
     * Sort the words with the same frequency by their lexicographical order.
     *
     * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
     * Output: ["i","love"]
     * Explanation: "i" and "love" are the two most frequent words.
     * Note that "i" comes before "love" due to a lower alphabetical order.
     *
     * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
     * Output: ["the","is","sunny","day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
            {
                map.put(words[i], map.get(words[i])+1);
            }
            else
            {
                map.put(words[i], 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());

        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            pq.offer(entry);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }

        while (!pq.isEmpty())
        {
            result.add(0, pq.poll().getKey());
        }

        return result;
    }
}
