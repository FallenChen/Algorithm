package leetcode.hash_table.sort_characters_by_frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/20 19:35
 */
public class Solution {

    /**
     * Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string
     *
     * Input: s = "tree"
     * Output: "eert"
     * Explanation: 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     *
     * Input: s = "cccaaa"
     * Output: "aaaccc"
     * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     *
     * Input: s = "Aabb"
     * Output: "bbAa"
     * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        List<Character> [] bucket = new List[s.length() + 1];
        for(char key: map.keySet())
        {
            int frequency = map.get(key);
            if(bucket[frequency] == null)
            {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
        {
            if(bucket[pos] != null)
            {
                for(char c : bucket[pos])
                {
                    for(int i=0; i<pos; i++)
                    {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
