package leetcode.sorting.group_anagrams;

import java.util.*;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/24 19:43
 */
public class Solution {

    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * Input: strs = [""]
     * Output: [[""]]
     *
     * Input: strs = ["a"]
     * Output: [["a"]]
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
        {
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for (String s : strs)
        {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr))
            {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
