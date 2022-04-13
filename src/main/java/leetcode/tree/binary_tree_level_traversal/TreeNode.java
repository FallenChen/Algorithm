package leetcode.tree.binary_tree_level_traversal;

/**
 * @author cy
 * @className TreeNode
 * @description
 * @date 2021/11/15 19:52
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val)
    {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
