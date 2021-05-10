package leetcode.implement_trie;

/**
 * @ClassName Trie
 * @Description TODO
 * @Author cy
 * @Date 2021/5/10 16:47
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root;

        for (int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null)
            {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null)
            {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i=0; i<prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null)
            {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return true;
    }

    static class TrieNode
    {
        public char val;

        public boolean isWord;

        public TrieNode[] children = new TrieNode[26];

        public TrieNode()
        {

        }

        public TrieNode(char val) {
            TrieNode trieNode = new TrieNode();
            trieNode.val = val;
        }
    }
}
