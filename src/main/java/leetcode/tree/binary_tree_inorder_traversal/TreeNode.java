package leetcode.tree.binary_tree_inorder_traversal;

/**
 * @author cy
 * @className TreeNode
 * @description TODO
 * @date 2021/6/29 17:31
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
