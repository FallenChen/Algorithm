package leetcode.hash_function.longest_duplicate_substring;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/26 17:34
 */
public class Solution {

    /**
     * Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times.
     * The occurrences may overlap.
     *
     * Return any duplicated substring that has the longest possible length.
     * If s does not have a duplicated substring, the answer is "".
     *
     * Input: s = "banana"
     * Output: "ana"
     *
     * Input: s = "abcd"
     * Output: ""
     *
     * @param s
     * @return
     */
    public String longestDupSubstring(String s) {

        if(s == null || s.length() == 0)
        {
            return s;
        }

        int l = 1, r = s.length() - 1;
        while (l < r)
        {
            int mid = l + (r - l)/2 + 1;
            if(findDuplicate(s,mid) != null)
            {
                l = mid;
            }
            else
            {
                r = mid - 1;
            }
        }

        String longestDuplicate = findDuplicate(s,l);
        return longestDuplicate == null ? "" : longestDuplicate;

    }

    private String findDuplicate(String str, int len) {
        // Maps a hash value of a window of length len to a list of starting indicates of windows of length that have that hash value
        Map<Long, List<Integer>> seen = new HashMap<>();

        // We represent a window with exactly one long value. We treat every window as a number in some base, the base is the size of the character set.
        long p = (1 << 31) - 1, base = 26, currHash = 0;
        // Compute hash of initial window of length len: str[0, len-1]
        for(int i=0; i<len; i++)
        {
            currHash = (currHash * base + str.charAt(i)) % p;
        }
        // Manually add hash of initial window to the map
        seen.put(currHash, new ArrayList<>());
        seen.get(currHash).add(0);

        // base of the most significant element in the window. We use this value during removals
        long baseShift = 1;
        for(int i=0; i<len - 1; i++)
        {
            baseShift = (baseShift * base) % p;
        }
        // Iterate through all other windows of length len, compute their hash, check if we found a duplicate window
        for(int i=1; i+len <= str.length(); i++)
        {
            // we efficiently (O(1) time) compute the hash of the current window by using the hash of the previous window
            currHash = (currHash + p - (baseShift * str.charAt(i - 1)) % p) % p; // remove str.charAt(i-1)
            currHash = ((currHash * base) % p + str.charAt(i + len - 1)) % p; // add str.charAt(i + len - 1)

            // check if the current window s[i, i+len - 1] is duplicate
            if(seen.containsKey(currHash))
            {
                String currWindow = str.substring(i, i+len);
                for(int startIdx: seen.get(currHash))
                {
                    if(currWindow.equals(str.substring(startIdx, startIdx + len)))
                    {
                        return currWindow;
                    }
                }
            }
            seen.putIfAbsent(currHash, new ArrayList<>());
            seen.get(currHash).add(i);
        }
        return null;
    }


}
