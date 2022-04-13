package leetcode.tree.convert_bst_to_greater_tree;

/**
 * @author cy
 * @className TreeNode
 * @description TODO
 * @date 2021/9/14 20:07
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

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
