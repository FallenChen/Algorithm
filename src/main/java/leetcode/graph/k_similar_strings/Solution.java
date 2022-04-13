package leetcode.graph.k_similar_strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/6/3 19:42
 */
public class Solution {

    /**
     * Strings s1 and s2 are k-similar (for some non-negative integer k) if we can swap the positions of two letters in s1 exactly k times so that the resulting string equals s2.
     *
     * Given two anagrams s1 and s2, return the smallest k for which s1 and s2 are k-similar.
     *
     *

     Example 1:

     Input: s1 = "ab", s2 = "ba"
     Output: 1

     Example 2:

     Input: s1 = "abc", s2 = "bca"
     Output: 2

     Example 3:

     Input: s1 = "abac", s2 = "baca"
     Output: 2

     Example 4:

     Input: s1 = "aabc", s2 = "abca"
     Output: 2

     * @param s1
     * @param s2
     * @return
     */
    public int kSimilarity(String s1, String s2)
    {
        if(s1.equals(s2))
            return 0;
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s1);
        vis.add(s1);
        int res = 0;
        while (!q.isEmpty())
        {
            res++;
            for(int sz = q.size();sz > 0; sz--)
            {
                String s = q.poll();
                int i=0;
                while (s.charAt(i) == s2.charAt(i))
                    i++;
                for(int j = i+1; j<s.length();j++)
                {
                    if((s.charAt(j) == s2.charAt(j)) || (s.charAt(j) !=s2.charAt(i)))
                        continue;
                    String temp = swap(s,i,j);
                    if(temp.equals(s2))
                        return res;
                    if(vis.add(temp))
                        q.add(temp);
                }
            }
        }
        return res;
    }

    public String swap(String s, int i, int j)
    {
        char[] ca = s.toCharArray();
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
        return new String(ca);
    }
}
