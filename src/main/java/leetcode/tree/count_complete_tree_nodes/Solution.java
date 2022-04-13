package leetcode.tree.count_complete_tree_nodes;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/12/7 19:55
 */
public class Solution {

    /**
     * Given the root of a complete binary tree, return the number of the nodes in the tree.
     *
     * According to Wikipedia, every level, except possibly the last,
     * is completely filled in a complete binary tree,
     * and all nodes in the last level are as far left as possible.
     * It can have between 1 and 2h nodes inclusive at the last level h.
     *
     * Design an algorithm that runs in less than O(n) time complexity.
     *
     * Input: root = [1,2,3,4,5,6]
     * Output: 6
     *
     * Input: root = []
     * Output: 0
     *
     * Input: root = [1]
     * Output: 1
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null)
        {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);
        int treeNum = left + right + 1;

        return treeNum;
    }

}
