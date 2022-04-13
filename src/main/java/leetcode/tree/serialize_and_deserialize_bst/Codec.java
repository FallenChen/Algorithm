package leetcode.tree.serialize_and_deserialize_bst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cy
 * @className Codec
 * @description TODO
 * @date 2021/7/30 17:01
 */
public class Codec {

    /**
     * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
     * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary search tree.
     * There is no restriction on how your serialization/deserialization algorithm should work.
     * You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
     *
     * The encoded string should be as compact as possible.
     *
     * Input: root = [2,1,3]
     * Output: [2,1,3]
     *
     * Input: root = []
     * Output: []
     *
     * @param root
     * @return
     */


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null)
        {
            sb.append("#").append(",");
        }else
        {
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> q) {
        String s = q.poll();
        if(s.equals("#"))
        {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }
}
