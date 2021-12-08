package leetcode.tree.balanced_binary_tree;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/8 20:15
 */
public class Solution {

    /**
     * Given a binary tree, determine if it is height-balanced.
     *
     * For this problem, a height-balanced binary tree is defined as:
     *
     *     a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: true
     *
     * Input: root = [1,2,2,3,3,null,null,4,4]
     * Output: false
     *
     * Input: root = []
     * Output: true
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null)
        {
            return 0;
        }
        int left = height(root.left);
        if(left == -1)
        {
            return -1;
        }

        int right = height(root.right);
        if (right == -1)
        {
            return -1;
        }

        if(left - right > 1 || right - left > 1)
        {
            return -1;
        }
        return Math.max(left, right) + 1;

    }
}
