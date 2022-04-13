package leetcode.tree.maximum_depth_of_binary_tree;

/**
 * @author cy
 * @className TreeNode
 * @description
 * @date 2021/8/27 19:37
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode()
    {

    }

    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
