package leetcode.trie.replace_words;

import java.util.List;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/15 20:12
 */
public class Solution {



    /**
     * In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor.
     * For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
     *
     * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it.
     * If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
     *
     * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
     * Output: "the cat was rat by the bat"
     *
     * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
     * Output: "a a b c"
     *
     * Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
     * Output: "a a a a a a a a bbb baba a"
     *
     * Input: dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
     * Output: "the cat was rat by the bat"
     *
     * Input: dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
     * Output: "it is ab that this solution is ac"
     *
     * Return the sentence after the replacement.
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence)
    {
        for(int i=0; i<dictionary.size(); i++)
        {
            add(dictionary.get(i));
        }
        String[] str = sentence.split(" ");
        for(int i=0; i<str.length; i++)
        {
            str[i] = findRoot(str[i]);
        }
        return String.join(" ",str);
    }


    class TrieNode
    {
        boolean isWorld;
        TrieNode[] next;
        TrieNode()
        {
            next = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    public void add(String word)
    {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++)
        {
            int c = word.charAt(i) - 'a';
            if(cur.next[c] == null)
            {
                cur.next[c] = new TrieNode();
            }
            cur = cur.next[c];
        }
        cur.isWorld = true;
    }

    public String findRoot(String word)
    {
        TrieNode cur = root;
        int i=0;
        for(; i<word.length(); i++)
        {
            int c = word.charAt(i) - 'a';
            if(cur.next[c] == null)
            {
                return word;
            }
            if(cur.next[c].isWorld)
            {
                return word.substring(0,i+1);
            }
            cur = cur.next[c];
        }
        return word;
    }

}
