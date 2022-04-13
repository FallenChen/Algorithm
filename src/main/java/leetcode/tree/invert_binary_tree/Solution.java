package leetcode.tree.invert_binary_tree;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/5 20:26
 */
public class Solution {

    /**
     * Given the root of a binary tree, invert the tree, and return its root.
     *
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     *
     * Input: root = [2,1,3]
     * Output: [2,3,1]
     *
     * Input: root = []
     * Output: []
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final TreeNode left = root.left;
        final TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }
}
