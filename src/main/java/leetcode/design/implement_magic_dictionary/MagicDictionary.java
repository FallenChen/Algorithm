package leetcode.design.implement_magic_dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cy
 * @className MagicDictionary
 * @description TODO
 * @date 2021/9/3 20:20
 */
public class MagicDictionary {

    /**
     * Design a data structure that is initialized with a list of different words.
     * Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.
     *
     * Implement the MagicDictionary class:
     *
     *     MagicDictionary() Initializes the object.
     *     void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
     *     bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure, otherwise returns false.
     *
     * Input
     * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
     * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
     * Output
     * [null, null, false, true, false, false]
     *
     * Explanation
     * MagicDictionary magicDictionary = new MagicDictionary();
     * magicDictionary.buildDict(["hello", "leetcode"]);
     * magicDictionary.search("hello"); // return False
     * magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
     * magicDictionary.search("hell"); // return False
     * magicDictionary.search("leetcoded"); // return False
     *
     *
     */

    Map<Integer, Set<String>> map;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for(String s : dictionary)
        {
            int len = s.length();
            if(!map.containsKey(len))
            {
                map.put(len, new HashSet<>());
            }
            map.get(len).add(s);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String searchWord) {
        int len = searchWord.length();
        if(!map.containsKey(len))
        {
            return false;
        }

        for(String s : map.get(len))
        {
            int count = 0;
            for(int i=0; i<len; i++)
            {
                if(searchWord.charAt(i) != s.charAt(i))
                {
                    count++;
                }
            }
            if(count == 1)
            {
                return true;
            }
        }
        return false;
    }
}
