package leetcode.tree.maximum_depth_of_binary_tree;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/1 20:45
 */
public class Solution {

    /**
     * Given the root of a binary tree, return its maximum depth.
     *
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     *
     * Input: root = [1,null,2]
     * Output: 2
     *
     * Input: root = []
     * Output: 0
     *
     * Input: root = [0]
     * Output: 1
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
