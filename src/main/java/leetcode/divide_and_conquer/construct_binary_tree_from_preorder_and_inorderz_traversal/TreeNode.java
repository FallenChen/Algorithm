package leetcode.divide_and_conquer.construct_binary_tree_from_preorder_and_inorderz_traversal;

/**
 * @author cy
 * @className TreeNode
 * @description TODO
 * @date 2021/8/8 19:58
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
